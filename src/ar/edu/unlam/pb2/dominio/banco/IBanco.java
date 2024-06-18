package ar.edu.unlam.pb2.dominio.banco;

public interface IBanco {

	Boolean agregarCuenta(Cuenta cuenta);
	Boolean agregarCliente(Cliente cliente);
	void extraerDineroDeCuenta(Integer numeroCuenta, Double monto);
	void ingresarDineroEnCuenta(Integer numeroCuenta, Double monto);
}
