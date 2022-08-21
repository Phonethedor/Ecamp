package com.edutecno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.model.Destino;
import com.edutecno.repository.DestinoRepository;

@Service
public class DestinoServiceImp implements DestinoService {
	@Autowired
	private DestinoRepository destinoRepo; 
	
	@Override
	@Transactional(readOnly = true)
	public List<Destino> findAll() {
		return destinoRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Destino destino) {
		destinoRepo.save(destino);
	}

	@Override
	@Transactional
	public void update(Destino destino) {
		destinoRepo.save(destino);
	}

	@Override
	@Transactional
	public void delete(Destino destino) {
		destinoRepo.delete(destino);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Destino> findById(Long id) {		
		return destinoRepo.findById(id);
	}

}
