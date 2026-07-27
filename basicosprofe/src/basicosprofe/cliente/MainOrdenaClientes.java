package basicosprofe.cliente;

import java.util.ArrayList;
import java.util.List;

public class MainOrdenaClientes {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente(1, "JAIME", "56987P", 25);
		Cliente cliente1 = new Cliente(2, "GONZALO", "45984Q", 33);
		Cliente cliente2 = new Cliente(3, "ANGEL", "65981X", 32);
		Cliente cliente3 = new Cliente(4, "SERGIO", "57859L", 20);
		Cliente cliente4 = new Cliente(5, "FRAN", "32857", 42);
		
		List<Cliente> lClientes = new ArrayList<>();
		
		lClientes.add(cliente);
		lClientes.add(cliente1);
		lClientes.add(cliente2);
		lClientes.add(cliente3);
		lClientes.add(cliente4);
		
		System.out.println("LISTA CLIENTES SIN ORDENAR");
		System.out.println(lClientes);
		
	
		ComparadorClientes comparador = new ComparadorClientes();
		//lClientes.sort(comparador);
		//Función Lambda, Función flecha, función anónima
		//lClientes.sort((c1, c2) -> c1.edad()-c2.edad());
		//function reference
		lClientes.sort(comparador::compare);
		lClientes.sort(MainOrdenaClientes::comparadorMain);
		System.out.println("LISTA CLIENTES ORDENADA POR EDAD");
		System.out.println(lClientes);
		
		lClientes.sort((Cliente c1, Cliente c2) -> {
			String nombre1 = c1.nombre();
			String nombre2 = c2.nombre();
			
			return nombre1.compareTo(nombre2);
		});
		System.out.println("LISTA CLIENTES ORDENADA POR NOMBRE");
		System.out.println(lClientes);
		
		System.out.println("LISTA CLIENTES for each");
		lClientes.forEach(c -> System.out.println(c.toString()));
	}
	
	static int comparadorMain(Cliente cliente1, Cliente cliente2) {
		
		return cliente1.edad()-cliente2.edad();
	}
}
