package com.CarFinancing.FinanciamentoCarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController 
@RequestMapping("/api")
public class FinanciamentoCarroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanciamentoCarroApplication.class, args);
	}
	
	@GetMapping("/message")
	public String message() {
		return "Olá do Spring boot!";
	}

}
