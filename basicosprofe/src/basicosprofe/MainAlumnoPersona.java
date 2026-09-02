package basicosprofe;

import java.util.List;

public class MainAlumnoPersona {
	
	public static void main(String[] args) {
		
		Persona persona1 = new Persona();
		persona1.nombre = "Freddy";
		persona1.edad = 30;
		persona1.sexo = 'M';
		
		Persona persona3 = new Persona();
		persona3.nombre = "Freddy";
		persona3.edad = 30;
		persona3.sexo = 'M';
		
		//if (persona1==persona3)
		if (persona1.equals(persona3))
		{
			System.out.println("Persona 1 es IGUAL a Persona 3");
		} else {
			System.out.println("Persona 1 es DISTINTA a Persona 3");
		}
		
		
		
		
		
		
		
		
		
		
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
		
		
		String stringPersona1 = persona1.toString();
		String stringPersona2 = persona2.toString();
		System.out.println("String persona 1 = " + stringPersona1);
		System.out.println("String persona 2 = " + stringPersona2);
		System.out.println("String persona 2 2 = " + persona2);
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
