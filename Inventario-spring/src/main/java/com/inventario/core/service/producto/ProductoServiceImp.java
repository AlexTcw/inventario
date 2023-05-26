package com.inventario.core.service.producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	public List<String> getExistenciasByNombreAndColor(String nombreProd, String color){
		if (nombreProd != null && color != null) {
			return productoRepository.findByNombreProdAndColor(nombreProd,color);
		}else {
			return Collections.emptyList(); 
		}
	}
	

	@Override
	@PostConstruct
	@Transactional
	public void init() {
		ArrayList<String> colores = new ArrayList();
		colores.add("rojo");
		colores.add("Azul");
		
		ArrayList<String> tallas = new ArrayList<>();
		tallas.add("CH");
		tallas.add("GR");
		tallas.add("XL");
		tallas.add("XXL");

		Producto producto = new Producto();
		producto.setNombreProd("Pantalon");
		producto.setPrecio(280.0);
		producto.addTallaDisponible("CH");
		productoRepository.save(producto);


		Producto rev = new Producto();
		rev.setNombreProd("Sudadera");
		rev.setColor(colores);
		rev.setPrecio(350.0);
		rev.setTallasDisponibles(tallas);
		productoRepository.save(rev);
	}

}
