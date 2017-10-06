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
}
