package edu.xtd.chiquitadasprofe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xtd.chiquitadasprofe.modelo.FraseChiquito;
import edu.xtd.chiquitadasprofe.service.FrasesService;

@RestController//es un controller, que devuelve JSOn, no devolvemos páginas, solo una frase
@RequestMapping("/chiquitadas")//así configuramos Tomcat: si viene una petición /chiquitadas, es aquí, en esta clase
public class FrasesController {
	
	@Autowired
	FrasesService frasesService;

	@GetMapping("/aleatoria")
	public ResponseEntity<FraseChiquito> obtenerFraseAleatoria () {
		ResponseEntity<FraseChiquito> respuesta = null;
		FraseChiquito fraseChiquito = null;
		
			fraseChiquito = this.frasesService.fraseChiquitoRandom();
			System.out.println("Frase obtenida = " + fraseChiquito);
			respuesta = ResponseEntity.ok(fraseChiquito);
		
		return respuesta;
		
	}
}
