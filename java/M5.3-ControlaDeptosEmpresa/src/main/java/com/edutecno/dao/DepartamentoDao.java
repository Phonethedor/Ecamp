package com.edutecno.dao;

import java.util.List;

import com.edutecno.model.Departamento;

//existiran los metodos declarados que pertenecen a cada objeto que representan
//la interfaz es un repositorio que dictamina que metodos estan siendo implementados
public interface DepartamentoDao {
	
	public List<Departamento> obtieneDepartamentos();
	
	//findAll()
	//findById(int id)
	//save(Object object)
	//delete(Object object)/ delete(int id)
	//findByNombre(String nombre)
	//findLastId()
}
