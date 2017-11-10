package org.umg.servlet.producto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.manejador.ManejadorProducto;
import org.umg.utils.SharedPreferences;

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
		
		String token = request.getParameter("token");
		String idProduto = request.getParameter("idProducto");
		String returnPage = request.getParameter("returnPage");
		
		if(token.equals(SharedPreferences.INSTANCIA.getToken())) {
			RequestDispatcher requestDispatcher = null;
			if(returnPage.equals("dashboard")) {
				requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=dashboard");
			}else if(returnPage.equals("admin")) {
				requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products");
			}
			requestDispatcher.forward(request, response);
		}else {
			// TODO Auto-generated method stub
			SharedPreferences.INSTANCIA.setToken(token);
			request.setAttribute("token", SharedPreferences.INSTANCIA.generateToken());

			boolean resultado = ManejadorProducto.INSTANCIA.eliminarProducto(idProduto);
			
			if(resultado) {
				RequestDispatcher requestDispatcher = null;
				if(returnPage.equals("dashboard")) {
					requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=dashboard");
				}else if(returnPage.equals("admin")) {
					requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products");
				}
				requestDispatcher.forward(request, response);
			}else{
				ManejadorProducto.INSTANCIA.inhabilitarProducto(idProduto);
				RequestDispatcher requestDispatcher = null;
				if(returnPage.equals("dashboard")) {
					requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=dashboard&error=El producto ya se encuentra facturado en mas de 1 pedido, no se pude eliminar, el producto fue deshabilitado");
				}else if(returnPage.equals("admin")) {
					requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products&error=El producto ya se encuentra facturado en mas de 1 pedido, no se pude eliminar, el producto fue deshabilitado");
				}
				requestDispatcher.forward(request, response);
			}
		}

	}

}
