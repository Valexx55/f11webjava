package servlets;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet Filter implementation class FiltroBasico
 */
@WebFilter("/*")//con *, este filtro se ejecuta siempre
public class FiltroBasico extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroBasico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("A LA IDA");
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("URL = " + req.getRequestURL().toString());
		long inicio = System.nanoTime();
		chain.doFilter(request, response);
		long fin = System.nanoTime();

        double tiempoMilisegundos =
                (fin - inicio) / 1_000_000.0;

        System.out.printf(
                "%s %s ha tardado %.3f ms%n",
                req.getMethod(),
                req.getRequestURI(),
                tiempoMilisegundos
        );
		HttpServletResponse resp = (HttpServletResponse)response;
		System.out.println("A LA VUELTA " + resp.getStatus());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
