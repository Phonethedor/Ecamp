package com.edutecno.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>, PagingAndSortingRepository<Producto, Integer> {
	/*@Query(value = "select * from PRODUCTO p where p.nombre like %?%",
		   countQuery = "SELECT count(*) FROM producto WHERE nombre LIKE %?%",
		   nativeQuery = true)
	public Page<Producto> findAllByNombre(String nombre, Pageable pageable);*/	
	public List<Producto> findByNombreContainingIgnoreCase(String nombre);	
}
