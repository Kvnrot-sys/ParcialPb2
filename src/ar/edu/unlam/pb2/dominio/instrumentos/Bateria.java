package ar.edu.unlam.pb2.dominio.instrumentos;

public class Bateria extends Instrumento {

	private final Double PRECIO_TAMBOR = 500.0;
	private final Double PRECIO_PLATILLO = 200.0;

	private Integer cantidadTambores;
	private Integer cantidadPlatillos;

	public Bateria(Integer codigo, Integer cantidadTambores, Integer cantidadPlatillos, String color, String marca,
			String modelo, Integer anioFabricacion, Integer stock, Double precioBase) {

		super(codigo, color, marca, stock, modelo, anioFabricacion, precioBase);
		this.cantidadTambores = cantidadTambores;
		this.cantidadPlatillos = cantidadPlatillos;
	}

	public Integer getCantidadTambores() {
		return cantidadTambores;
	}

	public void setCantidadTambores(Integer cantidadTambores) {
		this.cantidadTambores = cantidadTambores;
	}

	public Integer getCantidadPlatillos() {
		return cantidadPlatillos;
	}

	public void setCantidadPlatillos(Integer cantidadPlatillos) {
		this.cantidadPlatillos = cantidadPlatillos;
	}

	@Override
	public String emitirSonido() {
		return "Budum tassh";
	}

	@Override
	public Double obtenerPrecio() {
		
		Double precioTambores = this.getCantidadTambores() * PRECIO_TAMBOR;
		Double precioPlatillos = this.getCantidadPlatillos() * PRECIO_PLATILLO;
		
		return this.getPrecioBase() + precioTambores + precioPlatillos;
	}

}
