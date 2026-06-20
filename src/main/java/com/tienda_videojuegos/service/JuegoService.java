package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tienda_videojuegos.dto.ResultadoResponse;
import com.tienda_videojuegos.model.Juego;
import com.tienda_videojuegos.repository.JuegoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JuegoService {

	private final JuegoRepository juegoRepository;

	public List<Juego> getAll() {
		return juegoRepository.findAll();
	}

	public Juego getOne(Integer idJuego) {
		return juegoRepository.findById(idJuego).orElseThrow();
	}
	
}