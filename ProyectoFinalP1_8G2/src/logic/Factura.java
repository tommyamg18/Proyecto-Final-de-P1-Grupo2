package logic;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private String codFact;
	private Cliente micliente;
	private Comercial empleado;
	private ArrayList<Plan> misPlanes;
	private Date fecha;
	private double total;
	private boolean pagada;
	
	
	
	

	public Factura(String codFact, Cliente micliente, Comercial empleado, ArrayList<Plan> misPlanes,double total, boolean pagada) {
		super();
		this.codFact = codFact;
		this.micliente = micliente;
		this.empleado = empleado;
		this.misPlanes = misPlanes;
		this.fecha = new Date();
		this.total = total;
		this.pagada = pagada;
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



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public boolean isPagada() {
		return pagada;
	}



	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	
}
