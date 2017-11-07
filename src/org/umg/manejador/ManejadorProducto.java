package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.umg.bean.Producto;
import org.umg.db.Conexion;

import oracle.net.aso.p;

public class ManejadorProducto {
	public static ManejadorProducto INSTANCIA = new ManejadorProducto();

	public ArrayList<Producto> getProducts() {
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

	public void agregarProducto(String nombre, String precio, String imagen, String descripcion, String existencias,
			String idCategoria, String rating) {

		try {
			String consulta = "insert into producto values ('"+nombre+"',"+precio+",'"+imagen+"','"+descripcion+"',"+existencias+","+idCategoria+","+rating+")";
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
