package org.umg.bean;

public class Factura {
	private Integer idFactura;
	private String nombre;
	private String nit;
	private Integer noFactura;
	private float total;
	private String fecha;
	
	public Factura() {
		
	}
	
	public Factura(Integer idFactura, String nombre, String nit, Integer noFactura, float total, String fecha) {
		super();
		this.idFactura = idFactura;
		this.nombre = nombre;
		this.nit = nit;
		this.noFactura = noFactura;
		this.total = total;
		this.fecha = fecha;
	}
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public Integer getNoFactura() {
		return noFactura;
	}
	public void setNoFactura(Integer noFactura) {
		this.noFactura = noFactura;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
