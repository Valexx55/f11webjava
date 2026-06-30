package edu.xtd.opotestprofe.modelo;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EntradaImc(

		@NotNull
		@Positive
		@DecimalMin("12.0")
		@DecimalMax("300.0")
		Float peso, 
		
		@NotNull
		@Positive
		@DecimalMin("0.30")
		@DecimalMax("2.50")
		Float altura) {

}
