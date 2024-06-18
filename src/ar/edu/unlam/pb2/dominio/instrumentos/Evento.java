package ar.edu.unlam.pb2.dominio.instrumentos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Evento {

	private String nombre;
	private LocalDate dia;
	private LocalTime horaDeInicio;
	private LocalTime horaDeFin;
	private HashSet<ConciertoInstrumento> conciertosInstrumentos;

	public Evento(String nombre, LocalDate dia, LocalTime horaDeInicio, LocalTime horaDeFin) {
		this.nombre = nombre;
		this.dia = dia;
		this.horaDeInicio = horaDeInicio;
		this.horaDeFin = horaDeFin;
		this.conciertosInstrumentos = new HashSet<>();
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(dia, horaDeFin, horaDeInicio, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(dia, other.dia) && Objects.equals(horaDeFin, other.horaDeFin)
				&& Objects.equals(horaDeInicio, other.horaDeInicio) && Objects.equals(nombre, other.nombre);
	}

	public Boolean agregarConcierto(Concierto concierto) {
		ConciertoInstrumento conciertoInstrumento = new ConciertoInstrumento(concierto, null);
		return this.conciertosInstrumentos.add(conciertoInstrumento);
	}


	public HashSet<ConciertoInstrumento> getConciertosInstrumentos() {
		return this.conciertosInstrumentos;
	}


	public Boolean agregarConciertoInstrumento(ConciertoInstrumento conciertoInstrumento) {
		return this.conciertosInstrumentos.add(conciertoInstrumento);
	}
}
