package com.jvega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

	@GetMapping("/client")
	public ModelAndView home() {
		return new ModelAndView("client/client"); //carpeta cliente, vista client.html
	}
	
	
}
