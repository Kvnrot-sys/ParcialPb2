package ar.edu.unlam.pb2.dominio.instrumentos;

import java.util.List;

public interface ICasaDeMusica {
	
	Boolean agregarInstrumento(Instrumento instrumento);
	Instrumento buscarInstrumentoPorCodigo(Integer codigo);
	Double obtenerPrecioInstrumento(Integer codigo);
	Boolean agregarEvento(Evento evento);
	/**
	 * Agrega un concierto a un evento
	 * */
	Boolean agregarConciertoAEvento(Evento evento, Concierto concierto);
	Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto,
			Instrumento instrumento);
	Boolean agregarConciertoInstrumentoAEvento(Evento evento, Concierto concierto,
			Instrumento instrumento);
	List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento, Concierto concierto);
}
