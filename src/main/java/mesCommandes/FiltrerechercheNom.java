package mesCommandes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.parser.Cookie;

public class FiltrerechercheNom implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String nom = null;
		HttpServletRequest hrequest = (HttpServletRequest) request;
		javax.servlet.http.Cookie[] cookies = hrequest.getCookies();
		// test s'il existe un cookie dont l'attribut est "nom"
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("nom")) {
					nom = cookies[i].getValue();
					PrintWriter out = response.getWriter();
					out.print( nom);
					break;
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
