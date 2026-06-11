package basicosprofe;

import java.util.Scanner;

/**
 * Esta clase es la principal de mis ejemplos básicos
 * @author Val M
 * @version 1.0
 * @since 1.0 11/06/2026
 * 
 */
public class EjemploUno {
 
	/**
	 * Esta es la función main, el punto de entrada de nuestra app
	 * @param args parámetros de entrada
	 */
	public static void main(String[] args) {
		System.out.println("MÓDULO WEB");
		//TODO cálculo del IMC
		//formula = peso kg / estatura al cuadrado m
		// < 16 DESNUTRIDO
		// >=16 Y <18 DELGADO
		// >=18 Y <25 IDEAL
		// >=25 Y < 31 SOBREPESO
		// >31 OBESO
		// pedir al usuaro su peso y su estatura
		// e informale de su imc numérico y nominal
		// 1.70 m 65 kg daría 22.49 IDEAL
		//Scanner scanner = 
		String palabra = new String("HOLA");//String() es el constructor
		System.out.println(palabra);
		
		Scanner scanner = new Scanner(System.in);//lector de teclado
		
		System.out.println("Intrdouce una palabra y pulsa INTRO");
		String palabraIntrducida = scanner.nextLine();
		System.out.println("el usuario metió " + palabraIntrducida);
		System.out.println("Intrdouce PESO KG");
		float peso = scanner.nextFloat();
		System.out.println("El peso es "+ peso);
		
		if (peso > 100)
		{
			System.out.println("La persona pesa más de 100");
		} else {
			System.out.println("La persona pesa menos de 100");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
