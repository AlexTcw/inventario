package com.inventario.core.entities;

import java.time.LocalDate;
import java.util.ArrayList;
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
	private LocalDate fechaCreacion;
	private LocalDate fechaActualiz;
	@ElementCollection
	private List<String> tallasDisponibles;
	private byte[] imagen;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@OneToMany(mappedBy = "producto")
	private List<Existencia> existencias;

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

	public Producto(Long id, String nombreProd, double precio, LocalDate fechaCreacion, LocalDate fechaActualiz,
			List<String> tallasDisponibles, byte[] imagen, Color color, Marca marca, Categoria categoria,
			List<Existencia> existencias, List<Venta> ventas) {
		super();
		this.id = id;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualiz = fechaActualiz;
		this.tallasDisponibles = tallasDisponibles;
		this.imagen = imagen;
		this.color = color;
		this.marca = marca;
		this.categoria = categoria;
		this.existencias = existencias;
		this.ventas = ventas;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Existencia> getExistencias() {
		return existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public void addTallaDisponible(String talla) {
		if (tallasDisponibles == null) {
			tallasDisponibles = new ArrayList<>();
		}
		tallasDisponibles.add(talla);
	}

}
