package com.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edutecno.model.Noticias;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticiasController {
	public static final Logger log = LoggerFactory.getLogger(NoticiasController.class);
	@GetMapping("/")
	//@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(Model model) {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("com/edutecno/model/beans.xml");
						
			Noticias n = appContext.getBean(Noticias.class);
			
			String [] noticias = n.getNoticias();
			
			String noticias1[] = noticias[0].split("@@");
			String noticias2[] = noticias[1].split("@@");
			String noticias3[] = noticias[2].split("@@");
			String noticias4[] = noticias[3].split("@@");
			String noticias5[] = noticias[4].split("@@");
			
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
