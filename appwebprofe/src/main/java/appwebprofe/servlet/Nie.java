package appwebprofe.servlet;

public class Nie extends Dni {
	
	char prefijo;
	

	@Override
	public char calcularLetra() {
		System.out.println("Estoy en calcularLetra de NIE");
		
		return 'W';
	}
}
