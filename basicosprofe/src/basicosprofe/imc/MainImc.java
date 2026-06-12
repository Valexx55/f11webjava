package basicosprofe.imc;

import java.util.Scanner;

/**
 *      Cálculo del IMC
		//formula = peso kg / estatura al cuadrado m
		// < 16 DESNUTRIDO
		// >=16 Y <18 DELGADO
		// >=18 Y <25 IDEAL
		// >=25 Y < 31 SOBREPESO
		// >31 OBESO
		// pedir al usuaro su peso y su estatura
		// e informale de su imc numérico y nominal
		// 1.70 m 65 kg daría 22.49 IDEAL
 */
public class MainImc {
	
	public static void main(String[] args) {
		//0 creamos el Scanner para leer de teclado
		Scanner scanner = new Scanner(System.in);
		//PEDIR PESO
		System.out.println("Intro su peso (kg)");
		float peso = scanner.nextFloat();
		//PEDIR ALTURA
		System.out.println("Intro su altura (m)");
		float altura = scanner.nextFloat();
		//CALCULAR EL IMC
		float imc_numerico = peso/(altura*altura);
		//TRADUCCIÓN de imc_numérico a imc_nominal
		String imc_nominal = ""; //new String ("");
		if (imc_numerico<16)
		{
			//DESNUTRIDO
			imc_nominal = "DESNUTRIDO";
		}else if ((imc_numerico>=16)&&(imc_numerico<18))
		{
			//DELGADO
			imc_nominal = "DELGADO";
		}else if ((imc_numerico>=18)&&(imc_numerico<25))
		{
			//IDEAL
			imc_nominal = "IDEAL";
		}else if ((imc_numerico>=25)&&(imc_numerico<31))
		{
			//SOBREPESO
			imc_nominal = "SOBREPESO";
		}else 
		{
			//OBESO
			imc_nominal = "OBESO";
		}
		//INFORMAR
		System.out.println("Su imc es " +  imc_numerico + " " + imc_nominal);
	}

	
	
}
