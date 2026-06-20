package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tienda_videojuegos.model.Compra;
import com.tienda_videojuegos.repository.CompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraService {

	private final CompraRepository compraRepository;

	public List<Compra> getAll() {
		return compraRepository.findAll();
	}
}
