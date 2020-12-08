package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4486778712447281638L;
	private String codFact;
	private int nunCon;
	public int getNunCon() {
		return nunCon;
	}


	public void setNunCon(int nunCon) {
		this.nunCon = nunCon;
	}


	private Cliente micliente;
	private Comercial empleado;
	private ArrayList<Plan> misPlanes;
	private Date fecha;
	private double mora;
	private double total;
	private boolean pagada;
	
	
	

	public Factura(String codFact, Cliente micliente, Comercial empleado, ArrayList<Plan> misPlanes,double total, boolean pagada, int nunCon) {
		super();
		this.codFact = codFact;
		this.micliente = micliente;
		this.empleado = empleado;
		this.misPlanes = misPlanes;
		this.fecha = new Date();
		this.total = total;
		this.pagada = pagada;
		this.mora = 0;
		this.nunCon=nunCon;
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


	public double getMora() {
		return mora;
	}


	public void setMora(double mora) {
		this.mora = mora;
	}
	
}
