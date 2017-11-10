package org.umg.servlet.carrito;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.bean.CartItem;
import org.umg.bean.Producto;
import org.umg.manejador.ManejadorCarrito;
import org.umg.manejador.ManejadorProducto;
import org.umg.utils.SharedPreferences;

/**
 * Servlet implementation class ServletEliminarCarrito
 */
@WebServlet("/ServletEliminarCarrito")
public class ServletEliminarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarCarrito() {
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
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=checkout");
			requestDispatcher.forward(request, response);	
		}else {
			// TODO Auto-generated method stub
			SharedPreferences.INSTANCIA.setToken(token);
			request.setAttribute("token", SharedPreferences.INSTANCIA.generateToken());
			
			String idProducto = request.getParameter("idProducto");
			
			ManejadorCarrito.INSTANCIA.deleteFromCart(idProducto);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=checkout");
			requestDispatcher.forward(request, response);	
		}
	}

}
