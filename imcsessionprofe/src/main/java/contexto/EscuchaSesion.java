package contexto;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EscuchaSesion
 *
 */
@WebListener
public class EscuchaSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EscuchaSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    		System.out.println("Sesión creada NUEVA = " + se.getSession().getId());
    		ServletContext contexto = se.getSession().getServletContext();
    		//contexto.setAttribute(null, contexto)
    		List<HttpSession> listasesiones = (List<HttpSession>) contexto.getAttribute("listaSesiones");//, listaSesiones);
    		listasesiones.add(se.getSession());
    		contexto.setAttribute("listaSesiones", listasesiones);
    		
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
