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

/**
 * Servlet implementation class ServletAgregarCarrito
 */
@WebServlet("/ServletAgregarCarrito")
public class ServletAgregarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarCarrito() {
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
		String idProducto = request.getParameter("idProducto");
		String cantidad = request.getParameter("txtCantidad");
		
		Producto producto = ManejadorProducto.INSTANCIA.getProductById(idProducto);
		
		ManejadorCarrito.listaCarrito.add(new CartItem(producto,Integer.parseInt(cantidad)));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=cartConfirmation");
		requestDispatcher.forward(request, response);
	}

}
