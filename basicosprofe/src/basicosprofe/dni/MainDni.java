package basicosprofe.dni;

import java.util.Scanner;

public class MainDni {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//PEDIR UN NÚMERO Y UNA LETRA
			
		System.out.println("Intro su letra Dni");
		String letradni = scanner.nextLine();
		System.out.println("Letra dni = " + letradni);
		
		System.out.println("Intro su nº Dni");
		int numdni = scanner.nextInt();
		System.out.println("Num dni = " + numdni);	

		
		//Y CON ESA INFO, CONSTRUIMOS UN DNI
		//Dni dni = new Dni();
		Dni dni = new Dni(numdni, letradni.charAt(0));
		Dni dni2 = new Dni(789, 'B');
		//System.out.println("NUMERO DNI2 " + dni2.numero);
		//dni.numero = numdni;
		//dni.letra = letradni.charAt(0);
		System.out.println("DNI = " + dni.numero + "-" +dni.letra);
		System.out.println("DNI2 = " + dni2.numero + "-" +dni2.letra);
		//DESPUÉS, VAMOS A COMPROBAR SI EL DNI ES CORRECTO
		//SI LA LETRA SE CORRESPONDE CON EL NÚMERO
		char letraCalculada = dni.calcularLetra();
		System.out.println("Letra calculada = "+letraCalculada);
		letraCalculada = dni2.calcularLetra();
		System.out.println("Letra calculada = "+letraCalculada);
		
		 String saludo = "HOLA";
		int longi= saludo.length();
		System.out.println("longitud = " +longi);
	}

}










