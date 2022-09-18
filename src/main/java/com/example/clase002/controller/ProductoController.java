package com.example.clase002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase002.entity.Producto;
import com.example.clase002.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/producto")
	public List<Producto> getList(){
		return productoService.readAll();
	}
	
	@PostMapping("/save")
	public int crearProducto(@RequestBody Producto producto) {
		return productoService.create(producto);
	}
}


