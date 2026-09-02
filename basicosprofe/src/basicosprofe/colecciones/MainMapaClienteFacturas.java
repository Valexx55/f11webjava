package basicosprofe.colecciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainMapaClienteFacturas {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente(1, "Informática López SL", "B12345678", "Calle Mayor 15", "28013", "Madrid",
				"Madrid", "911234567", "info@lopez.es", LocalDate.of(2026, 1, 10));

		Cliente cliente2 = new Cliente(2, "Tecnología Sur SL", "B87654321", "Avenida Andalucía 25", "41001", "Sevilla",
				"Sevilla", "954123456", "contacto@tecnologiasur.es", LocalDate.of(2026, 2, 3));

		Cliente cliente3 = new Cliente(3, "Servicios García", "12345678A", "Calle Toledo 8", "28981", "Parla", "Madrid",
				"916987654", "garcia@email.es", LocalDate.of(2026, 3, 15));

		// FACTURA CLIENTE 1
		Factura factura1 = new Factura(1, 1, "F-2026-001", LocalDate.of(2026, 1, 20), "EMITIDA", null, 1000, 210, 1210,
				LocalDateTime.of(2026, 1, 20, 10, 30), null);

		// FACTURA CLIENTE 2

		Factura factura2 = new Factura(2, 2, "F-2026-002", LocalDate.of(2026, 2, 5), "PAGADA",
				"Pago mediante transferencia", 500, 105, 605, LocalDateTime.of(2026, 2, 5, 12, 15),
				LocalDateTime.of(2026, 2, 10, 9, 0));

		Factura factura3 = new Factura(3, 2, "F-2026-003", LocalDate.of(2026, 2, 18), "EMITIDA", null, 800, 168, 968,
				LocalDateTime.of(2026, 2, 18, 11, 0), null);

		// FACTURAS CLIENTE 3
		Factura factura4 = new Factura(4, 3, "F-2026-004", LocalDate.of(2026, 3, 20), "BORRADOR",
				"Pendiente de revisar", 200, 42, 242, LocalDateTime.of(2026, 3, 20, 8, 45), null);

		Factura factura5 = new Factura(5, 3, "F-2026-005", LocalDate.of(2026, 4, 2), "EMITIDA", null, 600, 126, 726,
				LocalDateTime.of(2026, 4, 2, 10, 0), null);

		Factura factura6 = new Factura(6, 3, "F-2026-006", LocalDate.of(2026, 4, 20), "PAGADA",
				"Pagada por transferencia", 300, 63, 363, LocalDateTime.of(2026, 4, 20, 13, 20),
				LocalDateTime.of(2026, 4, 25, 9, 30));

		Map<Cliente, List<Factura>> mapaCliFactura = new HashMap<>();

		List<Factura> facturasCli1 = new ArrayList<>();
		facturasCli1.add(factura1);

		List<Factura> facturasCli2 = new ArrayList<>();
		facturasCli2.add(factura2);
		facturasCli2.add(factura3);

		List<Factura> facturasCli3 = new ArrayList<>();
		facturasCli3.add(factura4);
		facturasCli3.add(factura5);
		facturasCli3.add(factura6);

		mapaCliFactura.put(cliente1, facturasCli1);
		mapaCliFactura.put(cliente2, facturasCli2);
		mapaCliFactura.put(cliente3, facturasCli3);

		mostrarMapaClientesFacturas(mapaCliFactura);
		
		int numclientes = contarClientes(mapaCliFactura);
		System.out.println("HAY " +  numclientes + " Clientes");
		
		int total = totalFacturacion(mapaCliFactura);
		System.out.println("TOTAL FACTURAS " +  total + " euros ");
		
		int total2 = totalFacturacion2(mapaCliFactura);
		System.out.println("TOTAL FACTURAS " +  total2 + " euros ");
		
		int totalImporteCliente = totalFacturacionCliente(mapaCliFactura, cliente1);
		System.out.println("TOTAL IMPORTE CLIENTE 1 " +  totalImporteCliente + " euros ");
		
		int totalImporteCliente2 = totalFacturacionCliente2(mapaCliFactura, cliente1);
		System.out.println("TOTAL IMPORTE CLIENTE 1 " +  totalImporteCliente2 + " euros ");
	}

	public static void mostrarMapaClientesFacturas(Map<Cliente, List<Factura>> mapaCliFactura) {
		Set<Cliente> setClientes = mapaCliFactura.keySet();

		// setClientes.forEach(null);

		for (Cliente c : setClientes) {
			System.out.println("***********************");
			System.out.println("Cliente " + c);
			List<Factura> listaFacturas = mapaCliFactura.get(c);
			for (Factura f : listaFacturas) {
				System.out.println("Factura " + f);
			}
			System.out.println("***********************");
		}
	}
	
	
	public static int contarClientes (Map<Cliente, List<Factura>> mapaCliFactura)
	{
		int numClientes = 0;
		
			numClientes = mapaCliFactura.keySet().size();
		
		return numClientes;
	}
	
	public static int totalFacturacion (Map<Cliente, List<Factura>> mapaCliFactura)
	{
		int total = 0;
		
			Set<Cliente> setClientes = mapaCliFactura.keySet();
			for (Cliente c : setClientes) {
				List<Factura> listaFacturas = mapaCliFactura.get(c);
				for (Factura f : listaFacturas) {
					total = total + f.total();
				}
			}
		
		return total;
	}
	
	public static int totalFacturacionCliente (Map<Cliente, List<Factura>> mapaCliFactura, Cliente c)
	{
		int total = 0;
		
			List<Factura> lfacturas = mapaCliFactura.get(c);
			for (Factura f: lfacturas)
			{
				total = total + f.total();
			}
			
			
		return total;
	}
	
	public static int totalFacturacionCliente2 (Map<Cliente, List<Factura>> mapaCliFactura, Cliente c)
	{
		int total = 0;
		
			List<Factura> lfacturas = mapaCliFactura.get(c);
			total = lfacturas.stream().mapToInt(f-> f.total()).sum();
			
			
		return total;
	}
	
	public static int totalFacturacion2 (Map<Cliente, List<Factura>> mapaCliFactura)
	{
		int total = 0;
		
			total = mapaCliFactura.entrySet().stream().
					flatMap(entrada -> entrada.getValue().stream())
					.mapToInt(factura -> factura.total()).sum();
		
		return total;
	}
	//TODO
	/*
	 * 1. HACED UN MÉTODO QUE RECIBA EL MAPA DE CLIENTE-FACTURAS Y DIGA CUÁNTOS CLIENTES HAY
	 * 
	 * 2. HACED UN MÉTODO QUE RECIBA EL MAPA DE CLIENTE-FACTURAS Y DIGA EL TOTAL DE FACTURACIÓN 
	 * DE TODOS LOS CLIENTES
	 * 
	 * 3. HACED UN MÉTODO QUE RECIBA EL MAPA DE CLIENTE-FACTURAS Y UN CLIENTE Y DIGA CUÁNTO SUMAN 
	 * LAS FACTURAS DE ESE CLIENTE
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
