package logic;

public abstract class Personal {

	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected String password;
	protected double salarioMes;
	
	public Personal(String cedula, String nombre, String telefono, String direccion, String password,
			double salarioMes) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.password = password;
		this.salarioMes = salarioMes;
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
	
	public abstract double CalSalario();
	
}	
