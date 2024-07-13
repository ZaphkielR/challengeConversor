package com.challenge.ConversorDeMonedas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConversorDeMonedasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConversorDeMonedasApplication.class, args);
	}

	public void run(String... arg) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}

}
