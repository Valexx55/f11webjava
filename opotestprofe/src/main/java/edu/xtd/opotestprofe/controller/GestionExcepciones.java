package edu.xtd.opotestprofe.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//con esta anotación, le decimos a Spring, que derive las excepciones a esta clase
//es como un "escuchador" de excepciones, con un catch global
//con esta anotación, todos los fallos que ocurran en este paquete y todos
//los subpaquetes edu.xtd.opotestprofe, se derivan aquí
@RestControllerAdvice(basePackages = {"edu.xtd.opotestprofe"})
public class GestionExcepciones {
	
	//Las excepcepciones tipo NUll, se derivan a este método
	@ExceptionHandler(java.lang.NullPointerException.class)
	public String gestionErroNullPointer (NullPointerException npe)
	{
		return "FALLO TIPO NULL POINTER EXCEPTION";
	}
	
	@ExceptionHandler(java.lang.Throwable.class)
	public String gestionErroNullPointer (Throwable te)
	{
		return "FALLO TIPO Throwable EXCEPTION";
	}

}
