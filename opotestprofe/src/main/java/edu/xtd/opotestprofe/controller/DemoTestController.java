package edu.xtd.opotestprofe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//CONTROLLER ES LA CLASE QUE VE EL CLIENTE
//MISIÓN: RECIBIR PETICIONES HTTP Y CONTESTARLAS
//ES KARL! (EL DUEÑO DEL GATO CHOUPPETTE)

//REST - por defecto, se asume JSON como formato de respuesta

@RestController
@RequestMapping("/demo") //todas las peticiones que sea /demo, son para esta clase
public class DemoTestController {
	
	//http://localhost:8080/demo/saludo
	@GetMapping("/saludo") //una petición GET /demo/saludo vendrá aquí
	public String saludo () {
		String saludo = "HOLA";
		return saludo;
	}
	
	@GetMapping("/saludo-personalizado") //una petición GET /demo/saludo-personalizado?nombre=Vale&edad=42 
	public String saludoPersonalizado (@RequestParam String nombre, @RequestParam int edad) {
		String saludo = "HOLA "+nombre+ " tu edad es "+edad;
		return saludo;
	}
	
	@GetMapping("/obtenerTest/{id}")
	public String obtenerTest(@PathVariable int id) //GET /demo/obtenerTest/2
	{
		String respuesta = "El cliente quiere el test "+id;
		return respuesta;
	}
	
	
	
	
	

}
