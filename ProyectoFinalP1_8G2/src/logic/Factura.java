package logic;

import java.util.ArrayList;

public class Factura {
	
	private String codFact;
	private Cliente micliente;
	private Comercial empleado;
	private ArrayList<Plan> misPlanes;
	
	public Factura(String codFact, Cliente micliente, Comercial empleado, ArrayList<Plan> misPlanes) {
		super();
		this.codFact = codFact;
		this.micliente = micliente;
		this.empleado = empleado;
		this.misPlanes = new ArrayList<>();
	}
	
	

	public Factura(Cliente client, Factura fact1) {
		// TODO Auto-generated constructor stub
	}



	public double calTotal() {
		double total = 0;
		
		return total;
	}

	public String getCodFact() {
		return codFact;
	}

	public void setCodFact(String codFact) {
		this.codFact = codFact;
	}

	public Cliente getMicliente() {
		return micliente;
	}

	public void setMicliente(Cliente micliente) {
		this.micliente = micliente;
	}

	public Comercial getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Comercial empleado) {
		this.empleado = empleado;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}
	
}
