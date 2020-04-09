package com.cenfotec.springbootexamen2.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCTO")
public class Producto {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "GRADO")
	private char grado;
	@Column(name = "CANTIDAD_TOTAL")
	private int cantidad_total;
	@Column(name = "CANTIDAD_CAJAS")
	private int cantidad_cajas;
	@Column(name = "INGRESO")
	private LocalDateTime ingreso;
	@Column(name = "ID_BODEGA")
	private Long idBodega;

	public Producto() {
		this.ingreso = LocalDateTime.now();
	}

	public Producto(String nombre, char grado, int cantidad_total, int cantidad_cajas, Long idBodega) {
		this.nombre = nombre;
		this.grado = grado;
		this.cantidad_total = cantidad_total;
		this.cantidad_cajas = cantidad_cajas;
		this.ingreso = LocalDateTime.now();
		this.idBodega = idBodega;
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

	public char getGrado() {
		return grado;
	}

	public void setGrado(char grado) {
		this.grado = grado;
	}

	public int getCantidad_total() {
		return cantidad_total;
	}

	public void setCantidad_total(int cantidad_total) {
		this.cantidad_total = cantidad_total;
	}

	public int getCantidad_cajas() {
		return cantidad_cajas;
	}

	public void setCantidad_cajas(int cantidad_cajas) {
		this.cantidad_cajas = cantidad_cajas;
	}

	public LocalDateTime getIngreso() {
		return ingreso;
	}

	public void setIngreso(LocalDateTime ingreso) {
		this.ingreso = ingreso;
	}

	public Long getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(Long idBodega) {
		this.idBodega = idBodega;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", grado=" + grado + ", cantidad_total=" + cantidad_total
				+ ", cantidad_cajas=" + cantidad_cajas + ", ingreso=" + ingreso + ", id_bodega=" + idBodega + "]";
	}

}
