package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ObtenerNombresSesion
 */
@WebServlet("/ObtenerNombresSesion")
public class ObtenerNombresSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerNombresSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext contexto = getServletContext();
		List<HttpSession> listasesiones = (List<HttpSession>) contexto.getAttribute("listaSesiones");
		List<String> listaNombres = new ArrayList<>();
		String nombreAux = "";
		for (HttpSession s:listasesiones)
		{
			nombreAux = (String) s.getAttribute("nombre");
			listaNombres.add(nombreAux);
		}
		
		String nombres = String.join(", ", listaNombres);
		System.out.println("nombres " + nombres);
		response.getWriter().write(nombres);
	}

	

}
