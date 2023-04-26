package com.inventario.core;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.inventario.core.entities.Producto;
import com.inventario.core.repositories.ProductoRepository;

@SpringBootApplication
public class InventarioSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(InventarioSpringApplication.class,args);
		LocalDate localDate = LocalDate.now();
		
		ProductoRepository repository = context.getBean(ProductoRepository.class);
		Producto sudadera = new Producto(null, "Sudadera", 350, new Date(26/04/2023), new Date(0), null, null, null, null);
		
		repository.save(sudadera);
		System.out.println("El numero de productos en la base de datos es: "+repository.count());
		System.out.println(repository.findAll());
	}

}
