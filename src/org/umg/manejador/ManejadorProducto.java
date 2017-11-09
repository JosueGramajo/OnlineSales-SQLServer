package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.umg.bean.Producto;
import org.umg.bean.Usuario;
import org.umg.db.Conexion;

import oracle.net.aso.p;

public class ManejadorProducto {
	public static ManejadorProducto INSTANCIA = new ManejadorProducto();

	public ArrayList<Producto> getProducts() {
		ArrayList<Producto> list = new ArrayList<Producto>();
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select * from producto where estado <> 'inactivo' order by nombre ASC");

		try {
			Producto producto;
			while (rSet.next()) {
				producto = new Producto();
				producto.setIdProducto(rSet.getInt("idProducto"));
				producto.setNombre(rSet.getString("nombre"));
				producto.setPrecio(rSet.getFloat("precio"));
				producto.setImagen(rSet.getString("imagen"));
				producto.setDescripcion(rSet.getString("descripcion"));
				producto.setEstado(rSet.getString("estado"));
				producto.setExistencias(rSet.getInt("existencias"));
				producto.setIdCategoria(rSet.getInt("idCategoria"));
				producto.setRating(rSet.getInt("rating"));

				list.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	public ArrayList<Producto> getAllProducts() {
		ArrayList<Producto> list = new ArrayList<Producto>();
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select * from producto order by nombre ASC");

		try {
			Producto producto;
			while (rSet.next()) {
				producto = new Producto();
				producto.setIdProducto(rSet.getInt("idProducto"));
				producto.setNombre(rSet.getString("nombre"));
				producto.setPrecio(rSet.getFloat("precio"));
				producto.setImagen(rSet.getString("imagen"));
				producto.setDescripcion(rSet.getString("descripcion"));
				producto.setEstado(rSet.getString("estado"));
				producto.setExistencias(rSet.getInt("existencias"));
				producto.setIdCategoria(rSet.getInt("idCategoria"));
				producto.setRating(rSet.getInt("rating"));

				list.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void agregarProducto(String nombre, String precio, String imagen, String descripcion,String estado, String existencias,
			String idCategoria, String rating) {

		try {
			String consulta = "insert into producto values ('"+nombre+"',"+precio+",'"+imagen+"','"+descripcion+"','"+estado+"',"+existencias+","+idCategoria+","+rating+")";
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void editarProducto(String idProducto, String nombre, String precio, String descripcion,String estado, String existencias,
			String idCategoria) {

		try {
			String consulta = "update producto set nombre = '"+nombre+"', precio = "+precio+", descripcion = '"+descripcion+"'"
					+ ", estado = '"+estado.toLowerCase()+"', existencias = "+existencias+", idCategoria = "+idCategoria
					+" where idProducto = "+idProducto;
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean eliminarProducto(String idProducto) {
		try {
			String consulta = "delete producto where idProducto = "+idProducto;
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String countProductos() {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select COUNT(idProducto) as count from producto");
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
	public Producto getProductById(String id) {
		Producto producto = new Producto();
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select * from producto where idProducto = "+id);

		try {
			
			while (rSet.next()) {
				producto.setIdProducto(rSet.getInt("idProducto"));
				producto.setNombre(rSet.getString("nombre"));
				producto.setPrecio(rSet.getFloat("precio"));
				producto.setImagen(rSet.getString("imagen"));
				producto.setDescripcion(rSet.getString("descripcion"));
				producto.setEstado(rSet.getString("estado"));
				producto.setExistencias(rSet.getInt("existencias"));
				producto.setIdCategoria(rSet.getInt("idCategoria"));
				producto.setRating(rSet.getInt("rating"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return producto;
	}
	public ArrayList<Producto> getRelatedProducts(String idCategoria, String idProducto){
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select	top 4 * from producto where idCategoria = "+idCategoria+" and estado <> 'inactivo' and idProducto <> "+idProducto);
		ArrayList<Producto> listaProductosRelacionados = new ArrayList<Producto>();
		
		try {
			Producto producto;
			while (rSet.next()) {
				producto = new Producto();
				producto.setIdProducto(rSet.getInt("idProducto"));
				producto.setNombre(rSet.getString("nombre"));
				producto.setPrecio(rSet.getFloat("precio"));
				producto.setImagen(rSet.getString("imagen"));
				producto.setDescripcion(rSet.getString("descripcion"));
				producto.setEstado(rSet.getString("estado"));
				producto.setExistencias(rSet.getInt("existencias"));
				producto.setIdCategoria(rSet.getInt("idCategoria"));
				producto.setRating(rSet.getInt("rating"));
				
				listaProductosRelacionados.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaProductosRelacionados;
	}
}
