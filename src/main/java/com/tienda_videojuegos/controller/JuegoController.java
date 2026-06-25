package com.tienda_videojuegos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda_videojuegos.service.JuegoService;
import com.tienda_videojuegos.util.Alert;
import com.tienda_videojuegos.model.Compra;
import com.tienda_videojuegos.model.Juego;
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
	    
	    List<Juego> listaJuegos;
	    
	    if (idCategoria != null) {
	        listaJuegos = juegoService.buscarPorIdCategoria(idCategoria); 
	    } else {
	        listaJuegos = juegoService.getAll();
	    }
	    
	    model.addAttribute("lstJuegos", listaJuegos);
	    model.addAttribute("idCategoriaSeleccionada", idCategoria);
	    model.addAttribute("tiposCategoria", categoriaService.getAll());

	    return "TiendaJuegos/JuegoList";
	}
	
	@GetMapping("/nuevoJuego")
    public String nuevo(Model model) {
        model.addAttribute("categorias", categoriaService.getAll());
        model.addAttribute("juego", new Juego());
        model.addAttribute("alert", null);
        
        return "TiendaJuegos/nuevoJuego"; 
    }

    @PostMapping("registrar")
    public String registrar(@ModelAttribute Juego juego, Model model, RedirectAttributes flash) {
    	
        var response = juegoService.create(juego);
        if (!response.success()) {
            model.addAttribute("categorias", categoriaService.getAll());
           
            model.addAttribute("juego", juego);
            model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
            
            return "TiendaJuegos/nuevo";
        }

        var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
        flash.addFlashAttribute("toast", toast);
        
        return "redirect:/juego/listado";
    }
    
    
    @GetMapping("edicion/{id}")
    public String edicion(@PathVariable Integer id, Model model) {
    	model.addAttribute("juego", juegoService.getOne(id));
	   return "TiendaJuegos/JuegoEdicion";
 }

    @PostMapping("guardarPrecio")
 	public String guardar(@ModelAttribute @RequestParam("idJuego") Integer id, @RequestParam("precio") Double nuevoPrecio, Model model, RedirectAttributes flash) {

    	var juegoOriginal = juegoService.getOne(id);
    	juegoOriginal.setPrecio(nuevoPrecio);
    	var response = juegoService.update(juegoOriginal);

		if (!response.success()) {
			model.addAttribute("juegos", juegoService.getAll()); 
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			return "TiendaJuegos/JuegoEdicion";
		}

		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/juego/listado";
	}
    
    
    
    
    
}

