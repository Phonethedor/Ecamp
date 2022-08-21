package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.model.Destino;
import com.edutecno.service.DestinoService;
import com.edutecno.service.PasajeroService;

@Controller
@RequestMapping("destinos")
public class DestinoController {
	@Autowired
	private DestinoService destinoService;
	@Autowired
	private PasajeroService pasajeroService;
	
	@GetMapping
	public ModelAndView destinos() {
		ModelAndView model = new ModelAndView("destinos");// Asignacion de la vista
		model.addObject("destinos",destinoService.findAll());
		return model;
	}
	
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView model = new ModelAndView("crear-destino");
		model.addObject("destino", new Destino());
		model.addObject("pasajeros", pasajeroService.findAll());
		return model;
	}
	
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Destino destino) {
		destinoService.save(destino);
		return new RedirectView("/destinos");
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("seleccionar-destino");
		model.addObject("destino", new Destino());
		model.addObject("destinoVO", destinoService.findById(id).get());
		model.addObject("pasajeros", pasajeroService.findAll());
		return model;
	}
	
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute Destino destino) {
		destinoService.update(destino);
		return new RedirectView("/destinos");
	}
	
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Long id) {
		if(destinoService.findById(id).isPresent()) {
			destinoService.delete(destinoService.findById(id).get());
		}
		return new RedirectView("destinos");
	}
}
