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
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreProd;
	private double precio;
	private Date fechaCreacion;
	private Date fechaActualiz;
	private byte[] imagen;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "talla_id")
	private Talla talla;

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

	public Producto(Long id, String nombreProd, double precio, Date fechaCreacion, Date fechaActualiz, byte[] imagen,
			Color color, Talla talla, Marca marca, Categoria categoria, List<Existencia> existencias,
			List<Venta> ventas) {
		super();
		this.id = id;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualiz = fechaActualiz;
		this.imagen = imagen;
		this.color = color;
		this.talla = talla;
		this.marca = marca;
		this.categoria = categoria;
		this.existencias = existencias;
		this.ventas = ventas;
	}

	public Producto() {
		super();
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualiz() {
		return fechaActualiz;
	}

	public void setFechaActualiz(Date fechaActualiz) {
		this.fechaActualiz = fechaActualiz;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
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

}
