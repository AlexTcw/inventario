package com.inventario.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.core.entities.Producto;
import com.inventario.core.service.producto.ProductoService;

@RestController
@Controller
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/viewProducts")
	public List<Producto> getProductos() {
		return productoService.findAllProductos();
	}

	@PostMapping("/saveProducts")
	public ResponseEntity<Producto> CreateProduct(@RequestBody Producto producto) {
		Producto saveProducto = productoService.saveOrProducto(producto);
		return ResponseEntity.ok(saveProducto);
	}

	@GetMapping("/getTallas")
	public ResponseEntity<List<String>> findTallas(@RequestParam("nombreProd") String nombreProd) {
		List<String> findTallasProducto = productoService.getTallasDisponiblesByName(nombreProd);
		return ResponseEntity.ok(findTallasProducto);
	}

	@PutMapping("/updateProductos")
	public ResponseEntity<Producto> UpdateProducto(@RequestBody Producto producto) {
		Producto updateProducto = productoService.saveOrProducto(producto);
		return ResponseEntity.ok(updateProducto);
	}
	

	@GetMapping("/existenciasByNombreAndColor")
	public ResponseEntity<List<String>>existenciasBynombreAndColor(@RequestParam("nombreProd") String nombreProd, @RequestParam("color") String color){
		List<String> findexistenciasBynombreAndColor = productoService.getExistenciasByNombreAndColor(nombreProd, color);
		return ResponseEntity.ok(findexistenciasBynombreAndColor);
	}

	@DeleteMapping("/deleteProducts")
	public void deleteProductosById(@RequestParam("id") Long id) {

		if (id != null) {
			productoService.deleteByIdProducto(id);
			List<Producto> findProductos = productoService.findAllProductos();
			ResponseEntity.ok(findProductos);
		} else {
			ResponseEntity.badRequest();
		}

	}

}
