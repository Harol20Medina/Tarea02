package com.example.clase002.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase002.entity.Detalle;
import com.example.clase002.service.DetalleService;

@RestController

@RequestMapping("/api/detalle")
public class DetalleController {

	@Autowired
	private DetalleService detalleService;
	
	@GetMapping("/detalle")
	public List<Detalle> getList(){
		return detalleService.readAll();
	}
}

	
	