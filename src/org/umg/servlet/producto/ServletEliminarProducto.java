package org.umg.servlet.producto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.manejador.ManejadorProducto;

/**
 * Servlet implementation class ServletEliminarProducto
 */
@WebServlet("/ServletEliminarProducto")
public class ServletEliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarProducto() {
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
		String idProduto = request.getParameter("idProducto");
		String returnPage = request.getParameter("returnPage");
		
		boolean resultado = ManejadorProducto.INSTANCIA.eliminarProducto(idProduto);
		
		if(resultado) {
			RequestDispatcher requestDispatcher = null;
			if(returnPage.equals("dashboard")) {
				requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=dashboard");
			}else if(returnPage.equals("admin")) {
				requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products");
			}
			requestDispatcher.forward(request, response);
		}
	}

}
