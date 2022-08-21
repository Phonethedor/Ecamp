package com.bootcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.dao.CursoRepository;
import com.bootcamp.dto.Curso;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<Curso> listarCursos() {
		return cursoRepository.listarCursos();
	}

}
