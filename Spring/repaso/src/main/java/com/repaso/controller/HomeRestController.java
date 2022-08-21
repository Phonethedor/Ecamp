package com.repaso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repaso.dto.Orden;
import com.repaso.service.OrdenServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class HomeRestController {
	
	@Autowired
	private OrdenServiceImpl ordenServiceImpl;
	
	@GetMapping("/ordenes")
	public List<Orden> home() {
		
		List<Orden> ordenes = ordenServiceImpl.listarOrdenes();
		return ordenes;
	}
	
	//http://localhost:8091/api/v1/ordenes/buscar?storeid=___&orderstatus=___
	@GetMapping("/ordenes/buscar")
	public List<Orden> filtrar(@RequestParam(value= "storeid", defaultValue= "0" ) Integer storeId, 
			@RequestParam(value= "orderstatus", defaultValue= "0") Integer orderStatus) {
		
		List<Orden> ordenes = ordenServiceImpl.listarOrdenesFiltroCompletado(storeId, orderStatus);
		
		return ordenes;
	}
}
