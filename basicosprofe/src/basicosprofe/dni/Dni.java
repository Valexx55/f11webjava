package basicosprofe.dni;

public class Dni {
	
	//secuencia de letras del DNI
	//final - Constante
	//static - A nivel de Clase - todos los Dnis comparten la misma SECUENCIA
	 static final String SECUENCIA_LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	 //a nivel de objeto - "Dinámico" - No estático
	 //cada Dni, tiene su propio número y letra
	int numero;//integer número entero
	char letra;//letra
	

	public Dni() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Dni(int numero, char letra) {
		//super();
		this.numero = numero;
		this.letra = letra;
	}


	//TODO programr este métódo en Java, para que funcione bien y devuelva la letra correspondiente a cada de DNI
	//calculándola como dice el algoritmo del Ministerio
	public char calcularLetra() {
		//como esta función devuelve un char, pues un char, letraDevuelta,
		char letraDevuelta = ' ';//1ª línea, un objeto/variable del tipo devuelto
			
			letraDevuelta = Dni.SECUENCIA_LETRAS_DNI.charAt(0);
			
		return letraDevuelta;//última línea, un return de la variable declarada en la línea 1
	}
	
	
	

}
