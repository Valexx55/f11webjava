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

	private Dni validar(String tipoDocumento, String numeroDocumento, String prefijoDocumento) throws Exception {
		Dni dniDev = null;

		dniDev = switch (tipoDocumento) {
		case "DNI" -> {
			int numero = Integer.parseInt(numeroDocumento);
			yield new Dni(numero);// retorno
		}
		case "NIE" -> {
			int numero = Integer.parseInt(numeroDocumento);
			Nie nie = new Nie();
			nie.numero = numero;
			nie.prefijo = prefijoDocumento.charAt(0);
			yield nie;
		}

		default -> throw new Exception("Error en los parámetros");// sólo una linea, sin yield
		};

		return dniDev;
	}

	// https://www.google.com/search?q=mundial+2026
	// https://www.google.com/search?q=mundial+2026&oq=MUNDIAL&gs_lcrp=EgRlZGdlKg0IARAAGIMBGLEDGIAEMgYIABBFGDkyDQgBEAAYgwEYsQMYgAQyEAgCEAAYgwEYsQMYgAQYigUyDQgDEAAYgwEYsQMYgAQyDQgEEAAYgwEYsQMYgAQyDQgFEAAYgwEYsQMYgAQyDQgGEAAYgwEYsQMYgAQyDQgHEAAYgwEYsQMYgAQyDQgIEAAYgwEYsQMYgAQyCAgJEOkHGPxV0gEIMzE1NWowajeoAgCwAgA&sourceid=chrome&ie=UTF-8
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// LEER TIPO DE DOCUMENTO

		try {

			Dni dni = validar(request.getParameter("tipoDocumento"), request.getParameter("numero"),request.getParameter("prefijo"));
			char letra = dni.calcularLetra();
			dni.letra = letra;
			String mensaje = dni.toString();
			response.getWriter().write("Su Documento con letra " + mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Petición incorrecta");
		}

	}

	// http://localhost:8080/appwebprofe/LetraDni?numero=53130984

}
