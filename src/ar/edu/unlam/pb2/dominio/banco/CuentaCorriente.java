package ar.edu.unlam.pb2.dominio.banco;

public class CuentaCorriente extends Cuenta{

	private Double descubierto;
	
	public CuentaCorriente(Cliente cliente, Double saldo, Integer numeroCuenta, Double descubierto) {
		super(cliente, saldo, numeroCuenta);
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		// TODO Auto-generated method stub
		return null;
	}

}
