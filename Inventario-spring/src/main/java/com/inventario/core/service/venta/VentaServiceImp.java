package com.inventario.core.service.venta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.core.entities.Producto;
import com.inventario.core.entities.Venta;
import com.inventario.core.repositories.VentaRepository;
import com.inventario.core.service.producto.ProductoService;

import jakarta.annotation.PostConstruct;

@Service
public class VentaServiceImp implements VentaService {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	VentaRepository ventaRepository;
	
	@Override
	public double totalVenta(List<Long> idsProductos) {
		double total = 0.0;

		for (Long idProducto : idsProductos) {
			Optional<Producto> productoOptional = productoService.findByIdProducto(idProducto);

			if (productoOptional.isPresent()) {
				Producto producto = productoOptional.get();
				total += producto.getPrecio();
			}
		}

		System.out.println("El total de la venta es: " + total);
		return total;
	}
	
	@Override
	public Optional<Venta> getVentaById(Long id){
		return ventaRepository.findById(id);
	}
	
	@Override
	public Venta crearVenta(Venta venta) {
		return ventaRepository.save(venta);
	}
	
	@Override
	public List<Venta> getVentas(){
		return ventaRepository.findAll();
	}
	
	@Override
	@PostConstruct
	@Transactional
	public void init() {
		Venta venta = new Venta();
		venta.setTotalVenta(350);
		ventaRepository.save(venta);
	}
}
