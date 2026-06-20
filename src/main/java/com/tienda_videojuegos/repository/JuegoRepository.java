package com.tienda_videojuegos.repository;

import com.tienda_videojuegos.model.Juego;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer> {
	List<Juego> findByCategoriaIdCategoria(Integer idCategoria);
}
