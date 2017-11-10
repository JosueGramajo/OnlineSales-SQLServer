package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.umg.bean.CartItem;
import org.umg.db.Conexion;

public class ManejadorCompra {
	public static ManejadorCompra INSTANCIA = new ManejadorCompra();
	
	public void agregarFactura(String nombre, String direccion, String nit, String total) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		try {
			String consulta = "Insert into factura values ('"+nombre+"','"+direccion+"','"+nit+"',"+getNoFactura()+","+total+",'"+date+"',"+ManejadorUsuario.sessionUser.getIdUsuario()+")";
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(CartItem item : ManejadorCarrito.listaCarrito) {
			insertDetail(item.getProducto().getIdProducto(), item.getCantidad());
		}
		
		ManejadorCarrito.listaCarrito.clear();
	}
	
	public void insertDetail(Integer idProducto, int cantidad) {
		String consulta = "DECLARE @idFactura [int]; \r\n" + 
				"SELECT @idFactura  = SCOPE_IDENTITY(); \r\n" + 
				"insert into detalle_factura values (@idFactura,"+idProducto+","+cantidad+");";
		
		try {
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getNoFactura() {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select TOP 1 noFactura from factura order by noFactura DESC");
		int noFactura = 1;
		try {
			while(rSet.next()) {
				noFactura = rSet.getInt("noFactura") + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noFactura;
	}
}
