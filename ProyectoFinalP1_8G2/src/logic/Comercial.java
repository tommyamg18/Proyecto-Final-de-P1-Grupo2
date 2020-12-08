package logic;

import java.io.Serializable;

public class Comercial extends Personal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6983120335345839125L;
	private int cantventas;
	
	
	public Comercial(String cedula, String nombre, String telefono, String direccion, String password,
			double salarioMes,String tipo, int cantventas) {
		super(cedula, nombre, telefono, direccion, password, salarioMes,tipo);
		this.cantventas = cantventas;
	}


	


	public int getCantventas() {
		return cantventas;
	}


	public void setCantventas(int cantventas) {
		this.cantventas = cantventas;
	}

}
