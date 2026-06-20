package com.tienda_videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda_videojuegos.service.CompraService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("compra")
public class CompraController {

	private final CompraService compraService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstCompras", compraService.getAll());

		return "TiendaJuegos/CompraList";
	}
}