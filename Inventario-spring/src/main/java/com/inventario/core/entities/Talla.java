package com.inventario.core.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Talla {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreTalla;
	private String descripcion;

	@OneToMany(mappedBy = "talla")
	private List<Producto> productos;

	public Talla(Long id, String nombreTalla, String descripcion, List<Producto> productos) {
		super();
		this.id = id;
		this.nombreTalla = nombreTalla;
		this.descripcion = descripcion;
		this.productos = productos;
	}
	
	

	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public Talla() {
		super();
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
