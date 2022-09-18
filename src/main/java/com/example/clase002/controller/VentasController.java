package com.example.clase002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase002.entity.Ventas;
import com.example.clase002.service.VentasService;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

	@Autowired
	private VentasService service;
	
	@GetMapping("/all")
	public List<Ventas> readAll(){		
		return service.readAll();
	}
	@GetMapping("/{id}")
	public Ventas read(@PathVariable int id){		
		return service.read(id);
	}
	
	@PostMapping("/guardar-ventita")
	public int save(@RequestBody Ventas ventas){		
		return service.create(ventas);
	}
	
	@PutMapping("/update")
	public int update(@PathVariable int id, @RequestBody Ventas ventas){	
		Ventas v = service.read(id);
		v.setFecha("2022-09-15");
		return service.update(v);
	}
	
	@DeleteMapping("/del/{id}")
	public int save(@PathVariable int id){		
		return service.delete(id);
	}
}
