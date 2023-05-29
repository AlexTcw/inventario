package com.inventario.core.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.core.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

	Optional<Producto> findByNombreProd(String nombreProd);

	List<Producto> findByNombreProdAndColor(String nombreProd, String color);

	List<Producto> findByNombreProdAndMarca(String nombreProd, String marca);

	List<Producto> findByNombreProdAndMarcaAndColor(String nombreProd, String marca, String color);

}
