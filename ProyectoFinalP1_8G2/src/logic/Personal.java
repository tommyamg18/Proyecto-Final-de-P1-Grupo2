package logic;

public abstract class Personal {

	protected String cedula;
	protected String nombre;
	protected float salariobase;
	protected int AntiguedadAnnos;
	protected int diasTrabajados;
	protected double salarioMes;
	
	public Personal(String cedula, String nombre, float salariobase, int antiguedadAnnos, int diasTrabajados,
			double salarioMes) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.salariobase = salariobase;
		this.AntiguedadAnnos = antiguedadAnnos;
		this.diasTrabajados = diasTrabajados;
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

	public float getSalariobase() {
		return salariobase;
	}

	public void setSalariobase(float salariobase) {
		this.salariobase = salariobase;
	}

	public int getAntiguedadAnnos() {
		return AntiguedadAnnos;
	}

	public void setAntiguedadAnnos(int antiguedadAnnos) {
		AntiguedadAnnos = antiguedadAnnos;
	}

	public int getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public double getSalarioMes() {
		return salarioMes;
	}

	public void setSalarioMes(double salarioMes) {
		this.salarioMes = salarioMes;
	}
	
	public abstract double CalSalario();
}
