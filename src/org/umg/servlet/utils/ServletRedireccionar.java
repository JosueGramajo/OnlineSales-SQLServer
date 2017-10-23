package org.umg.servlet.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.bean.Usuario;
import org.umg.manejador.ManejadorCategorias;
import org.umg.manejador.ManejadorProducto;
import org.umg.manejador.ManejadorUsuario;

public class ServletRedireccionar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher despachador = null;
		String page = peticion.getParameter("page");
		peticion.setAttribute("usuario", ManejadorUsuario.sessionUser);

		switch (page) {
			case "dashboard":
				peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
				peticion.setAttribute("listaProductos", ManejadorProducto.INSTANCIA.getProducts());
				despachador = peticion.getRequestDispatcher("usuario/dashboard.jsp");
				break;
			case "administratorDashboard":
				System.out.println("Si entra al servlet case wevon");
				despachador = peticion.getRequestDispatcher("administrator/pages/admin_index.jsp");
				break;
			case "logout":
				ManejadorUsuario.sessionUser = new Usuario();
				peticion.setAttribute("estado", "");	
				despachador = peticion.getRequestDispatcher("index.jsp");
				break;
			case "tables":
				peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
				despachador = peticion.getRequestDispatcher("administrator/pages/tables.jsp");
				break;
			default:
				break;
		}
		despachador.forward(peticion, respuesta);
	}

}