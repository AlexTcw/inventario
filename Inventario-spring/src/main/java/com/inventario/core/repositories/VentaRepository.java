package com.inventario.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.core.entities.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
