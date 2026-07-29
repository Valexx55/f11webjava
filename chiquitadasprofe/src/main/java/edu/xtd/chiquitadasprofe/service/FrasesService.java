package edu.xtd.chiquitadasprofe.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import edu.xtd.chiquitadasprofe.modelo.FraseChiquito;

@Service
public class FrasesService {

	public FraseChiquito fraseChiquitoRandom() {
		FraseChiquito fraseChiquito = null;
		RestClient restClient = null;

			restClient = RestClient.builder().baseUrl("https://chiquitadas.es").build();
			fraseChiquito = restClient.get().uri("/api/quotes/avoleorrr").retrieve().body(FraseChiquito.class);

		return fraseChiquito;
	}

	public List<FraseChiquito> obtenerTodasLasFrases() {
		List<FraseChiquito> listafrases = new ArrayList<>();
		RestClient restClient = RestClient.builder().baseUrl("https://chiquitadas.es").build();

			// Llamamos a la URI correcta y mapeamos el cuerpo a un Array de FraseChiquito
			FraseChiquito[] arrayFrases = restClient.get().uri("/api/quotes").retrieve().body(FraseChiquito[].class);
			// Convertimos el Array a una Lista de Java para que sea más fácil de manejar
			listafrases = Arrays.asList(arrayFrases);
			
		
		return listafrases;
	}

}
