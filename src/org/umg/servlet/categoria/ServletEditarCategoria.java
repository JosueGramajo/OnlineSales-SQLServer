package org.umg.servlet.categoria;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.bean.Categoria;
import org.umg.manejador.ManejadorCategorias;

import com.sun.xml.internal.ws.developer.StreamingAttachment;

/**
 * Servlet implementation class ServletEditarCategoria
 */
@WebServlet("/ServletEditarCategoria")
public class ServletEditarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarCategoria() {
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
		RequestDispatcher requestDispatcher = null;
		String nombre = request.getParameter("txtNombre");
		String descripcion = request.getParameter("txtDescripcion");
		String idCategoria = request.getParameter("idCategoria");
		ManejadorCategorias.INSTANCIA.editarCategoria(idCategoria, nombre, descripcion);
		
		requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=categories");
		
		requestDispatcher.forward(request, response);
	}

}
