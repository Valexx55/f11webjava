package edu.xtd.chiquitadasprofe.controller;

import java.util.List;
import java.util.function.Predicate;

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
	public ResponseEntity<List<FraseChiquito>> obtenerTodasLasFrasesMasUno() {
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
	
	@GetMapping("/todas-mas-uno") // GET http://localhost:8080/chiquitadas/todas-mas-uno
	public ResponseEntity<List<FraseChiquito>> obtenerTodasLasFrases() {
		ResponseEntity<List<FraseChiquito>> respuesta = null;
		// 1. Llamamos al nuevo método de nuestro servicio
		List<FraseChiquito> listaFrases = null;
		List<FraseChiquito> frasesconidIncrementado = null;

		listaFrases = this.frasesService.obtenerTodasLasFrases();

		// transformamos la lista de frases, incrementado el id de cada una
		/*
		 * frasesconidIncrementado = listaFrases.stream() .map((FraseChiquito f) -> new
		 * FraseChiquito(f.frase(), f.id() + 1)) .toList();
		 */

		/*frasesconidIncrementado = listaFrases
				.stream()
				.map((FraseChiquito f) -> {
						FraseChiquito fraseTransformada = null;

							fraseTransformada = new FraseChiquito(f.frase(), f.id()+1);

				return fraseTransformada;
				})
				.toList();*/
		
		/*frasesconidIncrementado = listaFrases
				.stream()
				.map(f -> new FraseChiquito(f.frase(), f.id()+1))
				.toList();*/
		
		frasesconidIncrementado = listaFrases
				.stream()
				.map(this::transformarFraseChiquito)
				.toList();

		// 2. Opcional: Imprimir por consola para depurar (como hiciste en el otro //
		// método)
		System.out.println("Número de frases obtenidas = " + listaFrases.size());
		respuesta = ResponseEntity.ok(frasesconidIncrementado);

		// 3. Devolvemos la respuesta con código 200 OK y la lista completa
		return respuesta;
	}
	
	
	
	@GetMapping("/frases-mas-de-10") // GET http://localhost:8080/chiquitadas/frases-mas-de-10
	public ResponseEntity<List<FraseChiquito>> obtenerFrasesDeMasDe10() {
		ResponseEntity<List<FraseChiquito>> respuesta = null;
		// 1. Llamamos al nuevo método de nuestro servicio
		List<FraseChiquito> listaFrases = null;
		List<FraseChiquito> listaFrasesFiltradas = null;

			listaFrases = this.frasesService.obtenerTodasLasFrases();
	
			Predicate<FraseChiquito> predicado = f -> f.frase().length() >=10;
			//Predicate<FraseChiquito> predicadoMasDe5Palabras = f -> f.frase().split(" ").length>5;
			/*listaFrasesFiltradas = 
					listaFrases
					.stream()
					.filter(f -> f.frase().length() >=10)
					.toList();*/
			
			listaFrasesFiltradas = 
					listaFrases
					.stream()
					.filter(predicado)
					.toList();
			
			respuesta = ResponseEntity.ok(listaFrasesFiltradas);
		
			// 3. Devolvemos la respuesta con código 200 OK y la lista completa
		return respuesta;
	}
	
	
	private FraseChiquito transformarFraseChiquito (FraseChiquito fraseEntrada)
	{
		FraseChiquito fraseSalida = null;
		
			fraseSalida = new FraseChiquito(fraseEntrada.frase(), fraseEntrada.id()+1);
		
		return fraseSalida;
	}
}
