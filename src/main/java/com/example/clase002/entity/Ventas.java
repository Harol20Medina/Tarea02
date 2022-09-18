package com.example.clase002.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Ventas implements Serializable{

	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	private int idventas;
	private String fecha;
	private List<Detalle> detalles;
	
	public int getIdventas() {
		return idventas;
	}
	public void setIdventas(int idventas) {
		this.idventas = idventas;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public List<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	
}
