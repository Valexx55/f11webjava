package edu.xtd.chiquitadasprofe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xtd.chiquitadasprofe.modelo.FraseChiquito;
import edu.xtd.chiquitadasprofe.service.FrasesService;

@RestController // es un controller, que devuelve JSOn, no devolvemos páginas, solo una frase
@RequestMapping("/chiquitadas") // así configuramos Tomcat: si viene una petición /chiquitadas, es aquí, en esta
								// clase
public class FrasesController {

	@Autowired
	FrasesService frasesService;

	@GetMapping("/aleatoria")
	public ResponseEntity<FraseChiquito> obtenerFraseAleatoria() {
		ResponseEntity<FraseChiquito> respuesta = null;
		FraseChiquito fraseChiquito = null;

		fraseChiquito = this.frasesService.fraseChiquitoRandom();
		System.out.println("Frase obtenida = " + fraseChiquito);
		respuesta = ResponseEntity.ok(fraseChiquito);

		return respuesta;

	}

	@GetMapping("/todas") // GET http://localhost:8080/chiquitadas/todas
	public ResponseEntity<List<FraseChiquito>> obtenerTodasLasFrases() {
		ResponseEntity<List<FraseChiquito>> respuesta = null;
		// 1. Llamamos al nuevo método de nuestro servicio
		List<FraseChiquito> listaFrases = null;

			listaFrases = this.frasesService.obtenerTodasLasFrases();
	
			// 2. Opcional: Imprimir por consola para depurar (como hiciste en el otro // método)
			System.out.println("Número de frases obtenidas = " + listaFrases.size());
			respuesta = ResponseEntity.ok(listaFrases);
		
			// 3. Devolvemos la respuesta con código 200 OK y la lista completa
		return respuesta;
	}
}
