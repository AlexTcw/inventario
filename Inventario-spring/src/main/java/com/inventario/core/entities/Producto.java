package com.inventario.core.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreProd;
	private double precio;
	private String marca;
	private LocalDate fechaCreacion;
	private LocalDate fechaActualiz;
	@ElementCollection
	private List<String> tallasDisponibles;
	private String color;
	private byte[] imagen;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@OneToMany(mappedBy = "producto")
	private List<Venta> ventas;

	@PrePersist
	public void prePersist() {
		fechaCreacion = LocalDate.now();
		fechaActualiz = fechaCreacion;
	}

	@PreUpdate
	public void preUpdate() {
		fechaActualiz = LocalDate.now();
	}

	public Producto() {
		super();
	}

	public Producto(Long id, String nombreProd, double precio, String marca, LocalDate fechaCreacion,
			LocalDate fechaActualiz, List<String> tallasDisponibles, String color, byte[] imagen, Categoria categoria,
			List<Venta> ventas) {
		super();
		this.id = id;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.marca = marca;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualiz = fechaActualiz;
		this.tallasDisponibles = tallasDisponibles;
		this.color = color;
		this.imagen = imagen;
		this.categoria = categoria;
		this.ventas = ventas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaActualiz() {
		return fechaActualiz;
	}

	public void setFechaActualiz(LocalDate fechaActualiz) {
		this.fechaActualiz = fechaActualiz;
	}

	public List<String> getTallasDisponibles() {
		return tallasDisponibles;
	}

	public void setTallasDisponibles(List<String> tallasDisponibles) {
		this.tallasDisponibles = tallasDisponibles;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

}
