package com.inventario.core.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.core.entities.Producto;
import com.inventario.core.repositories.ProductoRepository;
import com.inventario.core.service.producto.ProductoService;

@RestController
@Controller
public class TiendaController {
	
	private final Logger logger = LoggerFactory.getLogger(TiendaController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/shop")
	public String saludo() {
		return "Bienvenido";
	}
	
	@GetMapping("/")
	public String home() {
	    return "<!DOCTYPE html>\n" +
	           "<html>\n" +
	           "<head>\n" +
	           "<meta charset=\"UTF-8\">\n" +
	           "<title>Mi pagina</title>\n" +
	           "<style>\n" +
	           "    .center{\n" +
	           "    display: flex;\n" +
	           "    justify-content: center;\n" +
	           "    align-items: center;\n" +
	           "    height: 100vh;\n" +
	           "    font-size: 24px;\n" +
	           "    }\n" +
	           "</style>\n" +
	           "</head>\n" +
	           "<body>\n" +
	           "    <div class=\"center\">\n" +
	           "    Benvenido\n" +
	           "    </div>\n" +
	           "</body>\n" +
	           "</html>";
	}
	
	@GetMapping("/tienda")
	public List<Producto> inicioTienda() {
		System.out.println("Mostrando productos");		
		return productoService.viewAllProducts();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Producto>create(@RequestBody Producto producto, @RequestHeader HttpHeaders headers){
		System.out.println(headers.get("User-Agent"));
		if (producto.getId()!=null) {
			logger.warn("Triying to create a producto with id");
			return ResponseEntity.badRequest().build();
		}
		Producto result = productoService.saveProducto(producto);
		return ResponseEntity.ok(result);
	}
	
}
