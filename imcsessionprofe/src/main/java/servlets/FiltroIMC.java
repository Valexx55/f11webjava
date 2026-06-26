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
 * Servlet Filter implementation class FiltroIMC
 */
@WebFilter(urlPatterns = {
        "/CalculoIMC",
        "/imc.html"
})//el filtro se aplica si se pide la página imc html o se llama al servler CalculoIMC
public class FiltroIMC extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroIMC() {
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
		//si tiene sesión, le dejo pasar
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println("A LA IDA");
		if (req.getSession(false)==null)
		{
			//no tiene sesión le mando al error
			HttpServletResponse resp = (HttpServletResponse)response;
			System.out.println("SIN SESIÓN - AL ERROR");
			resp.sendRedirect("error-login.html");
		}else {
			//si tiene sesión, le dejo pasar
			System.out.println("CON SESIÓN");
			chain.doFilter(request, response);
			System.out.println("A LA VUELTA");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
