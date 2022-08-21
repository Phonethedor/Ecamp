package com.repaso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.repaso.dto.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

}
