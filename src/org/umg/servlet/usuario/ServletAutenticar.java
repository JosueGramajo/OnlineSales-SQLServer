package org.umg.servlet.usuario;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.umg.bean.Categoria;
import org.umg.bean.Usuario;
import org.umg.manejador.ManejadorCategorias;
import org.umg.manejador.ManejadorProducto;
import org.umg.manejador.ManejadorUsuario;

public class ServletAutenticar extends HttpServlet {
	public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws IOException, ServletException {
		doPost(peticion, respuesta);
	}
	public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) throws IOException, ServletException{
		RequestDispatcher despachador = null; 
		String usuario = peticion.getParameter("txtUsuario");
		String password = peticion.getParameter("txtPassword");
		Usuario aUsuario = ManejadorUsuario.INSTANCIA.doLogin(usuario, password);
		
		if(aUsuario.getIdUsuario() != -1) {
			ManejadorUsuario.sessionUser = aUsuario;
			peticion.setAttribute("nombreUsuario", usuario);
			peticion.setAttribute("usuario", ManejadorUsuario.sessionUser);
			peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
			peticion.setAttribute("listaProductos", ManejadorProducto.INSTANCIA.getProducts());
			despachador = peticion.getRequestDispatcher("usuario/dashboard.jsp");
		}else {
			peticion.setAttribute("estado", "Usuario o contraseña incorrectos");
			despachador = peticion.getRequestDispatcher("index.jsp");
		}

		despachador.forward(peticion, respuesta);
	}
}
