package basicosprofe.dni;

public class MainDni2 {
	
	public static void main(String[] args) {
		Dni dni = new Dni();
		dni.numero = 6202879;
		
		char letra1 = dni.calcularLetra();
		dni.letra = letra1;
		System.out.println("Dni 1 = " + dni.numero+"-"+dni.letra);
		
		Dni dni2 = new Dni();
		dni2.numero = 46789412;

		char letra2 = dni2.calcularLetra();
		
		dni2.letra = letra2;
		System.out.println("Dni 2 = " + dni2.numero+"-"+dni2.letra);
		
		
		Dni dni3 = new Dni();
		dni3.numero = 369857;
		
		char letra3 = dni3.calcularLetra();
		
		dni3.letra = letra3;
		System.out.println("Dni 3 = " + dni3.numero+"-"+dni3.letra);
		
		Dni dni4 = new Dni(6202879);
		System.out.println("Dni 4 = " + dni4.numero+"-"+dni4.letra);

	}

}
