package appwebprofe.servlet;

public class Nie extends Dni {

	char prefijo;

	@Override
	public char calcularLetra() {
		// como esta función devuelve un char, pues un char, letraDevuelta,
		char letraDevuelta = ' ';// 1ª línea, un objeto/variable del tipo devuelto
		int resto = 0;
		String nuevoNumero = null;// el número del DNI extranerjo preparado tras ver si traía X Y o Z

		// si tengo un prefijo x, y o z
		// si tengo x

		if (this.prefijo == 'Y') {
			nuevoNumero = "1" + this.numero;
		} else if (this.prefijo == 'Z') {
			nuevoNumero = "2" + this.numero;
		}

		if (this.prefijo == 'X') {
			System.out.println("Estoy en calcularLetra del DNI");
			resto = this.numero % Dni.SECUENCIA_LETRAS_DNI.length();
			letraDevuelta = Dni.SECUENCIA_LETRAS_DNI.charAt(resto);
		} else {
			int nuevoNumeroNie = Integer.parseInt(nuevoNumero);
			resto = nuevoNumeroNie % Dni.SECUENCIA_LETRAS_DNI.length();
			letraDevuelta = Dni.SECUENCIA_LETRAS_DNI.charAt(resto);
		}

		return letraDevuelta;// última línea, un return de la variable declarada en la línea 1
	}

	@Override
	public String toString() {
		return "Nie [prefijo=" + prefijo + ", numero=" + numero + ", letra=" + letra + "]";
	}



	
	/*
	public static void main(String[] args) {
		Nie nieOly = new Nie();
		nieOly.numero = 7564979;
		nieOly.prefijo = 'Y';
		
		System.out.println("LEtra OLy = " + nieOly.calcularLetra());
	}*/
}
