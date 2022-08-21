package com.edutecno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.model.Pasajero;
import com.edutecno.repository.PasajeroRepository;

@Service
public class PasajeroServiceImp implements PasajeroService {
	@Autowired
	private PasajeroRepository pasajeroRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pasajero> findAll() {
		return pasajeroRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Pasajero pasajero) {
		pasajeroRepo.save(pasajero);
	}

	@Override
	@Transactional
	public void update(Pasajero pasajero) {
		pasajeroRepo.save(pasajero);
	}

	@Override
	@Transactional
	public void delete(Pasajero pasajero) {
		pasajeroRepo.delete(pasajero);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Pasajero> findById(Long id){
		return pasajeroRepo.findById(id);
	}
}
