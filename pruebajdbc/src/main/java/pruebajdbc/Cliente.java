package pruebajdbc;

import java.time.LocalDate;

public record Cliente(
		int idcliente,
		String nombre,
		String nif_cif,
		String direccion, 
		String codigopostal,
		String poblacion,
		String provincia,
		String telefono,
		String email,
		LocalDate fecha_alta) {

}
