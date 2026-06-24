package com.tienda_videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tienda_videojuegos.model.Usuario;
import com.tienda_videojuegos.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(
            UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @GetMapping({"/", "/login"})
    public String login() {
        return "TiendaJuegos/login";
    }

    @PostMapping("/validar")
    public String validar(
            String usuario,
            String clave,
            HttpSession session) {

        Usuario user =
                usuarioService.login(
                        usuario,
                        clave);

        if(user != null) {

            session.setAttribute(
                    "usuario",
                    user);

            return "redirect:/home";
        }

        return "redirect:/";
    }

    @GetMapping("/inicio")
    public String inicio() {

        return "inicio";
    }
}