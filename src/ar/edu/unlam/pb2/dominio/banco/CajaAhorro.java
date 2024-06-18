package ar.edu.unlam.pb2.dominio.banco;

public class CajaAhorro extends Cuenta implements Impresion {

	public CajaAhorro(Cliente cliente, Double saldo, Integer numeroCuenta) {
		super(cliente, saldo, numeroCuenta);
	}

	@Override
	public String imprimirComprobante() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean extraerDinero(Double monto) {
		// TODO Auto-generated method stub
		return null;
	}

}
