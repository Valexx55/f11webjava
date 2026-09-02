package pruebajdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Esta clase, se dedica a traducir registros de la base de datos en objetos de
 * java
 */
public class FacturaClienteRowMapper implements RowMapper<FacturaCliente> {

	@Override
	public FacturaCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		FacturaCliente facturaCliente = null;
		
			System.out.println("Número de fila " + rowNum);

			String nfactura = rs.getString(1);// "NUM_FACTURA"
			Date fecha_emision = rs.getDate(2);// "FECHA_EMISION"
			float total = rs.getFloat(3);// "TOTAL"
			String nombre = rs.getString(4);// "NOMBRE"
			String nif = rs.getString(5);// "NIF"
	
			facturaCliente = new FacturaCliente(nfactura, fecha_emision.toLocalDate(), total, nombre, nif);

		return facturaCliente;

	}

}
