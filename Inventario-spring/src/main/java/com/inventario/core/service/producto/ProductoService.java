package com.inventario.core.service.producto;

import java.util.List;
import java.util.Optional;

import com.inventario.core.entities.Producto;

public interface ProductoService {

	Producto saveOrProducto(Producto producto);

	boolean existProducto(Long id);

	List<Producto> findAllProductos();

	Optional<Producto> findByIdProducto(Long id);

	void deleteByIdProducto(Long id);

	void init();

	List<String> getTallasDisponiblesById(Long productId);

	List<String> getTallasDisponiblesByName(String nombreProd);

}
