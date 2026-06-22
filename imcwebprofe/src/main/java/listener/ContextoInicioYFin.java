package listener;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextoInicioYFin
 *
 */
@WebListener
public class ContextoInicioYFin implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ContextoInicioYFin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("APP INICIADA :)");
		//este objeto se crea al iniciar la app y es un bolso grande, 
		//donde puedo guardar información útil y usarla a lo largo de toda
		//la app
		ServletContext servletContext = sce.getServletContext();
		//con "numero_veces" quiero llevar la cuenta de cuántas veces llaman a CalculoIMC
		servletContext.setAttribute("numero_veces", 0);
		
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("APP FINALIZADA");
	}

}
