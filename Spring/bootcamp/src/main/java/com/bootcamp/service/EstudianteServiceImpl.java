package com.bootcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.dao.EstudianteRepository;
import com.bootcamp.dto.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> listarEstudiantes() {
		return estudianteRepository.listarEstudiantes();
	}

	@Override
	public List<Estudiante> filtrarEstudiantesPorCurso(String codigo_curso) {
		return estudianteRepository.filtrarEstudiantes(codigo_curso);
	}

	@Override
	public List<Estudiante> filtrarEstudiantesPorRegion(Integer codigo_region) {
		return estudianteRepository.filtrarEstudiantesPorRegion(codigo_region);
	}

	@Override
	public List<Estudiante> filtrarEstudiantesPorCursoYRegion(String codigo_curso, Integer codigo_region) {
		return estudianteRepository.filtrarEstudiantesPorCursoYRegion(codigo_curso, codigo_region);
	}
	
	public List<Estudiante> filtradoCompleto(String codigo_curso, Integer codigo_region){
		if(Integer.parseInt(codigo_curso) != 0 && codigo_region == 0) {
			return estudianteRepository.filtrarEstudiantes(codigo_curso);
		}else if(Integer.parseInt(codigo_curso) == 0 && codigo_region != 0) {
			return estudianteRepository.filtrarEstudiantesPorRegion(codigo_region);
		}else if (Integer.parseInt(codigo_curso) != 0 && codigo_region != 0) {
			return estudianteRepository.filtrarEstudiantesPorCursoYRegion(codigo_curso, codigo_region);
		}else {
			return estudianteRepository.listarEstudiantes();
		}
	}
	
}
