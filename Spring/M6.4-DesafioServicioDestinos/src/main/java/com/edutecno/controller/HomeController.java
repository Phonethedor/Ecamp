package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edutecno.service.DestinoService;

@Controller
public class HomeController {
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping("/") // Ruta principal o root
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("destinos");// Asignacion de la vista
		model.addObject("destinos",destinoService.findAll());
		return model;
	}
}
