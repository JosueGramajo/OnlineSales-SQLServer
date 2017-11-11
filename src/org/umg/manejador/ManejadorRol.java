package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.umg.bean.Rol;
import org.umg.db.Conexion;

public class ManejadorRol {
	public static ManejadorRol INSTANCIA = new ManejadorRol();
	
	public ArrayList<Rol> getRols(){
		ArrayList<Rol> list = new ArrayList<Rol>();
		ResultSet resultSet = Conexion.INSTANCIA.obtenerConsulta("select * from rol");
		try {
			Rol rol = null;
			while(resultSet.next()) {
				rol = new Rol();
				rol.setIdRol(resultSet.getInt("idRol"));
				rol.setNombre(resultSet.getString("nombre"));
				list.add(rol);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getIdRolByName(String name) {
		String idRol = "";
		ResultSet resultSet = Conexion.INSTANCIA.obtenerConsulta("select top 1 * from rol where nombre = '"+name+"'");
		try {
			while(resultSet.next()) {
				idRol = resultSet.getString("idRol");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return idRol;
	}
}
