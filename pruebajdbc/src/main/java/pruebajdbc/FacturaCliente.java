package pruebajdbc;

import java.time.LocalDate;

public record FacturaCliente(
		String numFactura, 
		LocalDate fechaEmision,
		float total,
		String nombreCliente,
		String nifCliente) {

}
