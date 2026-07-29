package edu.xtd.chiquitadasprofe;

import edu.xtd.chiquitadasprofe.controller.FrasesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChiquitadasprofeApplication {

	private final FrasesController frasesController;

	ChiquitadasprofeApplication(FrasesController frasesController) {
		this.frasesController = frasesController;
	}

	public static void main(String[] args) //String[] args
	{
		for (String argumento: args)
		{
			System.out.println(argumento);
		}
		SpringApplication.run(ChiquitadasprofeApplication.class, args);
	}

}
