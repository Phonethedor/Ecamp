package com.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.dto.Estudiante;
import com.bootcamp.service.EstudianteServiceImpl;

@RestController
@RequestMapping("api/v1")
public class HomeRestController {
	
	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;
	
	@GetMapping("/")
	public List<Estudiante> home (){
		
		List<Estudiante> estudiantes = estudianteServiceImpl.listarEstudiantes();
		
		return estudiantes;
	}
	
	@GetMapping("/buscar")
	public List<Estudiante> filtrar(@RequestParam(value="codigo_curso", defaultValue="0") String curso, @RequestParam(value="codigo_region", defaultValue="0") Integer region){
		
		List<Estudiante> estudiantes = estudianteServiceImpl.filtradoCompleto(curso, region);
		
		return estudiantes;
	}
}
