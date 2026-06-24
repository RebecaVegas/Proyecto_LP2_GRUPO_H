package com.tienda_videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda_videojuegos.service.JuegoService;
import com.tienda_videojuegos.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("juego")
public class JuegoController {

	private final JuegoService juegoService;
	private final CategoriaService categoriaService;

	@GetMapping("listado")
	public String listado(@RequestParam(name = "idCategoria", required = false) Integer idCategoria, Model model) {
		
		if (idCategoria != null) {

		} else {
			model.addAttribute("lstJuegos", juegoService.getAll());
		}
		
		model.addAttribute("tiposCategoria", categoriaService.getAll());

		return "TiendaJuegos/JuegoList";
	}
	
}

