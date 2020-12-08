package logic;
                                                        

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class Altice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1939787058676206905L;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Personal> miPersonal;
	private static Altice altice = null;
	public static Cliente miCliente;
	public static Factura factura;
	private static Personal loginPersonal;
	private static Personal administrador;
	

	public int planCod = 1;
	public int nunCon = 1;
	
	public int factCod = 1;
	public int auxPlanCod;
	public int auxFactCod;
	public int auxnunCon;
	
	public Altice() {
		super();
		this.misClientes = new ArrayList<>();
		this.misPlanes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.miPersonal = new ArrayList<>();
		this.administrador = new Personal("0", "", "", "", "0", -1, "ADM");
	}
	
	public static Altice getInstance() {
		if(altice==null) {
			altice = new Altice();
		}
		return altice;
	}
	public int getNunCon() {
		return nunCon;
	}

	public void setNunCon(int nunCon) {
		this.nunCon = nunCon;
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
	
	public ArrayList<Integer> cantidadUsuariosCadaPlan(){
		ArrayList<Integer> cantidad = new ArrayList<>();

		int cantVoz = 0;
		int cantInternet= 0;
		int cantCable = 0;
		int cantVozCable = 0;
		int cantVozInternet = 0;
		int cantCableInternet = 0;
		int cantTriple = 0;
		
		for (Cliente cliente: misClientes) {
			System.out.println(cliente.getCedula());
		for (Plan plan : cliente.getMisPlanes()) {
			if(plan.getNombre().equalsIgnoreCase("Solo Cable")) {
				cantCable++;
			} else if(plan.getNombre().equalsIgnoreCase("Solo Voz")) {
				cantVoz++;
			} else if(plan.getNombre().equalsIgnoreCase("Solo Internet")) {
				cantInternet++;
			} else if(plan.getNombre().equalsIgnoreCase("DoblePlay Voz y Cable")) {
				cantVozCable++;
			} else if(plan.getNombre().equalsIgnoreCase("DoblePlay Voz e Internet")) {
				cantVozInternet++;
			} else if(plan.getNombre().equalsIgnoreCase("DoblePlay Cable e Internet")) {
				cantCableInternet++;
			} else if(plan.getNombre().equalsIgnoreCase("TriplePlay")) {
				cantTriple++;
			}
			
		}
	}
		cantidad.add(cantCable);
		cantidad.add(cantVoz);
		cantidad.add(cantInternet);
		cantidad.add(cantVozCable);
		cantidad.add(cantVozInternet);
		cantidad.add(cantCableInternet);
		cantidad.add(cantTriple);
		return cantidad;
	}
	
	@SuppressWarnings("deprecation")
	public ArrayList<Double> cantidadDeDineroMes() {
		ArrayList<Double> totalCadaMes = new ArrayList<>();
		/*Calendar fecha = Calendar.getInstance();
		int mes = fecha.get(Calendar.MONTH);*/
		

		double enero = 0;
		double febrero = 0;
		double marzo = 0;
		double abril = 0;
		double mayo = 0;
		double junio = 0;
		double julio = 0;
		double agosto = 0;
		double septiembre = 0;
		double octubre = 0;
		double noviembre = 0;
		double diciembre = 0;
		
		
		for (Factura factura : misFacturas) {
			if (factura.getFecha().getMonth() == 0 && factura.isPagada()) {
				enero = enero + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 1 && factura.isPagada()) {
				febrero = febrero + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 2 && factura.isPagada()) {
				marzo = marzo + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 3 && factura.isPagada()) {
				abril = abril + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 4 && factura.isPagada()) {
				mayo = mayo + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 5 && factura.isPagada()) {
				junio = junio + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 6 && factura.isPagada()) {
				julio = julio + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 7 && factura.isPagada()) {
				agosto = agosto + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 8 && factura.isPagada()) {
				septiembre = septiembre + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 9 && factura.isPagada()) {
				octubre = octubre + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 10 && factura.isPagada()) {
				noviembre = noviembre + factura.getTotal();
			}
			
			if (factura.getFecha().getMonth() == 11 && factura.isPagada()) {
				diciembre = diciembre + factura.getTotal();
			}

		}
		
		totalCadaMes.add(enero);
		totalCadaMes.add(febrero);
		totalCadaMes.add(marzo);
		totalCadaMes.add(abril);
		totalCadaMes.add(mayo);
		totalCadaMes.add(junio);
		totalCadaMes.add(julio);
		totalCadaMes.add(agosto);
		totalCadaMes.add(septiembre);
		totalCadaMes.add(octubre);
		totalCadaMes.add(noviembre);
		totalCadaMes.add(diciembre);
		
		
		return totalCadaMes;
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
		planCod++;
	}
	
	public void registrarCliente(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public void registrarPersonal(Personal personal) {
		miPersonal.add(personal);
	}
	
	public void crearFactura(Factura factura) {
		misFacturas.add(factura);
		factCod++;
	}
	
	
	private boolean chequeoCliente(String cedula) {
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
	
	public void eliminarPlan(Plan aux) {
		int i = 0;
		boolean encontrado = false;
		while(!encontrado && i<misPlanes.size()) {
			if(misPlanes.get(i).getCodPlan().equalsIgnoreCase(aux.getCodPlan())) {
				misPlanes.remove(misPlanes.get(i));
				encontrado = true;
			} else {
				i++;
			}
		}
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
	public static Altice getAltice() {
		return altice;
	}

	public static void setAltice(Altice altice) {
		Altice.altice = altice;
	}

	public int getPlanCod() {
		return planCod;
	}

	public void setPlanCod(int planCod) {
		this.planCod = planCod;
	}

	public int getFactCod() {
		return factCod;
	}

	public void setFactCod(int factCod) {
		this.factCod = factCod;
	}

	public int getAuxPlanCod() {
		return auxPlanCod;
	}

	public void setAuxPlanCod(int auxPlanCod) {
		this.auxPlanCod = auxPlanCod;
	}

	public int getAuxFactCod() {
		return auxFactCod;
	}

	public void setAuxFactCod(int auxFactCod) {
		this.auxFactCod = auxFactCod;
	}

	public static Personal getLoginPersonal() {
		return loginPersonal;
	}

	public static void setLoginPersonal(Personal loginPersonal) {
		Altice.loginPersonal = loginPersonal;
	}

	public void eliminarCliente(Cliente aux) {
		if(chequeoCliente(aux.getCedula())) {
			int i = indexCliente(aux);
			misClientes.remove(i);
		}
	}

	private int indexCliente(Cliente aux) {
		int index = 0;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<misClientes.size()){
			if(misClientes.get(i).getCedula().equalsIgnoreCase(aux.getCedula())) {
				index = i;
				encontrado = true;
			}
			i++;
		}
		return index;
	}

	public void insertarCliente(Cliente newCliente) {
		misClientes.add(newCliente);
	}
	
	public boolean confirmarLogin(String text, String text2) {
		boolean login = false;
		for (Personal personal : miPersonal) {
			if(personal.getCedula().equals(text) && personal.getPassword().equals(text2)){
				loginPersonal = personal;
				login = true;
			}
		}
		//System.out.println(login);
		return login;
	}
	public String fechaFormSimp(Date fecha){
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		return formatoFecha.format(fecha);

	}

	public static Personal getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Personal administrador) {
		this.administrador = administrador;
	}	
	
	

}
