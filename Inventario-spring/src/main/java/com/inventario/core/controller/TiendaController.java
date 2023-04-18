package com.inventario.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class TiendaController {
	
	@GetMapping("/shop")
	public String saludo() {
		return "Bienvenido";
	}

}
