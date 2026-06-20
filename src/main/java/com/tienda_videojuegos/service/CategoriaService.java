package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tienda_videojuegos.model.Categoria;
import com.tienda_videojuegos.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;

	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}
}
