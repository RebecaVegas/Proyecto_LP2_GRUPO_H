package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tienda_videojuegos.model.DetalleBoleta;
import com.tienda_videojuegos.repository.DetalleBoletaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleBoletaService {

    private final DetalleBoletaRepository detalleBoletaRepository;

    public List<DetalleBoleta> getAll() {
        return detalleBoletaRepository.findAll();
    }

    public DetalleBoleta create(DetalleBoleta detalle) {
        return detalleBoletaRepository.save(detalle);
    }
}