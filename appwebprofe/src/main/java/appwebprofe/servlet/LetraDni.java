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

    //https://www.google.com/search?q=mundial+2026
    //https://www.google.com/search?q=mundial+2026&oq=MUNDIAL&gs_lcrp=EgRlZGdlKg0IARAAGIMBGLEDGIAEMgYIABBFGDkyDQgBEAAYgwEYsQMYgAQyEAgCEAAYgwEYsQMYgAQYigUyDQgDEAAYgwEYsQMYgAQyDQgEEAAYgwEYsQMYgAQyDQgFEAAYgwEYsQMYgAQyDQgGEAAYgwEYsQMYgAQyDQgHEAAYgwEYsQMYgAQyDQgIEAAYgwEYsQMYgAQyCAgJEOkHGPxV0gEIMzE1NWowajeoAgCwAgA&sourceid=chrome&ie=UTF-8
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LEER TIPO DE DOCUMENTO 
		String tipoDocumento = request.getParameter("tipoDocumento");
		
		if (tipoDocumento.equals("DNI"))
		{
			//LEER EL NÚMERO
			String numeroDni = request.getParameter("numero");
			//CALCULAR LA LETRA DE ESE NÚMERO
			if (numeroDni!=null)
			{
				try {
					int numero = Integer.parseInt(numeroDni);
					//creo el DNI
					Dni dni = new Dni(numero);
					//NOTA: el dni, ya se crea con su letra, que se calcula en el constrcutor
					String mensaje_respuesta = "Su Dni con letra es "+dni.numero+"-"+dni.letra;
					System.out.println(mensaje_respuesta);
					//ESCRIBIR LA RESPUESTA
					response.getWriter().write(mensaje_respuesta);
				} catch (Exception e) {
					//HA FALLADO LA CONVERSIÓN DEL NÚMERO
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					response.getWriter().write("El parámetro no es un número válido");
				}
				
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().write("Falta el parámetro número");
			}
		} else if (tipoDocumento.equals("NIE"))
		{
			String numeroNie = request.getParameter("numero");
			String prefijoNie = request.getParameter("prefijo");
			try {
				int numero = Integer.parseInt(numeroNie);
				//creo el DNI
				Nie nie = new Nie();
				nie.numero = numero;
				nie.prefijo = prefijoNie.charAt(0);
				
				char letraNie = nie.calcularLetra();
				nie.letra = letraNie;
				
				//NOTA: el dni, ya se crea con su letra, que se calcula en el constrcutor
				String mensaje_respuesta = "Su NIE con letra es "+ nie.prefijo+nie.numero+"-"+nie.letra;
				System.out.println(mensaje_respuesta);
				//ESCRIBIR LA RESPUESTA
				response.getWriter().write(mensaje_respuesta);
			} catch (Exception e) {
				//HA FALLADO LA CONVERSIÓN DEL NÚMERO
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().write("El parámetro no es un número válido");
			}
		}
		
		//http://localhost:8080/appwebprofe/LetraDni?numero=53130984
		
	}



}
