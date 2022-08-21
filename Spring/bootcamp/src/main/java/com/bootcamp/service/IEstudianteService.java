package com.bootcamp.service;

import java.util.List;
import com.bootcamp.dto.Estudiante;

public interface IEstudianteService {
	
	public List<Estudiante> listarEstudiantes();
	public List<Estudiante> filtrarEstudiantesPorCurso(String codigo_curso);
	public List<Estudiante> filtrarEstudiantesPorRegion(Integer codigo_region);
	public List<Estudiante> filtrarEstudiantesPorCursoYRegion(String codigo_curso, Integer codigo_region);
	public List<Estudiante> filtradoCompleto(String codigo_curso, Integer codigo_region);

}
