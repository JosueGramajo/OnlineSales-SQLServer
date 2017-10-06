package org.umg.bean;
/*
 	idDetalle int identity(1,1) primary key not null,
	idFactura int not null,
	idProducto int not null,
	cantidad int not null
 * */
public class DetalleFactura {
	private Integer idDetalle;
	private Integer idFactura;
	private Integer idProducto;
	private Integer cantidad;
	
	public DetalleFactura() {
		
	}
	
	public DetalleFactura(Integer idDetalle, Integer idFactura, Integer idProducto, Integer cantidad) {
		super();
		this.idDetalle = idDetalle;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public Integer getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
