package edu.xtd.opotestprofe.service;

import org.springframework.stereotype.Service;

import edu.xtd.opotestprofe.modelo.EntradaImc;
import edu.xtd.opotestprofe.modelo.SalidaImc;

@Service
public class DemoService {
	
	public DemoService() {
		
		
		// TODO Auto-generated constructor stub
		System.out.println("En el constructor de demoservice ");
	}
	
	public SalidaImc caluclarIMC (EntradaImc entradaImc)
	{
		SalidaImc salidaImc = null;
		float imcnum = 0f;
		String imcNominal = "";
		
			imcnum = entradaImc.peso() / (entradaImc.altura()*entradaImc.altura());
			
			System.out.println("IMC RECIBIDO " + entradaImc);
			
			if (imcnum < 16) {
				imcNominal = "Desnutrido";
			} else if (imcnum >= 16 && imcnum <18) {
				imcNominal = "Delgado";
			} else if (imcnum >= 18 && imcnum <25) {
				imcNominal = "Ideal";
			} else if (imcnum >= 25 && imcnum <31) {
				imcNominal = "Sobrepeso";
			} else if (imcnum > 31) {
				imcNominal = "Obeso";
			}
			
			salidaImc = new SalidaImc(entradaImc.peso(), entradaImc.altura(), imcnum, imcNominal);
			
			System.out.println("IMC CALCULADO " + salidaImc);
		
		return salidaImc;
		
	
		
	}

}
