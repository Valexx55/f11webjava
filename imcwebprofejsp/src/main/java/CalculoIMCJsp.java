

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * Servlet implementation class CalculoIMCJsp
 */
@WebServlet("/CalculoIMCJsp")
public class CalculoIMCJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculoIMCJsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	//http://localhost:8080/imcwebprofejsp/index.html

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		// OBTENER PESO Y ALTURA
		String peso = request.getParameter("peso");
		String altura = request.getParameter("altura");
		
		if ((peso!=null)&&(altura!=null))

		{
			try {
				// PASAMOS DE TEXTO A NÚMERO real
				float pesof = Float.parseFloat(peso);
				float alturaf = Float.parseFloat(altura);

				// HAGO EL CÁLCULO

				float imc_numerico = pesof / (alturaf * alturaf);
				// TRADUCCIÓN de imc_numérico a imc_nominal
				String imc_nominal = ""; // new String ("");
				String foto = ""; // new String ("");
				String fotoDescripcion = ""; // new String ("");
				
				if (imc_numerico < 16) {
					// DESNUTRIDO
					imc_nominal = "DESNUTRIDO";
					foto = "desnutrido.jpg";
					fotoDescripcion = "Dibujo de alguien desnutrido";
				} else if ((imc_numerico >= 16) && (imc_numerico < 18)) {
					// DELGADO
					imc_nominal = "DELGADO";
					foto = "delgado.jpg";
					fotoDescripcion = "Dibujo de alguien delgado";
				} else if ((imc_numerico >= 18) && (imc_numerico < 25)) {
					// IDEAL
					imc_nominal = "IDEAL";
					foto = "ideal.png";
					fotoDescripcion = "Dibujo de alguien ideal";
				} else if ((imc_numerico >= 25) && (imc_numerico < 31)) {
					// SOBREPESO
					imc_nominal = "SOBREPESO";
					foto = "sobrepeso.png";
					fotoDescripcion = "Dibujo de alguien sobpreso";
				} else {
					// OBESO
					imc_nominal = "OBESO";
					foto = "obeso.jpg";
					fotoDescripcion = "Dibujo de alguien obeso";
				}
				// INFORMAR
				String respuesta = "Su imc es " + imc_numerico + " " + imc_nominal;
				System.out.println(respuesta);
				
				//asignamos el tipo de respuesta: TIPO MIME
				//response.setContentType("text/plain");
				response.setContentType("application/json");
				ImcRespuestaNueva imcRespuestaNueva = new ImcRespuestaNueva(pesof, alturaf, imc_nominal, imc_numerico, foto, fotoDescripcion);

				
				System.out.println(imcRespuestaNueva);
				
				request.setAttribute("resultadoImc", imcRespuestaNueva);

                request.getRequestDispatcher("/resultado-imc.jsp")
                        .forward(request, response);
			} 	
			catch (Exception e) {
				// TODO: handle exception
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				request.setAttribute("mensajeError", "peso y altura deben ser números");

                request.getRequestDispatcher("/error-imc.jsp")
                        .forward(request, response);
				
			}
		} else {
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			request.setAttribute("mensajeError", "Debe adjuntar los parámetro peso y altura");

            request.getRequestDispatcher("/error-imc.jsp")
                    .forward(request, response);
		}
		
		

	
	}

}
