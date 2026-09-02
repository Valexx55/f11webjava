package edu.xtd.opotestprofe.service;

import org.springframework.stereotype.Service;

@Service
public class EnvioPorYahoo implements EnvioFacturaService{

	@Override
	public void enviarFactura(int idFactura) {
		System.out.println("Enviando por Yahoo ...");
		
	}

}
