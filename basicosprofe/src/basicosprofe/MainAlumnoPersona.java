package basicosprofe;

import java.util.List;

public class MainAlumnoPersona {
	
	public static void main(String[] args) {
		
		Persona persona1 = new Persona();
		persona1.nombre = "Freddy";
		persona1.edad = 30;
		persona1.sexo = 'M';
		
		Persona persona2 = new Alumno();
		persona2.nombre = "Bonnie";
		persona2.edad = 25;
		persona2.sexo = 'M';
		
		if (persona2 instanceof Alumno)
		{
			System.out.println("Persona 1 sí es un ALumno");
			Alumno a = (Alumno)persona2;
			a.nota = 10;
		} else {
			System.out.println("Pesona 1 no es un alumno");
			
		}
		
		List<Persona> listaPersonas = List.of (persona1, persona2);
		int nalumnos = cuentaAlumnos(listaPersonas);
		System.out.println("Num alumnos = "+nalumnos);
	}
	
	
	private static int cuentaAlumnos (List<Persona> listaPersonas)
	{
		int numAlumnos = 0;
		
			for (Persona p: listaPersonas)
			{
				if (p instanceof Alumno)
				{
					numAlumnos++;
				}
			}
		
		return numAlumnos;
	}

}
