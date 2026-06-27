package com.tienda_videojuegos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tienda_videojuegos.model.Boleta;
import com.tienda_videojuegos.repository.BoletaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoletaService {

    private final BoletaRepository boletaRepository;

    public List<Boleta> getAll() {
        return boletaRepository.findAll();
    }

    public Boleta create(Boleta boleta) {
        return boletaRepository.save(boleta);
    }
}