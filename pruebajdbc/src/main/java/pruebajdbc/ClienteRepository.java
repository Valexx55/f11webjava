package pruebajdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * En esta clase, vamos a agrupar las operaciones de base de datos sobre los
 * clientes
 * 
 * -INSERTAR -BORRAR -ACTUALIZAR -CONSULTAR
 */
public class ClienteRepository {

	JdbcTemplate jdbcTemplate;

	private static final String INSERTAR_CLIENTE = """
			INSERT INTO clientes
				(nombre, nif_cif, direccion, codigopostal, poblacion, provincia, telefono, email, fecha_alta)
			VALUES
			(?, ?, ?, ?, ?, ?, ?, ?, ?);
			""";

	private static final String BORRAR_CLIENTE = "DELETE FROM clientes WHERE (idcliente = ?)";

	private static final String ACTUALIZAR_CLIENTE = """
						UPDATE clientes
			SET
			    nombre = ?,
			    nif_cif = ?,
			    direccion = ?,
			    codigopostal = ?,
			    poblacion = ?,
			    provincia = ?,
			    telefono = ?,
			    email = ?
			WHERE idcliente = ?;
						""";

	public boolean insertarCliente(Cliente cliente) {
		boolean inserccionOk = false;

		int numFilasAfectadas = this.jdbcTemplate.update(INSERTAR_CLIENTE, cliente.nombre(), cliente.nif_cif(),
				cliente.direccion(), cliente.codigopostal(), cliente.poblacion(), cliente.provincia(),
				cliente.telefono(), cliente.email(), cliente.fecha_alta());

		if (numFilasAfectadas == 1) {
			inserccionOk = true;
		} /*
			 * else { inserccionOk = false; }
			 */

		// inserccionOk = (numFilasAfectadas == 1);

		return inserccionOk;
	}

	public boolean borrarCliente(int idcliente) {
		boolean borradoOk = false;

		int numFilasAfectadas = this.jdbcTemplate.update(BORRAR_CLIENTE, idcliente);
		if (numFilasAfectadas == 1) {
			borradoOk = true;
		}

		return borradoOk;
	}

	public boolean actualizarCliente (Cliente cliente)
	{
		boolean actualizarOK = false;
		int numFilasAfectadas = 0;
		
			numFilasAfectadas = this.jdbcTemplate.update(ACTUALIZAR_CLIENTE,
						cliente.nombre(),
						cliente.nif_cif(),
						cliente.direccion(),
						cliente.codigopostal(),
						cliente.poblacion(),
						cliente.provincia(),
						cliente.telefono(),
						cliente.email(),
						cliente.idcliente()
						);
			actualizarOK = numFilasAfectadas == 1;
		
		return actualizarOK;
	}

	public boolean borrarClienteChatty(int idcliente) {

		return this.jdbcTemplate.update(BORRAR_CLIENTE, idcliente) == 1;
	}

}
