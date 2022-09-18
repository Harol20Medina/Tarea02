package com.example.clase002.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pruebita")
public class PruebaController {
	
	@GetMapping("/hola")
	public String saludar() {
		return "hola";
	}

}
