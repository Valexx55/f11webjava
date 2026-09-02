package basicosprofe.cliente;

import java.util.Comparator;

public class ComparadorClientesEdad implements Comparator<Cliente>{

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		
		return cliente1.edad()-cliente2.edad();
	}

}
