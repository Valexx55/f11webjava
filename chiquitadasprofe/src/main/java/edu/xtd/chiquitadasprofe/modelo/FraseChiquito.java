package edu.xtd.chiquitadasprofe.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FraseChiquito(
		
		@JsonProperty("quote")//este es el nombre del atributo JSON
		String frase, //y esto el nombre que yo le quiero dar
		@JsonProperty("id")
		Long id) {

}
