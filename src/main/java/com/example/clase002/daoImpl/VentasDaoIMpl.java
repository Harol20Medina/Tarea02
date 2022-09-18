package com.example.clase002.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.example.clase002.dao.Todo;
import com.example.clase002.entity.Ventas;

@Component
public class VentasDaoIMpl implements Todo<Ventas>{

	 	@Autowired
	    private JdbcTemplate jdbcTemplate;
	 	
	 	@Autowired
	 	private DataSource dataSource;
	 	
	 	
	 	
		@Override
		public int create(Ventas t) {
			// TODO Auto-generated method stub
			String SQL = "INSERT INTO ventas(fecha) VALUES(:fechaEntrada)";
			
			NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
			
			GeneratedKeyHolder keyGenerada = new GeneratedKeyHolder();
			
			Map<String, Object> params = new HashMap<>();
			params.put("fechaEntrada", t.getFecha());
			
			jdbc.update(SQL, new MapSqlParameterSource(params), keyGenerada);
			
			int idRecuperado = keyGenerada.getKey().intValue();		
			
			return idRecuperado;
		}

		@Override
		public int update(Ventas t) {
			// TODO Auto-generated method stub
			String SQL = "UPDATE ventas SET fecha = ? WHERE idventas=?";
			return jdbcTemplate.update(SQL, t.getFecha(), t.getIdventas());
		}

		@Override
		public int delete(int id) {
			// TODO Auto-generated method stub
			String SQL = "DELETE FROM venta WHERE idventas=?";
			return jdbcTemplate.update(SQL, id);
		}

		@Override
		public Ventas read(int id) {
			// TODO Auto-generated method stub
			try {
				Ventas v = jdbcTemplate.queryForObject("SELECT * FROM ventas WHERE idventas=?",
						BeanPropertyRowMapper.newInstance(Ventas.class), id);
				return v;
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
			}}
		

		@Override
		public List<Ventas> readAll() {
			// TODO Auto-generated method stub
			return jdbcTemplate.query("SELECT * from ventas", BeanPropertyRowMapper.newInstance(Ventas.class));
		}


		@Override
		public List<Map<String, Object>> readAll2() {
			// TODO Auto-generated method stub
			return null;
		}

	}


