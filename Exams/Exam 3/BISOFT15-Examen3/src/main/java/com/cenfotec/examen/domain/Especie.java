package com.cenfotec.examen.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ESPECIE")
public class Especie {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "NOMBRE_DESCUBIERTO")
	private String nombre_descubierto;
	@Column(name = "FECHA")
	private LocalDateTime fecha;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "GUID", updatable = false)
	private String guid;

	public Especie() {
		this.fecha = LocalDateTime.now();
	}

	public Especie(String nombre, String nombre_descubierto, String tipo) {
		super();
		this.nombre = nombre;
		this.nombre_descubierto = nombre_descubierto;
		this.fecha = LocalDateTime.now();
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "Especie [id=" + id + ", nombre=" + nombre + ", nombre_descubierto=" + nombre_descubierto + ", fecha="
				+ fecha + ", tipo=" + tipo + ", guid=" + guid + "]";
	}

}
