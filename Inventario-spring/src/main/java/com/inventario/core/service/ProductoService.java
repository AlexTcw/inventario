package com.inventario.core.service;

import java.util.List;
import java.util.Optional;

import com.inventario.core.entities.Producto;

public interface ProductoService {

	Producto saveOrProducto(Producto producto);

	boolean existProducto(Long id);

	List<Producto> findAllProductos();

	Optional<Producto> findByIdProducto(Long id);

	void deleteByIdProducto(Long id);

}
