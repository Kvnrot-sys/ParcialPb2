package ar.edu.unlam.pb2.dominio.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco implements IBanco {
	List<Cuenta> cuentas;

	public Banco() {
		this.cuentas = new ArrayList<>(); 
	}

	@Override
	public Boolean agregarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void extraerDineroDeCuenta(Integer numeroCuenta, Double monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ingresarDineroEnCuenta(Integer numeroCuenta, Double monto) {
		// TODO Auto-generated method stub
		
	}
}
