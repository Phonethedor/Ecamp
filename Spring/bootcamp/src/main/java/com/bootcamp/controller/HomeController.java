package com.bootcamp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.dto.Curso;
import com.bootcamp.dto.Estudiante;
import com.bootcamp.dto.Region;
import com.bootcamp.service.CursoServiceImpl;
import com.bootcamp.service.EstudianteServiceImpl;
import com.bootcamp.service.RegionServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private CursoServiceImpl cursoServiceImpl;
	
	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;
	
	@Autowired
	private RegionServiceImpl regionServiceImpl;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Curso> cursos =cursoServiceImpl.listarCursos();
		List<Estudiante> estudiantes = estudianteServiceImpl.listarEstudiantes();
		List<Region> regiones = regionServiceImpl.listarRegiones();
		
		model.addAttribute("regiones", regiones);
		model.addAttribute("cursos", cursos);
		model.addAttribute("estudiantes", estudiantes);
		return "index";
	}
	
	@PostMapping("/buscar")
	public String filtrar(@RequestParam(value="codigo_curso") String curso, @RequestParam(value="codigo_region") Integer region, Model model) {
		List<Curso> cursos =cursoServiceImpl.listarCursos();
		List<Region> regiones = regionServiceImpl.listarRegiones();
		List<Estudiante> estudiantes = estudianteServiceImpl.filtradoCompleto(curso, region);
		
		model.addAttribute("regiones", regiones);
		model.addAttribute("cursos", cursos);
		model.addAttribute("estudiantes", estudiantes);
		return "index";
	}
}
