package logic;

public class Comercial extends Personal {

	private double extraMenCom;
	
	public Comercial(String cedula, String nombre, float salariobase, int antiguedadAnnos, int diasTrabajados,
			double salarioMes, double extraMenCom) {
		super(cedula, nombre, salariobase, antiguedadAnnos, diasTrabajados, salarioMes);
		this.extraMenCom = extraMenCom;
	}

	public double getExtraMen() {
		return extraMenCom;
	}

	public void setExtraMen(double extraMenCom) {
		this.extraMenCom = extraMenCom;
	}

	@Override
	public double CalSalario() {
		return 0;
	}

}
