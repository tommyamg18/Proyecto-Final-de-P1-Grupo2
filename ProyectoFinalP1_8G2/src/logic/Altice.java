package logic;

import java.util.ArrayList;

public class Altice {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Personal> miPersonal;
	
	public Altice(ArrayList<Cliente> misClientes, ArrayList<Plan> misPlanes, ArrayList<Factura> misFacturas,
			ArrayList<Personal> miPersonal) {
		super();
		this.misClientes = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.miPersonal = new ArrayList<>();
	}
	
	public Plan consultarPlan(){
	
		return null;
	}
	
	public Plan consultaPlanNumero(){
		
		return null;
	}
	
	public ArrayList<String> consultAlServicioMs(){
		return null;		
	}
	
	public void actualizarEstadoFact() {
		
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public ArrayList<Personal> getMiPersonal() {
		return miPersonal;
	}

	public void setMiPersonal(ArrayList<Personal> miPersonal) {
		this.miPersonal = miPersonal;
	} 
	
	

}
