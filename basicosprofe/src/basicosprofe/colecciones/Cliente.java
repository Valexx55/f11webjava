package basicosprofe.colecciones;

import java.time.LocalDate;

public record Cliente(
        Integer idCliente,
        String nombre,
        String nifCif,
        String direccion,
        String codigoPostal,
        String poblacion,
        String provincia,
        String telefono,
        String email,
        LocalDate fechaAlta
) implements Comparable<Cliente>{

	@Override
	public int compareTo(Cliente cliente) {
		//tengo que comparar cliente con this
		//si this es mayor, devuelvo un número positivo
		//si cliente es mayor, devuelvo un negativo
		//si son iguales un cero
		int resultado = 0;
		
			//resultado = this.idCliente.compareTo(cliente.idCliente);
			resultado = this.nombre.compareTo(cliente.nombre);
		
		return resultado;
	}

}
