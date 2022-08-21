package com.repaso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.repaso.dto.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer>{
	
	@Query(value="SELECT * FROM orders ORDER BY orders.order_date DESC;", nativeQuery = true)
	List<Orden> listarOrdenes();
	
	@Query(value="SELECT * FROM orders JOIN stores ON orders.store_id = stores.store_id WHERE stores.store_id = ?1 ORDER BY orders.order_date DESC;", nativeQuery = true)
	List<Orden> listarOrdenesPorTienda(Integer storeId);
	
	@Query(value="SELECT * FROM orders WHERE orders.order_status = ?1 ORDER BY orders.order_date DESC;", nativeQuery = true)
	List<Orden> listarOrdenesPorEstado(Integer orderStatus);
	
	@Query(value="SELECT * FROM orders JOIN stores ON orders.store_id = stores.store_id WHERE stores.store_id = ?1 AND orders.order_status = ?2 ORDER BY orders.order_date DESC;", nativeQuery = true)
	List<Orden> listarOrdenesFiltroPorTiendaYEstado(Integer storeId, Integer orderStatus);
	
	
}
