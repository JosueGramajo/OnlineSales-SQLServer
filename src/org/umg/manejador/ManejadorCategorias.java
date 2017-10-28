package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.umg.bean.Categoria;
import org.umg.db.Conexion;

public class ManejadorCategorias {
	public static ManejadorCategorias INSTANCIA = new ManejadorCategorias();
	
	public ArrayList<Categoria> getCategorias(){
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select * from categoria order by nombre ASC");
		try {
			Categoria ct = null;
			while(rSet.next()) {
				ct = new Categoria();
				ct.setIdCategoria(rSet.getInt("idCategoria"));
				ct.setNombre(rSet.getString("nombre"));
				ct.setDescripcion(rSet.getString("descripcion"));
				categorias.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
	
	public Categoria getCategoriaFromId(String id) {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select * from categoria where idCategoria = " + id);
		Categoria ct = new Categoria();
		try {
			
			while(rSet.next()) {
				ct.setIdCategoria(rSet.getInt("idCategoria"));
				ct.setNombre(rSet.getString("nombre"));
				ct.setDescripcion(rSet.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ct;
	}
	public String countCategorias() {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select COUNT(idCategoria) as count from categoria");
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
	public void editarCategoria(String idCategoria,String nombre, String descripcion) {
		try {
			Conexion.INSTANCIA.ejecutarConsulta("UPDATE categoria set nombre='"+nombre+"', descripcion='"+descripcion+"' where idCategoria = " + idCategoria);
			System.out.println("Se logro editar en teoria");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void eliminarCategoria(String idCategoria) {
		try {
			Conexion.INSTANCIA.ejecutarConsulta("UPDATE producto SET idCategoria= 1 where idCategoria = " + idCategoria);
			System.out.println("Se logro editar categoria por defecto en producto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Conexion.INSTANCIA.ejecutarConsulta("DELETE categoria where idCategoria = " + idCategoria);
			System.out.println("Se logro eliminar categoria:  "+idCategoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void agregarCategoria(String nombre,String descripcion) {
		try {
			Conexion.INSTANCIA.ejecutarConsulta("INSERT INTO Categoria values ('"+nombre+"','"+descripcion+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
