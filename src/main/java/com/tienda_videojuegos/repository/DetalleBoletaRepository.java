package com.tienda_videojuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tienda_videojuegos.model.DetalleBoleta;

@Repository
public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, Integer> {
}