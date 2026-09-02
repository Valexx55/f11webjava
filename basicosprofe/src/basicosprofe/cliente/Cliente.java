package basicosprofe.cliente;

public record Cliente(
		long id,
		String nombre,
		String nif,
		int edad) implements Comparable<Cliente>{

	@Override
	public int compareTo(Cliente cliente) {
		return this.nombre.compareTo(cliente.nombre);
	}

}
