package com.cenfotec.examen.entities;

public class EspecieInput {

	private String nombre;
	private String nombre_descubierto;
	private String fecha;
	private String tipo;
	
	public EspecieInput() {
		// TODO Auto-generated constructor stub
	}

	public EspecieInput(String nombre, String nombre_descubierto, String fecha, String tipo) {
		super();
		this.nombre = nombre;
		this.nombre_descubierto = nombre_descubierto;
		this.fecha = fecha;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_descubierto() {
		return nombre_descubierto;
	}

	public void setNombre_descubierto(String nombre_descubierto) {
		this.nombre_descubierto = nombre_descubierto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "EspecieInput [nombre=" + nombre + ", nombre_descubierto=" + nombre_descubierto + ", fecha=" + fecha
				+ ", tipo=" + tipo + "]";
	}

	
	
}
