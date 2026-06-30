package edu.xtd.opotestprofe.modelo;

import jakarta.validation.constraints.Positive;

public record EntradaImc(
		@Positive
		float peso, 
		
		@Positive
		float altura) {

}
