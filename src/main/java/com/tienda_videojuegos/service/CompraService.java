package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tienda_videojuegos.dto.ResultadoResponse;
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
	public Compra getOne(Integer idCompra) {
		return compraRepository.findById(idCompra).orElseThrow();
	}
	

	public ResultadoResponse create(Compra compra) {
		try {
			var registro = compraRepository.save(compra);
			var mensaje = String.format("Compra N° %s registrada con éxito", registro.getIdCompra());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error al registrar la compra");
		}
	}

	public ResultadoResponse update(Compra compra) {
		try {
			var registro = compraRepository.save(compra);
			var mensaje = String.format("Compra N° %s actualizada con éxito", registro.getIdCompra());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error al actualizar la compra");
		}
	}
}

