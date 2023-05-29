package com.inventario.core.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fechaVenta;
	private double totalVenta;

	@ManyToMany
	@JoinTable(name = "venta_producto", joinColumns = @JoinColumn(name = "venta_id"), inverseJoinColumns = @JoinColumn(name = "producto_id"))
	private List<Producto> productos;

	// Constructor, getters y setters
	public Venta() {
		super();
	}

	public Venta(Long id, LocalDate fechaVenta, double totalVenta, List<Producto> productos) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.totalVenta = totalVenta;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
