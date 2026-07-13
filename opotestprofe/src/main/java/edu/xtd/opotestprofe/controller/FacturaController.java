package edu.xtd.opotestprofe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.xtd.opotestprofe.service.EnvioFacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController {
	
	@Autowired
	EnvioFacturaService envioFacturaService;
	
	//http://localhost:8081/factura/enviar-factura/2
	@PostMapping("/enviar-factura/{id}")
	public String enviar(@PathVariable int id) {
		
			this.envioFacturaService.enviarFactura(id);
		
		return "ENVIADO";
	}

}
