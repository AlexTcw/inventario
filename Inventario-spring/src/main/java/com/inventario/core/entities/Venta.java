package com.inventario.core.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Venta() {
		super();
	}

	public Venta(Long id, Date fechaVenta, double totalVenta, List<VentaDetalle> ventaDetalles) {
		super();
		this.id = id;
		this.fechaVenta = fechaVenta;
		this.totalVenta = totalVenta;
		this.ventaDetalles = ventaDetalles;
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
