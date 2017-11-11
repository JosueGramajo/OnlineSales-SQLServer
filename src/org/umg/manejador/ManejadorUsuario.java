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
	public ArrayList<Usuario> getUsers(){
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		ResultSet resultSet = Conexion.INSTANCIA.obtenerConsulta("select * from usuario where nick <> 'sa'");
		try {
			Usuario user = null;
			while(resultSet.next()) {
				user = new Usuario();
				user.setIdUsuario(resultSet.getInt("idUsuario"));
				user.setNombre(resultSet.getString("nombre"));
				user.setNick(resultSet.getString("nick"));
				user.setEmail(resultSet.getString("email"));
				user.setIdRol(resultSet.getInt("idRol"));
				user.setEstado(resultSet.getString("estado"));
				list.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Usuario getUserById(String idUsuario) {
		Usuario user = new Usuario();
		ResultSet resultSet = Conexion.INSTANCIA.obtenerConsulta("select * from usuario where idUsuario = "+idUsuario);
		try {
			
			while(resultSet.next()) {
				user.setIdUsuario(resultSet.getInt("idUsuario"));
				user.setNombre(resultSet.getString("nombre"));
				user.setNick(resultSet.getString("nick"));
				user.setEmail(resultSet.getString("email"));
				user.setIdRol(resultSet.getInt("idRol"));
				user.setEstado(resultSet.getString("estado"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;	
	}
	
	public void agregarUsuario(String nombre, String nick, String email, String password, String idRol, String estado) {
		try {
			String consulta = "insert into usuario values ('"+nombre+"','"+nick+"','"+password+"','"+email+"',"+idRol+",'"+estado+"')";
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editarUsuario(String idUsuario, String nombre, String nick, String email, String idRol, String estado) {
		try {
			String consulta = "update usuario set nombre='"+nombre+"', nick = '"+nick+"', email = '"+email+"', idRol = "+idRol+", estado = '"+estado+"' where idUsuario = "+idUsuario;
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void editarPassUsuario(String idUsuario, String password) {
		try {
			String consulta = "update usuario set pass = '"+password+"' where idUsuario = "+idUsuario;
			System.out.println(consulta);
			Conexion.INSTANCIA.ejecutarConsulta(consulta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean eliminarUsuario(String idUsuario) {
		try {
			Conexion.INSTANCIA.ejecutarConsultaCascada("delete from usuario where idUsuario = "+idUsuario);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public String countUsuarios() {
		ResultSet rSet = Conexion.INSTANCIA.obtenerConsulta("select COUNT(idUsuario) as count from usuario");
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