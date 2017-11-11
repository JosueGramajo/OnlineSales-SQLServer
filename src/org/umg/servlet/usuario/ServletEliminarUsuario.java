package org.umg.servlet.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.manejador.ManejadorUsuario;
import org.umg.utils.SharedPreferences;

/**
 * Servlet implementation class ServletEliminarUsuario
 */
@WebServlet("/ServletEliminarUsuario")
public class ServletEliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarUsuario() {
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
		String idUsuario = request.getParameter("idUsuario");
		
		if(token.equals(SharedPreferences.INSTANCIA.getToken())) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=users");;
			requestDispatcher.forward(request, response);
		}else {
			// TODO Auto-generated method stub
			SharedPreferences.INSTANCIA.setToken(token);
			request.setAttribute("token", SharedPreferences.INSTANCIA.generateToken());
			
			boolean resultado = ManejadorUsuario.INSTANCIA.eliminarUsuario(idUsuario);
			
			RequestDispatcher requestDispatcher = null;
			if(resultado) {
				requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=users");
			}else {
				requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=users&error=Este usuario ya se encuentra asociado con otras transacciones, no se puede eliminar, sera inhabilitado en su lugar");
			}
			requestDispatcher.forward(request, response);
		}
	}

}
