package com.bootcamp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.dto.Region;

@Repository
public interface RegionRepository  extends  JpaRepository<Region, Integer>{
	
	@Query(value="SELECT * FROM region;", nativeQuery = true)
	List<Region> listarRegiones();
}
