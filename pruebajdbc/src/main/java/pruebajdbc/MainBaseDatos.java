package pruebajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainBaseDatos {

	public static void main(String[] args) {

		String cadenaConexion = "jdbc:mysql://localhost:3306/bd_facturacion";
		String usuarioBd = "root";
		String passwordBd = "root";

		String sql = "SELECT idcliente, nif_cif, nombre, email FROM clientes";

		try (Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBd, passwordBd);

				PreparedStatement sentencia = conexion.prepareStatement(sql);

				ResultSet resultado = sentencia.executeQuery()) {

			System.out.println("Conexión realizada correctamente");

			while (resultado.next()) {

				int id = resultado.getInt("idcliente");
				String nifCif = resultado.getString("nif_cif");
				String nombre = resultado.getString("nombre");
				String email = resultado.getString("email");

				System.out.printf("%d - %s - %s - %s%n", id, nifCif, nombre, email);
			}

		} catch (SQLException e) {

			System.err.println("Error al acceder a la base de datos");
			System.err.println(e.getMessage());

			e.printStackTrace();
		}

	}
}
