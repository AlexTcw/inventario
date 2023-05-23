package com.inventario.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.core.entities.Producto;
import com.inventario.core.repositories.ProductoRepository;

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
	public List<Producto> findAllProductos(){
		return productoRepository.findAll();
	}
	
	@Override
	public Optional<Producto> findByIdProducto(Long id){
		return productoRepository.findById(id);
	}
	
	@Override
	public void deleteByIdProducto(Long id) {
		productoRepository.deleteById(id);
	}

}
