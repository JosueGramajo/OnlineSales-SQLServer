package org.umg.servlet.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.manejador.ManejadorRol;
import org.umg.manejador.ManejadorUsuario;
import org.umg.utils.SharedPreferences;

/**
 * Servlet implementation class ServletAgregarUsuario
 */
@WebServlet("/ServletAgregarUsuario")
public class ServletAgregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token = request.getParameter("token");
		if(token.equals(SharedPreferences.INSTANCIA.getToken())) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=users");
			requestDispatcher.forward(request, response);	
		}else {
			// TODO Auto-generated method stub
			SharedPreferences.INSTANCIA.setToken(token);
			request.setAttribute("token", SharedPreferences.INSTANCIA.generateToken());
			
			String nombre = request.getParameter("txtNombre");
			String nick = request.getParameter("txtNick");
			String email = request.getParameter("txtEmail");
			String password = request.getParameter("txtPassword");
			String idRol = ManejadorRol.INSTANCIA.getIdRolByName(request.getParameter("slcRol"));
			String estado = request.getParameter("slcEstado");
			
			ManejadorUsuario.INSTANCIA.agregarUsuario(nombre, nick, email, password, idRol, estado.toLowerCase());
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=users");
			requestDispatcher.forward(request, response);
		}
	}

}
