package org.umg.bean;

public class Usuario {
	private Integer idUsuario;
	private String nombre;
	private String nick;
	private String email;
	private String password;
	private Integer idRol;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer idUsuario, String nombre, String nick, String email, String password, Integer idRol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.idRol = idRol;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	

	
}
