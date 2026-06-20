package com.tienda_videojuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda_videojuegos.model.Usuario;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuarioAndClave(
            String usuario,
            String clave);
}