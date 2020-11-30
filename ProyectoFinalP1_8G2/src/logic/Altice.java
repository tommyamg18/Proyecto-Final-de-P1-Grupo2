package logic;
                                                        
import java.util.ArrayList;

import logic.Cliente;
import logic.Factura;

public class Altice {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Personal> miPersonal;
	private static Altice altice = null;
	
	public Altice() {
		super();
		this.misClientes = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.miPersonal = new ArrayList<>();
	}
	
	public static Altice getInstance() {
		if(altice==null) {
			altice = new Altice();
		}
		return altice;
	}
		
	
	public Plan consultarPlan(String cod){
		Plan plan = null;
		boolean encontrado = false;
		int i = 0;
		while(encontrado==false && i<misPlanes.size()) {
			if(misPlanes.get(i).getCodPlan().equalsIgnoreCase(cod)) {
				plan = misPlanes.get(i);
				encontrado = true;	
			}
			i++;
		}
		return plan;
	}
	
	public Plan consultaPlanNumero(String num){
		Plan plan = null;
		boolean encontrado = false;
		for (Plan miPlan : misPlanes) {
			if(miPlan.getNumero().equalsIgnoreCase(num) && !encontrado) {
			plan= miPlan;
			encontrado = true;
			}
		}
		return plan;
	
	}
	
	public Cliente buscarCliente(String cedula) {
		Cliente client= null;
		boolean encontrado = false;
		int i=0;
		while(encontrado==false && i<misClientes.size()) {
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				client= misClientes.get(i);
				encontrado = true;	
			}
			i++;
		}
		return client;
		
	}
	
	public Factura buscarCodigo(String codigo) {
		Factura factura = null;
		boolean encontrado = false;
		int i=0;
		while (i<misFacturas.size() && encontrado==false) {
			if(misFacturas.get(i).getCodFact().equalsIgnoreCase(codigo)){
				factura = misFacturas.get(i);
				encontrado = true;
			}
			i++;
		}
		return factura;
	}
	
	public void crearPlan(Plan plan) {
		misPlanes.add(plan);
	}
	
	public void registrarCliente(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public void registrarPersonal(Personal personal) {
		miPersonal.add(personal);
	}
	
	public void crearFactura(Factura factura) {
		//int fact = facturas.size()+1;
		//factura.setCodFactura(Integer.toString(fact));
		misFacturas.add(factura);
	}
	
	public void eliminarCliente(Cliente cliente) {
		boolean encontrado = false;
		int i = 0;
		if(chequeoCliente(cliente.getCedula())) {
		while(!encontrado && i<misClientes.size()){
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cliente.getCedula())) {
				misClientes.remove(i);
				encontrado = true;
			}
			i++;
		}
		}
	}
	
	private boolean chequeoCliente(String cedula) {//
		boolean aux = false;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misClientes.size()){
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = true;
				encontrado = true;
			}
			i++;
		}
		return aux;
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
