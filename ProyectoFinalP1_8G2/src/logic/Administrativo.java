package logic;

import java.io.Serializable;

public class Administrativo extends Personal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2414546833548393578L;
	private String puesto;
	

	public Administrativo(String cedula, String nombre, String telefono, String direccion, String password,
			double salarioMes,String tipo, String puesto) {
		super(cedula, nombre, telefono, direccion, password, salarioMes,tipo);
		this.puesto = puesto;
	}

	


	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
