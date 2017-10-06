package org.umg.bean;

public class Producto {
	private Integer idProducto;
	private String nombre;
	private float precio;
	private String imagen;
	private Integer existencias;
	private Integer idCategoria;
	
	public Producto() {
		
	}
	
	public Producto(Integer idProducto, String nombre, float precio, String imagen, Integer existencias,
			Integer idCategoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.existencias = existencias;
		this.idCategoria = idCategoria;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getExistencias() {
		return existencias;
	}
	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
}
