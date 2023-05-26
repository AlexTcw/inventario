package com.inventario.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/api")
public class TiendaController {

@GetMapping("/")
	public String home() {
		return "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
				+ "<title>Mi pagina</title>\n" + "<style>\n" + "    .center{\n" + "    display: flex;\n"
				+ "    justify-content: center;\n" + "    align-items: center;\n" + "    height: 100vh;\n"
				+ "    font-size: 24px;\n" + "    }\n" + "</style>\n" + "</head>\n" + "<body>\n"
				+ "    <div class=\"center\">\n" + "    Benvenido\n" + "    </div>\n" + "</body>\n" + "</html>";
	}

}
