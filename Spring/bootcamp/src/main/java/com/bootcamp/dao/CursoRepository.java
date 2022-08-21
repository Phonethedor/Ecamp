package com.bootcamp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.dto.Curso;

@Repository
public interface CursoRepository extends  JpaRepository<Curso, String>{

	@Query(value="SELECT * FROM curso;", nativeQuery = true)
	List<Curso> listarCursos();
	
}
