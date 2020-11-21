package logic;

public class Administrativo extends Personal {

	private double extraMenAdm;
	
	public Administrativo(String cedula, String nombre, float salariobase, int antiguedadAnnos, int diasTrabajados,
			double salarioMes, double extraMenAdm) {
		super(cedula, nombre, salariobase, antiguedadAnnos, diasTrabajados, salarioMes);
		this.extraMenAdm = extraMenAdm;
	}

	public double getExtraMen() {
		return extraMenAdm;
	}

	public void setExtraMen(double extraMenAdm) {
		this.extraMenAdm = extraMenAdm;
	}

	@Override
	public double CalSalario() {
		return 0;
	}

}
