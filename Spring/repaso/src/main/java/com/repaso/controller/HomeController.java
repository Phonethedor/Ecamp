package com.repaso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.repaso.dto.Orden;
import com.repaso.dto.Tienda;
import com.repaso.service.OrdenServiceImpl;
import com.repaso.service.TiendaServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private TiendaServiceImpl tiendaServiceImpl;
	
	@Autowired
	private OrdenServiceImpl ordenServiceImpl;
	
	@GetMapping("/") //
	public String home(Model model) {
		
		List<Orden> ordenes = ordenServiceImpl.listarOrdenes();
		List<Tienda> tiendas = tiendaServiceImpl.listarTiendas();
		String resultado = "Ordenes " + ordenes.size();
		
		model.addAttribute("ordenes", ordenes);
		model.addAttribute("tiendas", tiendas);
		model.addAttribute("resultado", resultado);
		
		return "index";
	}
	
	@PostMapping("/buscar")
	public String filtrar(@RequestParam(value= "storeId" ) Integer storeId, 
			@RequestParam(value= "orderStatus") Integer orderStatus, 
			Model model) {
		
		List<Orden> ordenes = ordenServiceImpl.listarOrdenesFiltroCompletado(storeId, orderStatus);
		List<Tienda> tiendas = tiendaServiceImpl.listarTiendas();
		String resultado = "Ordenes" + ordenes.size();
		model.addAttribute("ordenes", ordenes);
		model.addAttribute("tiendas", tiendas);
		model.addAttribute("resultado", resultado);
		
		return "index";
	}
}
