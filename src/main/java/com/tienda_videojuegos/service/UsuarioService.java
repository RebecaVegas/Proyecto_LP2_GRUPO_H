package com.tienda_videojuegos.service;

import org.springframework.stereotype.Service;

import com.tienda_videojuegos.model.Usuario;
import com.tienda_videojuegos.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(
            UsuarioRepository repository) {

        this.repository = repository;
    }

    public Usuario login(
            String usuario,
            String clave) {

        return repository.findByUsuarioAndClave(
                usuario,
                clave);
    }
}