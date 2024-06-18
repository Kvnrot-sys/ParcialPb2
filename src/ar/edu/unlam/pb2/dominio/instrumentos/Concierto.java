package ar.edu.unlam.pb2.dominio.instrumentos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Concierto {

	private String nombre;

	public Concierto(Integer id, String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concierto other = (Concierto) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
}

// Cancha ofrece muchos eventos
// Cada evento incluye muchos conciertos
// En cada concierto se usan muchos instrumentos

// Casa 1 -- n Evento 1 -- n Conciertos 1 -- n Instrumentos
// Casa 1 -- n Evento 1 -- n Conciertos n -- 1 Instrumentos

// Casa 1 -- n Evento 1 -- n ConciertoInstrumento
