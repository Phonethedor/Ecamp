package com.bootcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.dao.RegionRepository;
import com.bootcamp.dto.Region;

@Service
public class RegionServiceImpl implements IRegionService{
	
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public List<Region> listarRegiones() {
		return regionRepository.listarRegiones();
	}

}
