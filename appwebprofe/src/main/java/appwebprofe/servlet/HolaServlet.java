package appwebprofe.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Servlet implementation class HolsServlet
 */
@WebServlet("/HolaServlet")
public class HolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //http://localhost:8080/appwebprofe/HolaServlet GET
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//vamos a coger los valores de los parámetros nombre y edad
		String nombreRecibido =  request.getParameter("nombre");
		String edadRecibida =  request.getParameter("edad");
		
		if ((nombreRecibido!=null)&&(edadRecibida!=null)) {
			
			System.out.println("Nombre recibido = " + nombreRecibido);
			System.out.println("Edad recibido = " + edadRecibida);
			String mensaje = "Te llamas " + nombreRecibido +" y tienes " + edadRecibida +" años";
			
			response.getWriter().append(mensaje);
			
		} else {
			//tengo que devolver 400
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append("Debes indicar parámetros nombre y edad");
		}
		
		
	}

	//http://localhost:8080/appwebprofe/HolaServlet
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
