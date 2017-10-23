package org.umg.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.umg.manejador.ManejadorUsuario;

import javax.servlet.Filter;


import com.sun.net.httpserver.HttpExchange;

public class AuthenticationFilter implements Filter{
	private ServletContext context;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		if(ManejadorUsuario.sessionUser == null){
			this.context.log("Unauthorized access request");
			res.sendRedirect("index.jsp");
		}else{
			/*HttpServletResponse httpres = (HttpServletResponse) response;
			httpres.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			httpres.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			httpres.setDateHeader("Expires", 0); // Proxies.*/
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}



}
