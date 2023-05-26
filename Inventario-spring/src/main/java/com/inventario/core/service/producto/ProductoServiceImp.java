package com.inventario.core.service.producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.core.entities.Producto;
import com.inventario.core.repositories.ProductoRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public Producto saveOrProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public boolean existProducto(Long id) {
		return productoRepository.existsById(id);
	}

	@Override
	public List<Producto> findAllProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findByIdProducto(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public void deleteByIdProducto(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public List<String> getTallasDisponiblesById(Long productId) {
		Optional<Producto> productoOptional = productoRepository.findById(productId);
		if (productoOptional.isPresent()) {
			Producto producto = productoOptional.get();
			return producto.getTallasDisponibles();
		}
		return Collections.emptyList(); // Si no se encuentra el producto, se devuelve una lista vacía
	}

	@Override
	public List<String> getTallasDisponiblesByName(String nombreProd) {
		Optional<Producto> productoOptional = productoRepository.findByNombreProd(nombreProd);
		if (productoOptional.isPresent()) {
			Producto producto = productoOptional.get();
			return producto.getTallasDisponibles();
		}
		return Collections.emptyList(); // Si no se encuentra el producto, se devuelve una lista vacía
	}

	@Override
	public Map<String, Object> getExistenciasByNombreAndColor(String nombreProd, String color) {
		List<Producto> productos = productoRepository.findByNombreProdAndColor(nombreProd, color);
		int numeroProd = productos.size();
		System.out.println("Total de productos: " + numeroProd);

		// Crear objeto que contiene los resultados y el número total de productos
		Map<String, Object> response = new HashMap<>();
		response.put("productos", productos);
		response.put("numeroTotalProductos", numeroProd);

		return response;
	}

	@Override
	public Map<String, Object> getExistenciasByNombreAndMarca(String nombreProd, String marca) {
		List<Producto> productos = productoRepository.findByNombreProdAndMarca(nombreProd, marca);
		int numeroProd = productos.size();
		System.out.println("Total de productos: " + numeroProd);

		// Crear objeto que contiene los resultados y el número total de productos
		Map<String, Object> response = new HashMap<>();
		response.put("productos", productos);
		response.put("numeroTotalProductos", numeroProd);

		return response;
	}

	@Override
	public Map<String, Object> getExistenciasByNombreAndMarcaAndColor(String nombreProd, String marca, String color) {
		List<Producto> productos = productoRepository.findByNombreProdAndMarcaAndColor(nombreProd, marca, color);
		int numeroProd = productos.size();
		System.out.println("Total de productos: " + numeroProd);

		// Crear objeto que contiene los resultados y el número total de productos
		Map<String, Object> response = new HashMap<>();
		response.put("productos", productos);
		response.put("numeroTotalProductos", numeroProd);

		return response;
	}

	@Override
	@PostConstruct
	@Transactional
	public void init() {

		ArrayList<String> tallas = new ArrayList<>();
		tallas.add("CH");
		tallas.add("GR");
		tallas.add("XL");
		tallas.add("XXL");

		Producto producto = new Producto();
		producto.setNombreProd("Pantalon");
		producto.setPrecio(280.0);
		producto.setTallasDisponibles(tallas);
		producto.setMarca("GAP");
		productoRepository.save(producto);

		Producto rev = new Producto();
		rev.setNombreProd("Sudadera");
		rev.setColor("azul");
		rev.setPrecio(350.0);
		rev.setMarca("nike");
		rev.setTallasDisponibles(tallas);
		productoRepository.save(rev);
	}

}
