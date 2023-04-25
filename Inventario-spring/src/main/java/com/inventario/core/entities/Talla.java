package com.inventario.core.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Talla {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreTalla;
	private String descripcion;

	public Talla() {
		super();
	}

	public Talla(Long id, String nombreTalla, String descripcion) {
		super();
		this.id = id;
		this.nombreTalla = nombreTalla;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTalla() {
		return nombreTalla;
	}

	public void setNombreTalla(String nombreTalla) {
		this.nombreTalla = nombreTalla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
