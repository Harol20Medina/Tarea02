package com.example.clase002.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clase002.dao.Todo;
import com.example.clase002.daoImpl.ProductoDaoIMpl;
import com.example.clase002.entity.Producto;
@Service

public class ProductoService implements Todo<Producto>{

	@Autowired
	private ProductoDaoIMpl daoIMpl;
	
	@Override
	public int create(Producto t) {
		// TODO Auto-generated method stub
		return daoIMpl.create(t);
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return daoIMpl.readAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}


