package pruebajdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainBaseDatos2 {

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

			while (resultado.next()) {

				String nfactura = resultado.getString(1);//"NUM_FACTURA"
				Date fecha_emision = resultado.getDate(2);//"FECHA_EMISION"
				float total = resultado.getFloat(3);//"TOTAL"
				String nombre = resultado.getString(4);//"NOMBRE"
				String nif = resultado.getString(5);//"NIF"

				//System.out.printf("%s - %t%F - %f - %s %s", nfactura, fecha_emision, total, nombre, nif);
				System.out.println("NUMFACTURA = " +nfactura);
				System.out.println("FECHA = " +fecha_emision);
				System.out.println("TOTAL = " +total);
				System.out.println("NOMBRE = " +nombre);
				System.out.println("NIF = " +nif);
				System.out.println("-------------------" );
				System.out.println("-------------------" );
				System.out.println("-------------------" );
			}

		} catch (SQLException e) {

			System.err.println("Error al acceder a la base de datos");
			System.err.println(e.getMessage());

			e.printStackTrace();
		}

	}
}
