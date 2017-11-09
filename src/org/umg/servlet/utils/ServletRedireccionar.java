package org.umg.servlet.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.umg.bean.Categoria;
import org.umg.bean.Producto;
import org.umg.bean.Usuario;
import org.umg.manejador.ManejadorCarrito;
import org.umg.manejador.ManejadorCategorias;
import org.umg.manejador.ManejadorProducto;
import org.umg.manejador.ManejadorUsuario;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

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
		String error = peticion.getParameter("error");
		peticion.setAttribute("usuario", ManejadorUsuario.sessionUser);
		peticion.setAttribute("cantidadCarrito", ManejadorCarrito.listaCarrito.size());
		
		error = error == null ? "no" : error;

		switch (page) {
			case "dashboard":
				peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
				peticion.setAttribute("listaProductos", ManejadorProducto.INSTANCIA.getProducts());
				despachador = peticion.getRequestDispatcher("pagina_principal/dashboard.jsp");
				break;
			case "productDetail":
				String idProducto = peticion.getParameter("productId");
				Producto producto = ManejadorProducto.INSTANCIA.getProductById(idProducto);
				peticion.setAttribute("producto", producto);
				peticion.setAttribute("productosRelacionados", ManejadorProducto.INSTANCIA.getRelatedProducts(producto.getIdCategoria().toString(), idProducto));
				peticion.setAttribute("categoria", ManejadorCategorias.INSTANCIA.getCategoriaFromId(producto.getIdCategoria().toString()));
				despachador = peticion.getRequestDispatcher("detalle_producto/product_detail.jsp");
				break;
			case "administratorDashboard":
				peticion.setAttribute("countCategorias", ManejadorCategorias.INSTANCIA.countCategorias());
				peticion.setAttribute("countProductos", ManejadorProducto.INSTANCIA.countProductos());
				despachador = peticion.getRequestDispatcher("administrator/pages/admin_index.jsp");
				break;
			case "logout":
				ManejadorUsuario.sessionUser = new Usuario();
				peticion.setAttribute("estado", "");	
				despachador = peticion.getRequestDispatcher("index.jsp");
				break;
			case "categories":
				peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
				peticion.setAttribute("error",error);
				despachador = peticion.getRequestDispatcher("mantenimientos/categoria/categories_management.jsp");				
				break;
			case "categoriesUpdate":
				String idCategoria = peticion.getParameter("idCategoria");
				Categoria categoria = ManejadorCategorias.INSTANCIA.getCategoriaFromId(idCategoria);				
				peticion.setAttribute("category", categoria);
				despachador = peticion.getRequestDispatcher("mantenimientos/categoria/categories_update.jsp");
				break;
			case "products":
				peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
				peticion.setAttribute("listaProductos",ManejadorProducto.INSTANCIA.getAllProducts());
				despachador = peticion.getRequestDispatcher("mantenimientos/producto/products_management.jsp");				
				break;
			case "productsUpdate":
				peticion.setAttribute("listaCategorias",ManejadorCategorias.INSTANCIA.getCategorias());
				peticion.setAttribute("producto", ManejadorProducto.INSTANCIA.getProductById(peticion.getParameter("idProducto")));
				peticion.setAttribute("returnPage", peticion.getParameter("returnPage"));
				despachador = peticion.getRequestDispatcher("mantenimientos/producto/products_update.jsp");				
				break;
			case "cartConfirmation":
				peticion.setAttribute("producto", ManejadorProducto.INSTANCIA.getProductById(peticion.getParameter("idProducto")));
				despachador = peticion.getRequestDispatcher("carrito/product_added_confirmation.jsp");				
				break;
			case "checkout":
				peticion.setAttribute("cartList", ManejadorCarrito.INSTANCIA.listaCarrito);
				despachador = peticion.getRequestDispatcher("carrito/checkout.jsp");				
				break;
			default:
				break;
		}
		despachador.forward(peticion, respuesta);
	}

}