package com.tienda_videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda_videojuegos.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstCategorias", categoriaService.getAll());
		
		return "TiendaJuegos/CategoriaList"; 
	}
}
