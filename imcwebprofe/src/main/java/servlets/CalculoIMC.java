package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CaculoIMC
 */
@WebServlet("/CalculoIMC")
public class CalculoIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculoIMC() {
		super();
		// TODO Auto-generated constructor stub
	}

	// http://localhost:8080/imcwebprofe/CalculoIMC?peso=90&altura=2
	
	// http://IP:PUERTO/APP/SERVLET?parámetros..
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// OBTENER PESO Y ALTURA
		String peso = request.getParameter("peso");
		String altura = request.getParameter("altura");

		// PASAMOS DE TEXTO A NÚMERO real
		float pesof = Float.parseFloat(peso);
		float alturaf = Float.parseFloat(altura);

		// HAGO EL CÁLCULO

		float imc_numerico = pesof / (alturaf * alturaf);
		// TRADUCCIÓN de imc_numérico a imc_nominal
		String imc_nominal = ""; // new String ("");
		if (imc_numerico < 16) {
			// DESNUTRIDO
			imc_nominal = "DESNUTRIDO";
		} else if ((imc_numerico >= 16) && (imc_numerico < 18)) {
			// DELGADO
			imc_nominal = "DELGADO";
		} else if ((imc_numerico >= 18) && (imc_numerico < 25)) {
			// IDEAL
			imc_nominal = "IDEAL";
		} else if ((imc_numerico >= 25) && (imc_numerico < 31)) {
			// SOBREPESO
			imc_nominal = "SOBREPESO";
		} else {
			// OBESO
			imc_nominal = "OBESO";
		}
		// INFORMAR
		String respuesta = "Su imc es " + imc_numerico + " " + imc_nominal;
		System.out.println(respuesta);

		response.getWriter().write(respuesta);

	}

}
