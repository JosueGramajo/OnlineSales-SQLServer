package org.umg.bean;

import java.util.ArrayList;

public class Compra {
	private Integer idFactura;
	private String nombre;
	private String direccion;
	private String nit;
	private Integer noFactura;
	private float total;
	private String fecha;
	private String idUsuario;
	private ArrayList<CartItem> detalle;
	
	public Compra(Integer idFactura, String nombre, String direccion, String nit, Integer noFactura, float total,
			String fecha, String idUsuario, ArrayList<CartItem> detalle) {
		super();
		this.idFactura = idFactura;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nit = nit;
		this.noFactura = noFactura;
		this.total = total;
		this.fecha = fecha;
		this.idUsuario = idUsuario;
		this.detalle = detalle;
	}
	
	public Compra() {}
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public ArrayList<CartItem> getDetalle() {
		return detalle;
	}
	public void setDetalle(ArrayList<CartItem> detalle) {
		this.detalle = detalle;
	}
	
	
	
}
