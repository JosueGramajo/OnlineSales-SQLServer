package org.umg.servlet.producto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.MultipartConfigElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.umg.manejador.ManejadorCategorias;
import org.umg.manejador.ManejadorProducto;
import org.umg.utils.SharedPreferences;

/**
 * Servlet implementation class ServletAgregarProducto
 */
@WebServlet("/ServletAgregarProducto")
@MultipartConfig
public class ServletAgregarProducto extends HttpServlet {


	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String token = request.getParameter("token");
		if(token.equals(SharedPreferences.INSTANCIA.getToken())) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products");
			requestDispatcher.forward(request, response);	
		}else {
			// TODO Auto-generated method stub
			SharedPreferences.INSTANCIA.setToken(token);
			request.setAttribute("token", SharedPreferences.INSTANCIA.generateToken());
			
			response.setContentType("text/html;charset=UTF-8");

		    // Create path components to save the file
		    final String path = "D:\\eclipse-workspace\\ECommerce\\WebContent\\assets\\ProductImages";
		    final Part filePart = request.getPart("file");
		    final String fileName = getFileName(filePart);

		    OutputStream out = null;
		    InputStream filecontent = null;
		    final PrintWriter writer = response.getWriter();

		    try {
		        out = new FileOutputStream(new File(path + File.separator
		                + fileName));
		        filecontent = filePart.getInputStream();

		        int read = 0;
		        final byte[] bytes = new byte[1024];

		        while ((read = filecontent.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		        
		        String imagePath = "assets\\ProductImages\\" + fileName;
		        String nombre = request.getParameter("txtNombre");
		        String precio = request.getParameter("txtPrecio");
		        String descripcion = request.getParameter("txtDescripcion");
		        String idCategoria = ManejadorCategorias.INSTANCIA.getIdCategoriaFromName(request.getParameter("category"));
		        String existencias = request.getParameter("txtExistencias");
		        String estado = request.getParameter("estadoProducto");
		        
		        ManejadorProducto.INSTANCIA.agregarProducto(nombre, precio, imagePath, descripcion,estado.toLowerCase(), existencias, idCategoria, "0");

		        try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletRedireccionar.do?page=products");
				requestDispatcher.forward(request, response);
		        
		    } catch (FileNotFoundException fne) {
		        writer.println("You either did not specify a file to upload or are "
		                + "trying to upload a file to a protected or nonexistent "
		                + "location.");
		        writer.println("<br/> ERROR: " + fne.getMessage());

		        //LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
		               // new Object[]{fne.getMessage()});
		    } finally {
		        if (out != null) {
		            out.close();
		        }
		        if (filecontent != null) {
		            filecontent.close();
		        }
		        if (writer != null) {
		            writer.close();
		        }
		    }
		}
	    
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		//LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
