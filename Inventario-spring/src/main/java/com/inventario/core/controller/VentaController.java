package com.inventario.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.core.entities.Producto;
import com.inventario.core.entities.Venta;
import com.inventario.core.service.producto.ProductoService;
import com.inventario.core.service.venta.VentaService;

@RestController
@Controller
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaService ventaService;

	@Autowired
	ProductoService productoService;

	@GetMapping("/ventaCalc")
	public Double findTallas(@RequestParam("idsProductos") List<Long> idsProductos) {
		System.out.println(idsProductos.toString());
		return ventaService.totalVenta(idsProductos);
	}

	@GetMapping("/getVentas")
	public List<Venta> getVentas() {
		return ventaService.getVentas();
	}

	@PostMapping("/createVenta")
	public ResponseEntity<Venta> createVenta(@RequestBody Venta venta,
			@RequestParam("idsProductos") List<Long> idsProductos) {
		Venta saveVenta = ventaService.crearVenta(venta);
		double totalVenta = ventaService.totalVenta(idsProductos); // Calcular el total de la venta
		saveVenta.setTotalVenta(totalVenta); // Establecer el total de la venta en la entidad Venta
		ventaService.crearVenta(saveVenta);
		return ResponseEntity.ok(saveVenta);
	}

	@PostMapping("/createVentaAndGetNames")
	public ResponseEntity<Venta> createVentaAndGetNames(@RequestBody Venta venta,
			@RequestParam("idsProductos") List<Long> idsProductos) {
		Venta saveVenta = ventaService.crearVenta(venta);

		List<Producto> productos = new ArrayList<>();
		for (Long idProducto : idsProductos) {
			Optional<Producto> productoOptional = productoService.findByIdProducto(idProducto);
			productoOptional.ifPresent(productos::add);
		}
		saveVenta.setProductos(productos); // Establecer la lista de productos en la entidad Venta

		double totalVenta = ventaService.totalVenta(idsProductos); // Calcular el total de la venta
		saveVenta.setTotalVenta(totalVenta); // Establecer el total de la venta en la entidad Venta

		ventaService.crearVenta(saveVenta);

		return ResponseEntity.ok(saveVenta);
	}

}
