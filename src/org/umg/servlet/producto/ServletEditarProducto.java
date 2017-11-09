package org.umg.servlet.producto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.manejador.ManejadorCategorias;
import org.umg.manejador.ManejadorProducto;

/**
 * Servlet implementation class ServletEditarProducto
 */
@WebServlet("/ServletEditarProducto")
public class ServletEditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarProducto() {
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
		String nombre = request.getParameter("txtNombre");
		String precio = request.getParameter("txtPrecio");
		String descripcion = request.getParameter("txtDescripcion");
		String idCategoria = ManejadorCategorias.INSTANCIA.getIdCategoriaFromName(request.getParameter("category"));
		String existencias = request.getParameter("txtExistencias");
		String estado = request.getParameter("estadoProducto");
		
		ManejadorProducto.INSTANCIA.editarProducto(idProducto, nombre, precio, descripcion, estado, existencias, idCategoria);
		
		RequestDispatcher requestDispatcher = null;
		
		String returnPage = request.getParameter("returnPage");
		if(returnPage.equals("dashboard")) {
			requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=dashboard");
		}else if(returnPage.equals("admin")) {
			requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products");
		}
		
		requestDispatcher.forward(request, response);
	}

}
