package basicosprofe;

import java.util.Objects;

public class Persona {
	
	String nombre;
	int edad;
	char sexo;
	
	
	@Override
	public String toString() {
		//return super.toString();
		return "Persona [nombre=" + this.nombre + ", edad=" + this.edad + ", sexo=" + this.sexo + "]";
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre) && sexo == other.sexo;
	}
	
	

}
