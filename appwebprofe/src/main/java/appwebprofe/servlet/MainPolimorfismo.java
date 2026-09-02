package appwebprofe.servlet;

public class MainPolimorfismo {
	
	public static void main(String[] args) {
		
		Dni dni = new Dni(53130, 'L');
		//Nie nie = new Nie();
		Dni nie = new Nie();
		
		nie.letra = 'G';
		nie.numero = 987423;
		/*((Nie)nie).prefijo = 'Y';
		
		Nie nie2 = (Nie)nie;
		nie2.prefijo = 'Y';*/
		
		char letraNie = nie.calcularLetra();
		System.out.println("La letra del NIE es " +letraNie);
		
		char letraDni = dni.calcularLetra();
		System.out.println("La letra del DNI es " +letraNie);
		
	}
}
