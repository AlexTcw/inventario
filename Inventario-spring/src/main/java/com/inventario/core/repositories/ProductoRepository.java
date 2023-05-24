package com.inventario.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.core.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

	Optional<Producto> findByNombreProd(String nombreProd);

}
