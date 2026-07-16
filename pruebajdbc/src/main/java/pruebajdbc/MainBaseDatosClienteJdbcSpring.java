package pruebajdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MainBaseDatosClienteJdbcSpring {

	public static void main(String[] args) {

		String cadenaConexion = "jdbc:mysql://localhost:3306/bd_facturacion";
		String usuarioBd = "root";
		String passwordBd = "root";

		
		//CONFIGURAMOS DATASOURCE: LA FORMA DE CONECTARNOS A UN BASE DE DATOS DESDE SPRING (TOMCAT)
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(cadenaConexion);
		dataSource.setUsername(usuarioBd);
		dataSource.setPassword(passwordBd);
		//CREO EL JDBC-TEMPLATE Es como JDBC, pero más fácil. Me olvido de gestionar la Conexión
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		ClienteRepository clienteRepository = new ClienteRepository();
		clienteRepository.jdbcTemplate = jdbcTemplate;
		//Cliente cliente = new Cliente(0,"Juan Pérez García", "12345678R", "Calle Mayor 15 3ºB", "28013", "Madrid", "Madrid", "600123456", "juan.perez@example.com", LocalDate.now());

//		if (clienteRepository.insertarCliente(cliente))
//		{
//			System.out.println("CLIENTE INSERTADO CORRECTAMENTE");
//		} else {
//			System.out.println("FALLO INSERTANDO");
//		}
		
//		if (clienteRepository.borrarCliente(13))
//		{
//			System.out.println("CLIENTE BORRADO CORRECTAMENTE");
//		} else {
//			System.out.println("FALLO BORRANDO");
//		}
		
		Cliente cliente2 = new Cliente(16,"Juanita Pérez García", "12345678Q", "Calle Lérida", "28056", "Parla", "Madrid", "600123456", "juani.perez@example.com", LocalDate.now());

		
		if (clienteRepository.actualizarCliente(cliente2))
		{
			System.out.println("CLIENTE ACTUALIZADO CORRECTAMENTE");
		} else {
			System.out.println("FALLO ACTUALZANDO");
		}
		
	}

}
