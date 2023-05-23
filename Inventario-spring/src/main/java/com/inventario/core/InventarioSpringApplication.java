package com.inventario.core;

import org.springframework.context.ApplicationContext;

import com.inventario.core.entities.Producto;
import com.inventario.core.repositories.ProductoRepository;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventarioSpringApplication{

	public static void main(String[] args) {
		
		ApplicationContext context = (ApplicationContext) SpringApplication.run(InventarioSpringApplication.class,	args);
		ProductoRepository productoRepository = context.getBean(ProductoRepository.class);
		
		Producto producto = new Producto(null, "Sudadera", 350.0, new Date(54,4,22), new Date(062,4,23), null, null, null, null, null, null, null);
		productoRepository.save(producto);
	}

}
