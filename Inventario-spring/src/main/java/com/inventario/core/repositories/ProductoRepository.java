package com.inventario.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.core.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
