package pruebajdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MainBaseDatosFacturaJdbcSpring {

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

		//CONFIGURAMOS DATASOURCE: LA FORMA DE CONECTARNOS A UN BASE DE DATOS DESDE SPRING (TOMCAT)
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(cadenaConexion);
		dataSource.setUsername(usuarioBd);
		dataSource.setPassword(passwordBd);
		//CREO EL JDBC-TEMPLATE Es como JDBC, pero más fácil. Me olvido de gestionar la Conexión
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		FacturaClienteRowMapper mapper = new FacturaClienteRowMapper();
		List<FacturaCliente> listaFacturaClientes =  jdbcTemplate.query(sql, mapper);
		
		System.out.println(listaFacturaClientes);
		
	}

}
