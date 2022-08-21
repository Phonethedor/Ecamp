package com.repaso.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.dao.TiendaRepository;
import com.repaso.dto.Tienda;

@Service
public class TiendaServiceImpl implements ITiendaService{
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Override
	public List<Tienda> listarTiendas(){
		return tiendaRepository.findAll();
	}
}
