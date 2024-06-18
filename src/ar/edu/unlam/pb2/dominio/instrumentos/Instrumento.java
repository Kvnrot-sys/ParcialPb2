package ar.edu.unlam.pb2.dominio.instrumentos;

public abstract class Instrumento implements Comparable<Instrumento>{

	Integer codigo;
	private String color;
	private String marca;
	private String modelo;
	private Integer anioFabricacion;
	private Integer stock;
	private Double precioBase;

	public Instrumento(Integer codigo, String color, String marca, Integer stock, String modelo, Integer anioFabricacion, Double precioBase) {
		this.codigo = codigo;
		this.color = color;
		this.marca = marca;
		this.stock = stock;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.precioBase = precioBase;
	}
	
	public abstract String emitirSonido();
	public abstract Double obtenerPrecio();

	public Integer getCodigo() {
		return this.codigo;
	}
	
	public Double getPrecioBase() {
		return this.precioBase;
	}
	
	@Override
	public int compareTo(Instrumento o) {
		// TODO Auto-generated method stub
		return this.codigo.compareTo(o.getCodigo());
	}
	
}
