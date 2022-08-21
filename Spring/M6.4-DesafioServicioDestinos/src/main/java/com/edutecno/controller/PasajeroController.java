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

import com.edutecno.model.Pasajero;
import com.edutecno.service.DestinoService;
import com.edutecno.service.PasajeroService;

@Controller
@RequestMapping("/pasajeros")
public class PasajeroController {
	@Autowired
	private PasajeroService pasajeroService;
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping
	public ModelAndView pasajeros() {
		ModelAndView model = new ModelAndView("pasajeros");
		model.addObject("pasajeros", pasajeroService.findAll());
		return model;
	}
	
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView model = new ModelAndView("crear-pasajero");
		model.addObject("pasajero", new Pasajero());
		model.addObject("destinos", destinoService.findAll());
		return model;
	}
	
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Pasajero pasajero) {
		pasajeroService.save(pasajero);
		return new RedirectView("/pasajeros");
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id) {
		ModelAndView model = new ModelAndView("seleccionar-pasajero");
		model.addObject("pasajero", new Pasajero());
		model.addObject("pasajeroVO", pasajeroService.findById(id).get());
		model.addObject("destinos", destinoService.findAll());
		return model;
	}
	
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute Pasajero pasajero) {
		pasajeroService.update(pasajero);
		return new RedirectView("/pasajeros");
	}
	
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Long id) {
		if(pasajeroService.findById(id).isPresent()) {
			pasajeroService.delete(pasajeroService.findById(id).get());
		}
		return new RedirectView("/pasajeros");
	}
	
}
