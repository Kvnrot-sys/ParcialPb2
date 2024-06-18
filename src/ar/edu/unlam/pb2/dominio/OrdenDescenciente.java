package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;

import ar.edu.unlam.pb2.dominio.instrumentos.Instrumento;

public class OrdenDescenciente implements Comparator<Instrumento> {

	@Override
	public int compare(Instrumento o1, Instrumento o2) {
		// TODO Auto-generated method stub
		/*
		si <0 es menor
		si = 0 duplicado elimino
		si >0 es mayor
		*/
		
		
		return o2.getCodigo().compareTo(o1.getCodigo());
	}

}
