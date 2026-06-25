package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tienda_videojuegos.dto.ResultadoResponse;
import com.tienda_videojuegos.model.Compra;
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

	public List<Juego> buscarPorIdCategoria(Integer idCategoria) {
		// TODO Auto-generated method stub
		return juegoRepository.findByCategoriaIdCategoria(idCategoria);
	}
	
	public ResultadoResponse create(Juego juego) {
		try {
			var registro = juegoRepository.save(juego);
			var mensaje = String.format("Producto con Id %s registrado", registro.getIdJuego());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
	
	public ResultadoResponse update(Juego juego) {
		try {
			var registro = juegoRepository.save(juego);
			var mensaje = String.format("Juego N° %s actualizada con éxito", registro.getIdJuego());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error al actualizar el Juego");
		}
	}
	
}