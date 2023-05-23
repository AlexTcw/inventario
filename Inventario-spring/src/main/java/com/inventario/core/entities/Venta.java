package com.inventario.core.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fechaVenta;
	private double totalVenta;

	@OneToMany(mappedBy = "venta")
	private List<VentaDetalle> ventaDetalles;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	public Venta() {
		super();
	}

	public Venta(Long id, Date fechaVenta, double totalVenta, List<VentaDetalle> ventaDetalles, Producto producto) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.totalVenta = totalVenta;
		this.ventaDetalles = ventaDetalles;
		this.producto = producto;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<VentaDetalle> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}
}
