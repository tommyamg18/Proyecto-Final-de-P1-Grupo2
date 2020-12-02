package logic;

import java.util.Date;

public class Plan {
	private String codPlan;
	private String nombre;
	private String numero;
	private double precio;
	private Date apertura;
	private Date diaPago;
	private Date diaCorte;
	private boolean internet;
	private boolean voz;
	private boolean cable;
	private String velocidadSubida;
	private String velocidadBajada;
	private int cantCanal;
	private int cantHdCanal;
	private double minNacional;
	private double minInter;
	
	public String getCodPlan() {
		return codPlan;
	}
	public void setCodPlan(String codPlan) {
		this.codPlan = codPlan;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getApertura() {
		return apertura;
	}
	public void setApertura(Date apertura) {
		this.apertura = apertura;
	}
	public Date getDiaPago() {
		return diaPago;
	}
	public void setDiaPago(Date diaPago) {
		this.diaPago = diaPago;
	}
	public Date getDiaCorte() {
		return diaCorte;
	}
	public void setDiaCorte(Date diaCorte) {
		this.diaCorte = diaCorte;
	}
	public boolean isInternet() {
		return internet;
	}
	public void setInternet(boolean internet) {
		this.internet = internet;
	}
	public boolean isVoz() {
		return voz;
	}
	public void setVoz(boolean voz) {
		this.voz = voz;
	}
	public boolean isCable() {
		return cable;
	}
	public void setCable(boolean cable) {
		this.cable = cable;
	}
	
	public int getCantCanal() {
		return cantCanal;
	}
	public void setCantCanal(int cantCanal) {
		this.cantCanal = cantCanal;
	}
	public int getCantHdCanal() {
		return cantHdCanal;
	}
	public void setCantHdCanal(int cantHdCanal) {
		this.cantHdCanal = cantHdCanal;
	}
	public double getMinNacional() {
		return minNacional;
	}
	public void setMinNacional(double minNacional) {
		this.minNacional = minNacional;
	}
	public double getMinInter() {
		return minInter;
	}
	public void setMinInter(double minInter) {
		this.minInter = minInter;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getVelocidadSubida() {
		return velocidadSubida;
	}
	public void setVelocidadSubida(String velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}
	public String getVelocidadBajada() {
		return velocidadBajada;
	}
	public void setVelocidadBajada(String velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}
	public Plan(String codPlan, String nombre, String numero, double precio, Date apertura, Date diaPago, Date diaCorte,
			boolean internet, boolean voz, boolean cable, String velocidadSubida, String velocidadBajada, int cantCanal,
			int cantHdCanal, double minNacional, double minInter) {
		super();
		this.codPlan = codPlan;
		this.nombre = nombre;
		this.numero = numero;
		this.precio = precio;
		this.apertura = apertura;
		this.diaPago = diaPago;
		this.diaCorte = diaCorte;
		this.internet = internet;
		this.voz = voz;
		this.cable = cable;
		this.velocidadSubida = velocidadSubida;
		this.velocidadBajada = velocidadBajada;
		this.cantCanal = cantCanal;
		this.cantHdCanal = cantHdCanal;
		this.minNacional = minNacional;
		this.minInter = minInter;
	}
	
	
	
}
