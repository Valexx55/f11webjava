package appwebprofe.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LetraDni
 */
@WebServlet("/LetraDni")
public class LetraDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetraDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LEER EL NÚMERO
		String numeroDni = request.getParameter("numero");
		//CALCULAR LA LETRA DE ESE NÚMERO
		int numero = Integer.parseInt(numeroDni);
		//creo el DNI
		Dni dni = new Dni(numero);
		//NOTA: el dni, ya se crea con su letra, que se calcula en el constrcutor
		String mensaje_respuesta = "Su Dni con letra es "+dni.numero+"-"+dni.letra;
		System.out.println(mensaje_respuesta);
		//ESCRIBIR LA RESPUESTA
		response.getWriter().write(mensaje_respuesta);
		
	}



}
