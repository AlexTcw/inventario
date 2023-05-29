package com.inventario.core.service.venta;

import java.util.List;
import java.util.Optional;

import com.inventario.core.entities.Venta;

public interface VentaService {

	double totalVenta(List<Long> idsProductos);

	Venta crearVenta(Venta venta);

	void init();

	List<Venta> getVentas();

	Optional<Venta> getVentaById(Long id);


}
