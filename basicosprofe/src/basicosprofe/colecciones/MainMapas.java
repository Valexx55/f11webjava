package basicosprofe.colecciones;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainMapas {
	
	public static void main(String[] args) {
		
		Tarea tarea = new Tarea(1, "Hacer la cama", true);
		Tarea tarea1 = new Tarea(2, "Hacer la comida", false);
		Tarea tarea2 = new Tarea(3, "Sacar al perro", false);
		Tarea tarea3 = new Tarea(4, "Estudiar Java", true);
		
		List<Tarea> listTareas = List.of(tarea, tarea1, tarea2);
		
		//System.out.println("Tareas record =" + listTareas);
		
		Map<Integer, Tarea> mapaTareas = new HashMap<>();
		mapaTareas.put(tarea.id(), tarea); //put insertar
		mapaTareas.put(tarea1.id(), tarea1);
		mapaTareas.put(tarea2.id(), tarea2);
		
		System.out.println("Mapa Tareas" + mapaTareas);
		Tarea tareaDos = mapaTareas.get(2); //get leer
		System.out.println("Tarea 2 = " + tareaDos);
		
		//extraemos las claves del mapa
		Set<Integer> claves = mapaTareas.keySet();
		System.out.println("Claves = "+ claves);
		
		//extraemos los valores del mapa
		Collection<Tarea> tareas = mapaTareas.values();
		System.out.println("Tareas = " + tareas);
		
		//extramoes los pares clave_valor
		Set<Entry<Integer, Tarea>> registros = mapaTareas.entrySet();
		System.out.println("Claves-Tareas = " + registros);
		
		//para comprobar si exsite un valor
		boolean existeTarea = mapaTareas.containsValue(tarea);
		System.out.println("Tarea existe " + existeTarea);
		boolean existeTarea3 = mapaTareas.containsValue(tarea3);
		System.out.println("Tarea existe " + existeTarea3);
		
		Tarea tarea5 = new Tarea(3, "Tirar la basura", false);
		mapaTareas.put(tarea5.id(), tarea5);
		
		System.out.println(mapaTareas);
		
//		ClaseTarea ctarea = new ClaseTarea(1, "Hacer la cama", true);
//		ClaseTarea ctarea1 = new ClaseTarea(2, "Hacer la comida", false);
//		ClaseTarea ctarea2 = new ClaseTarea(3, "Sacar al perro", false);
//		
//		List<ClaseTarea> listcTareas = List.of(ctarea, ctarea1, ctarea2);
//		
//		System.out.println("Tareas Clase =" + listcTareas);
		
		
	}

}
