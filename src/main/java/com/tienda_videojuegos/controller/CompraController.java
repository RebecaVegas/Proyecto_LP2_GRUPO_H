package com.tienda_videojuegos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 

import com.tienda_videojuegos.model.Compra;
import com.tienda_videojuegos.service.CompraService;
import com.tienda_videojuegos.service.JuegoService;
import com.tienda_videojuegos.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("compra")
public class CompraController {

	private final CompraService compraService;
	private final JuegoService juegoService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstCompras", compraService.getAll());

		return "TiendaJuegos/CompraList";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("juegos", juegoService.getAll()); 
		model.addAttribute("compra", new Compra());
		return "TiendaJuegos/CompraNuevo";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute Compra compra, Model model, RedirectAttributes flash) {

		var response = compraService.create(compra);

		
		if (!response.success()) {
			model.addAttribute("juegos", juegoService.getAll()); 
			model.addAttribute("compra", compra);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			return "TiendaJuegos/CompraNuevo";
		}

		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/compra/listado";
	}

       @GetMapping("edicion/{id}")
       public String edicion(@PathVariable Integer id, Model model) {
	   model.addAttribute("juegos", juegoService.getAll()); 
	   model.addAttribute("compra", compraService.getOne(id));
	   return "TiendaJuegos/CompraEdicion";
    }

       @PostMapping("guardar")
    	public String guardar(@ModelAttribute Compra compra, Model model, RedirectAttributes flash) {

   		var response = compraService.update(compra);

   		if (!response.success()) {
   			model.addAttribute("juegos", juegoService.getAll()); 
   			model.addAttribute("compra", compra);
   			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
   			return "TiendaJuegos/CompraEdicion";
   		}

   		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
   		flash.addFlashAttribute("toast", toast);
   		return "redirect:/compra/listado";
   	}
	}