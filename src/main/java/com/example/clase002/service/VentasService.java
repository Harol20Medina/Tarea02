package com.example.clase002.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clase002.dao.Todo;
import com.example.clase002.daoImpl.DetalleDaoIMpl;
import com.example.clase002.daoImpl.VentasDaoIMpl;
import com.example.clase002.entity.Ventas;

@Service
public class VentasService implements Todo<Ventas>{

	@Autowired
	private VentasDaoIMpl daoIMpl;
	
	@Autowired
	private DetalleDaoIMpl detalleDao;
	
	
	@Override
	@Transactional
	public int create(Ventas t) {
		// TODO Auto-generated method stub
		
		// TODO crear venta
		int idGenerado = daoIMpl.create(t);
		
		
		// TODO crear detalles
		
		t.getDetalles().forEach( detalle -> {
			detalle.setIdventas(idGenerado);
			detalleDao.create(detalle);
		});
		
		return idGenerado;
	}

	@Override
	public int update(Ventas t) {
		// TODO Auto-generated method stub
		return daoIMpl.update(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return daoIMpl.delete(id);
	}

	@Override
	public Ventas read(int id) {
		// TODO Auto-generated method stub
		return daoIMpl.read(id);
	}

	@Override
	public List<Ventas> readAll() {
		// TODO Auto-generated method stub
		return daoIMpl.readAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}


