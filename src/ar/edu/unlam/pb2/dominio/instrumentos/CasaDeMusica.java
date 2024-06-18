package ar.edu.unlam.pb2.dominio.instrumentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import ar.edu.unlam.pb2.dominio.OrdenDescenciente;

public class CasaDeMusica implements ICasaDeMusica {

	private String nombre;
	private List<Instrumento> instrumentos;
	List<Evento> eventos;

	public CasaDeMusica(String nombre) {
		this.nombre = nombre;
		this.instrumentos = new ArrayList<>();
		this.eventos = new ArrayList<>();
	}

	@Override
	public Boolean agregarInstrumento(Instrumento instrumento) {
		return instrumentos.add(instrumento);
	}

	@Override
	public Instrumento buscarInstrumentoPorCodigo(Integer codigo) {
		Instrumento instrumento = null;

		for (Instrumento i : this.instrumentos) {

			if (i.getCodigo().equals(codigo)) {
				instrumento = i;
				break;
			}
		}

		return instrumento;
	}

	@Override
	public Double obtenerPrecioInstrumento(Integer codigo) {
		Instrumento instrumento = this.buscarInstrumentoPorCodigo(codigo);
		return instrumento.obtenerPrecio();
	}

	@Override
	public Boolean agregarEvento(Evento evento) {
		return this.eventos.add(evento);
	}

	@Override
	public Boolean agregarConciertoAEvento(Evento evento, Concierto concierto) {
		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				e.agregarConcierto(concierto);
				return true;
			}
		}
		return null;
	}

	@Override
	public Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto, Instrumento instrumento) {

		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				for (ConciertoInstrumento ci : e.getConciertosInstrumentos()) {

					if (ci.getConcierto().equals(concierto)) {
						ci.setInstrumento(instrumento);
						return true;
					}
				}

			}
		}
		return null;
	}

	@Override
	public Boolean agregarConciertoInstrumentoAEvento(Evento evento, Concierto concierto, Instrumento instrumento) {

//		
//		if(verificoSiElInstrumentoExistesEnELConcierto(evento,concierto,instrumento))
//			return null;
//		
		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				e.agregarConciertoInstrumento(new ConciertoInstrumento(concierto, instrumento));
				return true;

			}
		}

		return null;
	}

	private boolean verificoSiElInstrumentoExistesEnELConcierto(Evento evento, Concierto concierto,
			Instrumento instrumento) {
	
		List<Instrumento> instrumentosDeuNConcierto = this.obtenerLosInstrumentosDeUnConciertoParaUnEvento(evento, concierto);
		
		if (instrumentosDeuNConcierto.contains(instrumento))		
			return true;
				
		return false;
	}

	@Override
	public List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento, Concierto concierto) {
		List<Instrumento> instrumentosDelConcierto = new ArrayList<>();
		
		for (Evento e : this.eventos) {

			if (e.equals(evento)) {

				for (ConciertoInstrumento ci : e.getConciertosInstrumentos()) {

					if (ci.getConcierto().equals(concierto)) {
						
						instrumentosDelConcierto.add(ci.getInstrumento());
						
					}
				}

			}
		}

		return instrumentosDelConcierto;
	}

	public List<Instrumento> obtenerInstrumentosGuitarraElectrica() {
		List<Instrumento> instrumentosGuitarraElectrica = new ArrayList<>();

		for (Instrumento instrumento : this.instrumentos) {

			if (instrumento instanceof GuitarraElectrica) {
				instrumentosGuitarraElectrica.add(instrumento);
			}
		}

		return instrumentosGuitarraElectrica;
	}

	public List<Instrumento> obtenerInstrumentos() {
		Collections.sort(instrumentos, (o1, o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
		//Collections.sort(instrumentos, new OrdenDescenciente());
		return this.instrumentos;
	}
	 
	public HashSet <Instrumento> obtenerInstrumentosSinRepetir(){
		
		 HashSet <Instrumento> instrumentosNoRepetidos = new  HashSet <Instrumento>();
		 
		 instrumentosNoRepetidos.addAll(this.instrumentos);
		 return instrumentosNoRepetidos;
				
			 	
	}
	
	public TreeSet <Instrumento> obtenerInstrumentosOrdenadosPorNatural(){
		
		TreeSet <Instrumento> instrumentosNoRepetidos = new  TreeSet <Instrumento>();
		 
		for (Instrumento instrumento : instrumentos) {
			instrumentosNoRepetidos.add(instrumento);
		}
		
		 //instrumentosNoRepetidos.addAll(this.instrumentos);
		 return instrumentosNoRepetidos;
				
			 	
	}

	

	public TreeSet <Instrumento> obtenerInstrumentosOrdenadosOrdenEspecifico(Comparator <Instrumento> OrdenEspecifico){
		
		TreeSet <Instrumento> instrumentosNoRepetidos = new  TreeSet <Instrumento>(OrdenEspecifico);
		 
 		
		 instrumentosNoRepetidos.addAll(this.instrumentos);
		 return instrumentosNoRepetidos;
				
			 	
	}

}
