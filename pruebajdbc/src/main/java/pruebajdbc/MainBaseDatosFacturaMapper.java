package pruebajdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainBaseDatosFacturaMapper {

	public static void main(String[] args) {

		String cadenaConexion = "jdbc:mysql://localhost:3306/bd_facturacion";
		String usuarioBd = "root";
		String passwordBd = "root";

		String sql = """
					SELECT
				    f.num_factura AS NUM_FACTURA,
				    f.fecha_emision AS FECHA_EMISION,
				    f.total AS TOTAL,
				    c.nombre AS NOMBRE,
				    c.nif_cif AS NIF
				    FROM facturas f
				JOIN clientes c
				ON f.idcliente = c.idcliente
				""";

		try (Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBd, passwordBd);

				PreparedStatement sentencia = conexion.prepareStatement(sql);

				ResultSet resultado = sentencia.executeQuery()) {

			System.out.println("Conexión realizada correctamente");

			ArrayList<FacturaCliente> arrayListFacturaClientes = new ArrayList<>();
			while (resultado.next()) {

				FacturaCliente facturaCliente = mapear(resultado);
				arrayListFacturaClientes.add(facturaCliente);
			}
			System.out.println("FACTURAS y CLIENTES");
			System.out.println(arrayListFacturaClientes);

		} catch (SQLException e) {

			System.err.println("Error al acceder a la base de datos");
			System.err.println(e.getMessage());

			e.printStackTrace();
		}

	}

	/**
	 * Método que transforma una fila (rs) en un objeto FacturaCliente
	 * 
	 * @param rs la fila en curso de la base de datos
	 * @return La fila convertida en un objeto FacturaCliente
	 * @throws SQLException 
	 */
	public static FacturaCliente mapear(ResultSet rs) throws SQLException {
		FacturaCliente facturaCliente = null;

			String nfactura = rs.getString(1);// "NUM_FACTURA"
			Date fecha_emision = rs.getDate(2);// "FECHA_EMISION"
			float total = rs.getFloat(3);// "TOTAL"
			String nombre = rs.getString(4);// "NOMBRE"
			String nif = rs.getString(5);// "NIF"
			
			facturaCliente = new FacturaCliente(nfactura, fecha_emision.toLocalDate(), total, nombre, nif);

		return facturaCliente;

	}

}
