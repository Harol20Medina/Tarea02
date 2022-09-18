package com.example.clase002.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.clase002.dao.Todo;
import com.example.clase002.entity.Detalle;

@Component
public class DetalleDaoIMpl implements Todo<Detalle>{

	 	@Autowired
	    private JdbcTemplate jdbcTemplate;
	 	
		@Override
		public int create(Detalle t) {
			// TODO Auto-generated method stub			
			String query = "INSERT INTO detalle(idventa, idproducto, precio, cantidad) values(?, ?, ?, ?)";
			return jdbcTemplate.update(query, t.getIdventas(), t.getIdproducto(), t.getPrecio(), t.getCantidad());
		}

		@Override
		public int update(Detalle t) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Detalle read(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Detalle> readAll() {
			// TODO Auto-generated method stub
			return jdbcTemplate.query("select *from invoices", new BeanPropertyRowMapper<Detalle>(Detalle.class));
		}

		@Override
		public List<Map<String, Object>> readAll2() {
			// TODO Auto-generated method stub
			return null;
		}

	}


