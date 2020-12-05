package logic;

public class Administrativo extends Personal {

	private String puesto;
	

	public Administrativo(String cedula, String nombre, String telefono, String direccion, String password,
			double salarioMes, String puesto) {
		super(cedula, nombre, telefono, direccion, password, salarioMes);
		this.puesto = puesto;
	}

	@Override
	public double CalSalario() {
		double salario = 0;
		salario = salarioMes;
		return salario;
	}


	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
