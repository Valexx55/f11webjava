package edu.xtd.opotestprofe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.xtd.opotestprofe.modelo.EntradaImc;
import edu.xtd.opotestprofe.modelo.SalidaImc;
import edu.xtd.opotestprofe.modelo.Test;
import jakarta.validation.Valid;

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
	
	@GetMapping("/testJson") // /demo/testJson
	public Test obtenerTestJson ()
	{
		Test test = new Test(1, "La Consti", 10);
		return test;
	}
	
	@PostMapping("/guardarTest") // http://localhost:8080/demo/guardarTest
	public Test guardarTest (@RequestBody Test test)
	{
		System.out.println("Test recibido = "+test);
		return test;
	}
	
	/**
	 * HACED UN MÉTODO NUEVO PARA EL CÁLCULO DEL IMC
	 * SE RECIBE UN JSON CON LOS ATRIBUTOS PESO Y ALTURA
	 * SE DEVUELVE OTRO JSON CON LOS ATRIBUTOS PESO, ALTURA, IMC NUMÉRICO
	 * E IMC NOMINAL
	 */
	@PostMapping("/calcular-imc")
	public SalidaImc calcularIMC (@Valid @RequestBody EntradaImc entradaImc)
	{
		SalidaImc salidaImc = null;
		float imcnum = 0f;
		String imcNominal = "";
		
			imcnum = entradaImc.peso() / (entradaImc.altura()*entradaImc.altura());
			
			System.out.println("IMC RECIBIDO " + entradaImc);
			
			if (imcnum < 16) {
				imcNominal = "Desnutrido";
			} else if (imcnum >= 16 && imcnum <18) {
				imcNominal = "Delgado";
			} else if (imcnum >= 18 && imcnum <25) {
				imcNominal = "Ideal";
			} else if (imcnum >= 25 && imcnum <21) {
				imcNominal = "Sobrepeso";
			} else if (imcnum > 31) {
				imcNominal = "Obeso";
			}
			
			salidaImc = new SalidaImc(entradaImc.peso(), entradaImc.altura(), imcnum, imcNominal);
			
			System.out.println("IMC CALCULADO " + salidaImc);
		
		return salidaImc;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
