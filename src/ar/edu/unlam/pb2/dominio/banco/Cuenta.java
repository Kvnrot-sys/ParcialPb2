package ar.edu.unlam.pb2.dominio.banco;

public abstract class Cuenta {

	private Cliente cliente;
	private Double saldo;
	private Integer numeroCuenta;
	// private TipoCuenta tipoCuenta;

	public Cuenta(Cliente cliente, Double saldo, Integer numeroCuenta) {
		this.cliente = cliente;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}

	public abstract Boolean extraerDinero(Double monto);

	public Boolean ingresarDinero(Double monto) {
		this.saldo += monto;
		return true;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
