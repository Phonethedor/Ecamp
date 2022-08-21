package com.bootcamp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.dto.Estudiante;

@Repository
public interface EstudianteRepository extends  JpaRepository<Estudiante, Integer>{
	
	@Query(value="SELECT * FROM estudiante", nativeQuery = true)
	List<Estudiante> listarEstudiantes();
	
	@Query(value="select * from estudiante where codigo_curso = ?1 ;", nativeQuery = true)
	List<Estudiante> filtrarEstudiantes(String codigo_curso);
	
	@Query(value="select * from estudiante JOIN comuna ON estudiante.codigo_comuna = comuna.codigo_comuna JOIN region ON comuna.codigo_region = region.codigo_region WHERE region.codigo_region = ?1 ;", nativeQuery = true)
	List<Estudiante> filtrarEstudiantesPorRegion(Integer codigo_region);
	
	@Query(value="select * from estudiante JOIN comuna ON estudiante.codigo_comuna = comuna.codigo_comuna JOIN region ON comuna.codigo_region = region.codigo_region WHERE codigo_curso = ?1 AND region.codigo_region = ?2 ;", nativeQuery = true)
	List<Estudiante> filtrarEstudiantesPorCursoYRegion(String codigo_curso, Integer codigo_region);
 }
