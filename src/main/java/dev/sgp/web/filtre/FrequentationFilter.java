package dev.sgp.web.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constante;

@WebFilter(urlPatterns = { "/*" }, description = "Request path and time")
public class FrequentationFilter implements Filter {
	private FilterConfig config = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getRequestURI();
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		Constante.VISITE_SERVICE.sauvegarderVisite(new VisiteWeb(path, (int) (after - before)));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
