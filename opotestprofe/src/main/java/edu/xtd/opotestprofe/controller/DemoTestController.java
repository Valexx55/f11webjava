package edu.xtd.opotestprofe.controller;
//package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import edu.xtd.opotestprofe.service.DemoService;
import jakarta.validation.Valid;

//CONTROLLER ES LA CLASE QUE VE EL CLIENTE
//MISIÓN: RECIBIR PETICIONES HTTP Y CONTESTARLAS
//ES KARL! (EL DUEÑO DEL GATO CHOUPPETTE)

//REST - por defecto, se asume JSON como formato de respuesta

@RestController
@RequestMapping("/demo") //todas las peticiones que sea /demo, son para esta clase
public class DemoTestController {
	
	@Autowired //Inyección de dependecias con la anotación set
	DemoService demoService;
	
	Logger logger = LoggerFactory.getLogger(DemoTestController.class);
	
	//inyección de dependencias por el constructor
	/*public DemoTestController (DemoService demoService)
	{
		//System.out.println(demoService.toString());
		this.demoService = demoService;
	}*/
	
	
	
	//http://localhost:8080/demo/saludo
	@GetMapping("/saludo") //una petición GET /demo/saludo vendrá aquí
	public String saludo () {
		String saludo = null;
		boolean huboerror = false;
		try {
			logger.debug("KA PACCHAOOO saludo ()");
			logger.info("KA PACCHAOOO saludo () INFO");
			//saludo.length();
			saludo = "HOLA";
			saludo.charAt(6);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("Ha ocurrido una excepción en /saludo", e);
			huboerror = true;
			throw e;
		}finally {
			//esta sección, se ejecuta siempre, haya habido fallo o no
			logger.debug("en el finally de /saludo");
			if (huboerror) {
				logger.debug("hubo error para llegar al finally");
			}
		}
		
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
	{	SalidaImc salidaImc = null;
	
			salidaImc = this.demoService.caluclarIMC(entradaImc);
	
		return salidaImc;
		
	}
	
	@PostMapping("/calcular-imc-re")
	public ResponseEntity<SalidaImc> calcularIMCRE (@Valid @RequestBody EntradaImc entradaImc, BindingResult bindingResult)
	{	ResponseEntity<SalidaImc> responseEntity = null;//REPRESENTA EL HTTP DE VUELTA CUERPO Y CABECERA
		SalidaImc salidaImc = null;
		
			if (!bindingResult.hasErrors())
			{
				logger.debug("IMC sin errores");
				salidaImc = this.demoService.caluclarIMC(entradaImc);
				responseEntity = ResponseEntity.ok(salidaImc);
				//responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(salidaImc);
			} else {
				logger.error("IMC recibido con errores");
				responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(salidaImc);
			}
	
			
	
		return responseEntity;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
