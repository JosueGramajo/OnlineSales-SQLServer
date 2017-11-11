package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import org.umg.bean.CartItem;
import org.umg.bean.Compra;
import org.umg.bean.Usuario;
import org.umg.db.Conexion;
import org.umg.utils.GeneratePDF;

import com.sun.org.apache.bcel.internal.generic.INEG;

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
		
		GeneratePDF.INSTANCIA.setIdFactura(Integer.toString(getLastInvoice()));
		
		ManejadorCarrito.listaCarrito.clear();
	}
	
	public void insertDetail(Integer idProducto, int cantidad) {
		String consulta = "insert into detalle_factura values ("+getLastInvoice()+","+idProducto+","+cantidad+");";
		
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
	public int getLastInvoice() {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("SELECT TOP 1 idFactura FROM factura ORDER BY idFactura DESC");
		int noFactura = 1;
		try {
			while(rSet.next()) {
				noFactura = rSet.getInt("idFactura");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noFactura;
	}
	
	public ArrayList<Compra> getCompras(){
		ArrayList<Compra> list = new ArrayList<Compra>();
		ResultSet resultSet = Conexion.INSTANCIA.obtenerConsulta("select * from factura");
		String idUsuario = "";
		try {
			Compra compra = null;
			while(resultSet.next()) {
				compra = new Compra();
				compra.setIdFactura(resultSet.getInt("idFactura"));
				compra.setNombre(resultSet.getString("nombre"));
				compra.setDireccion(resultSet.getString("direccion"));
				compra.setNit(resultSet.getString("nit"));
				compra.setNoFactura(resultSet.getInt("noFactura"));
				compra.setTotal(resultSet.getFloat("total"));
				compra.setFecha(resultSet.getDate("fecha").toString());
				compra.setIdUsuario(Integer.toString(resultSet.getInt("idUsuario")));
				
				//compra.setDetalle(getDetalle(Integer.toString(compra.getIdFactura())));
				list.add(compra);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;i<list.size();i++) {
			list.get(i).setDetalle(getDetalle(Integer.toString(list.get(i).getIdFactura())));
		}
		
		return list;
	}
	public ArrayList<CartItem> getDetalle(String idFactura){
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		ResultSet rs = Conexion.INSTANCIA.obtenerConsultaSecundaria("select * from detalle_factura where idFactura = "+idFactura);
		try {
			CartItem item = null;
			while(rs.next()) {
				item = new CartItem();
				item.setCantidad(rs.getInt("cantidad"));
				item.setProducto(ManejadorProducto.INSTANCIA.getProductById(Integer.toString(rs.getInt("idProducto"))));
				list.add(item);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Compra getCompraUsuario(String idFactura){
		ResultSet resultSet = Conexion.INSTANCIA.obtenerConsulta("select top 1 * from factura where idFactura = "+idFactura);
		Compra compra = new Compra();
		try {
			
			while(resultSet.next()) {
				compra.setIdFactura(resultSet.getInt("idFactura"));
				compra.setNombre(resultSet.getString("nombre"));
				compra.setDireccion(resultSet.getString("direccion"));
				compra.setNit(resultSet.getString("nit"));
				compra.setNoFactura(resultSet.getInt("noFactura"));
				compra.setTotal(resultSet.getFloat("total"));
				compra.setFecha(resultSet.getDate("fecha").toString());
				compra.setIdUsuario(Integer.toString(resultSet.getInt("idUsuario")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		compra.setDetalle(getDetalle(Integer.toString(compra.getIdFactura())));
		
		return compra;
	}
	public String countCompra() {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select COUNT(idFactura) as count from factura");
		String count = "";
		try {
			while(rSet.next()) {
				count = rSet.getString("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
