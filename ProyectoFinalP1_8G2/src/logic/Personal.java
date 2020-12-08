package logic;

import java.io.Serializable;

public class Personal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6401532974104750163L;
	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected String password;
	protected double salarioMes;
	private String tipo;

	
	public Personal(String cedula, String nombre, String telefono, String direccion, String password,
			double salarioMes, String tipo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.password = password;
		this.salarioMes = salarioMes;
		this.tipo = tipo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalarioMes() {
		return salarioMes;
	}

	public void setSalarioMes(double salarioMes) {
		this.salarioMes = salarioMes;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}	
