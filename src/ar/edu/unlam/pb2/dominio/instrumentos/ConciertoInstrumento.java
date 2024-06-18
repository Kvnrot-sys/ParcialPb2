package ar.edu.unlam.pb2.dominio.instrumentos;

import java.util.Objects;

public class ConciertoInstrumento {

	// Concierto: 1 ------- Instrumento: 1
	// Concierto: 1 ------- Instrumento: 2
	// Concierto: 1 ------- Instrumento: 3

	// Concierto: 2 ------- Instrumento: 1
	// Concierto: 2 ------- Instrumento: 4

	private Concierto concierto;
	private Instrumento instrumento;

	public ConciertoInstrumento(Concierto concierto, Instrumento instrumento) {
		this.concierto = concierto;
		this.instrumento = instrumento;
	}

	public Concierto getConcierto() {
		return this.concierto;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	public Instrumento getInstrumento() {
		return this.instrumento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(concierto, instrumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConciertoInstrumento other = (ConciertoInstrumento) obj;
		return Objects.equals(concierto, other.concierto) && Objects.equals(instrumento, other.instrumento);
	}
	
	
}
