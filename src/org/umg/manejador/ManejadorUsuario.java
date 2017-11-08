package org.umg.manejador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.umg.bean.Usuario;
import org.umg.db.Conexion;

public class ManejadorUsuario {
	public static ManejadorUsuario INSTANCIA = new ManejadorUsuario();
	public static Usuario sessionUser = new Usuario();
	
	public Usuario doLogin(String usr,String psw) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(-1);
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select top 1 * from usuario where nick = '"+usr+"' and pass = '"+psw+"'");
		//esto est un comentario
		try {
			while(rSet.next()) {
				usuario.setIdUsuario(rSet.getInt("idUsuario"));
				usuario.setNombre(rSet.getString("nombre"));
				usuario.setNick(rSet.getString("nick"));
				usuario.setEmail(rSet.getString("email"));
				usuario.setIdRol(rSet.getInt("idRol"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
}