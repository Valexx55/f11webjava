package contexto;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 * Application Lifecycle Listener implementation class EscuchaContexto
 *
 */
@WebListener
public class EscuchaContexto implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EscuchaContexto() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         Usuario usuario1 = new Usuario("Jaime", "jaime");
         Usuario usuario2 = new Usuario("Manu", "manu");
         Usuario usuario3 = new Usuario("Sergio", "sergio");
         Usuario usuario4 = new Usuario("Fran", "fran");
         Usuario usuario5 = new Usuario("Gonzalo", "gonzalo");
         Usuario usuario6 = new Usuario("Angel", "angel");
         Usuario usuario7 = new Usuario("Oly", "oly");
         
         ArrayList<Usuario> listaUsuarios = new ArrayList<>();
         listaUsuarios.add(usuario1);
         listaUsuarios.add(usuario2);
         listaUsuarios.add(usuario3);
         listaUsuarios.add(usuario4);
         listaUsuarios.add(usuario5);
         listaUsuarios.add(usuario6);
         listaUsuarios.add(usuario7);
         
         ServletContext context = sce.getServletContext();
         context.setAttribute("listaUsuarios", listaUsuarios);
         
         List<HttpSession> listaSesiones = new ArrayList<>();
         context.setAttribute("listaSesiones", listaSesiones);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
