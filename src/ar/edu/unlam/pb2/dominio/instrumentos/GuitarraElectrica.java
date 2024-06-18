package ar.edu.unlam.pb2.dominio.instrumentos;

public class GuitarraElectrica extends Instrumento {
	private final Double PORCENTAJE_GANANCIA = 1.1;

	private Integer cantidadDeCuerdas;
	private Boolean microfonosActivos;

	public GuitarraElectrica(Integer codigo, Integer cantidadDeCuerdas, Boolean microfonosActivos, Integer stock, String color,
			String marca, String modelo, Integer anioFabricacion, Double precioBase) {

		super(codigo, color, marca, stock, modelo, anioFabricacion, precioBase);
		this.cantidadDeCuerdas = cantidadDeCuerdas;
		this.microfonosActivos = microfonosActivos;
	}

	@Override
	public String emitirSonido() {
		return "Sonido de guitarra";
	}

	@Override
	public Double obtenerPrecio() {
		return this.getPrecioBase() * PORCENTAJE_GANANCIA;
	}

	

}
