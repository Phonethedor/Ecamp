package com.edutecno.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticiasController {
	public static final Logger log = LoggerFactory.getLogger(NoticiasController.class);
	@GetMapping("/")
	//@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Model model) {
		String ruta = "src/main/resources/static/noticias.txt"; //Ruta archivo a leer
		File archivo = new File(ruta);
		ArrayList<String> datos = new ArrayList<String>();
		try {
			FileReader filer = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(filer);
			
			String linea = buffer.readLine();
			while(linea != null) {
				datos.add(linea);
				log.info("Se ha leido una linea del archivo");
				linea = buffer.readLine();
			}
			buffer.close();
			filer.close();
			
			String noticias1[] = datos.get(0).split("@@");
			String noticias2[] = datos.get(1).split("@@");
			String noticias3[] = datos.get(2).split("@@");
			String noticias4[] = datos.get(3).split("@@");
			String noticias5[] = datos.get(4).split("@@");
			
			model.addAttribute("noticia1", noticias1);
			model.addAttribute("noticia2", noticias2);
			model.addAttribute("noticia3", noticias3);
			model.addAttribute("noticia4", noticias4);
			model.addAttribute("noticia5", noticias5);			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error: NoticiasController home()");
		}
		return "index"; //Ruta a la que se despacha la información
	}	
	/*
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("index");
		//model.setViewName("index");
		//model.addObject(AttributeName,Object);
		return model; 
	}*/
	
}
