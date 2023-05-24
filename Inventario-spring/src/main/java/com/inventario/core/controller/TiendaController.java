package com.inventario.core.controller;

import java.util.List;

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
import com.inventario.core.service.producto.ProductoService;

@RestController
@Controller
@RequestMapping("/api")
public class TiendaController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/")
	public String home() {
		return "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
				+ "<title>Mi pagina</title>\n" + "<style>\n" + "    .center{\n" + "    display: flex;\n"
				+ "    justify-content: center;\n" + "    align-items: center;\n" + "    height: 100vh;\n"
				+ "    font-size: 24px;\n" + "    }\n" + "</style>\n" + "</head>\n" + "<body>\n"
				+ "    <div class=\"center\">\n" + "    Benvenido\n" + "    </div>\n" + "</body>\n" + "</html>";
	}

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

}
