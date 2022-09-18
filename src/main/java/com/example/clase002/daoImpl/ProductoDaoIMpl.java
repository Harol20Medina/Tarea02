package com.example.clase002.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.clase002.dao.Todo;
import com.example.clase002.entity.Producto;
@Component

public class ProductoDaoIMpl implements Todo<Producto>{

	 @Autowired
	    private JdbcTemplate jdbcTemplate;
		@Override
		public int create(Producto t) {
			// TODO Auto-generated method stub
			
			int cantidadProducto = this.readAll().size();
			String query = "INSERT INTO producto(idproducto,nombre, precio, stock) values(?,?,?,?)";
			return jdbcTemplate.update(query, cantidadProducto+1, t.getNombre(), t.getPrecio(), t.getStock() );
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
			return jdbcTemplate.query("select *from producto", new BeanPropertyRowMapper<Producto>(Producto.class));
		}

		@Override
		public List<Map<String, Object>> readAll2() {
			// TODO Auto-generated method stub
			return null;
		}

	}


