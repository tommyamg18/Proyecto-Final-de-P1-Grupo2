package logic;

public class Comercial extends Personal {

	private int cantventas;
	
	
	public Comercial(String cedula, String nombre, String telefono, String direccion, String password,
			double salarioMes,String tipo, int cantventas) {
		super(cedula, nombre, telefono, direccion, password, salarioMes,tipo);
		this.cantventas = cantventas;
	}


	@Override
	public double CalSalario() {
		double salariototal = 0;
		salariototal = (salarioMes + (cantventas*0.10));
		return salariototal;
	}


	public int getCantventas() {
		return cantventas;
	}


	public void setCantventas(int cantventas) {
		this.cantventas = cantventas;
	}

}
