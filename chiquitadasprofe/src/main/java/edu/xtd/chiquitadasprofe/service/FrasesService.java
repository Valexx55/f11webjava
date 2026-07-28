package edu.xtd.chiquitadasprofe.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import edu.xtd.chiquitadasprofe.modelo.FraseChiquito;

@Service
public class FrasesService {
	
	public FraseChiquito fraseChiquitoRandom () {
		FraseChiquito fraseChiquito = null;
		RestClient restClient = null;
		
			restClient = RestClient.builder().baseUrl("https://chiquitadas.es").build();
			fraseChiquito =  restClient.get().uri("/api/quotes/avoleorrr").retrieve().body(FraseChiquito.class);
		
		return fraseChiquito;
	}

}
