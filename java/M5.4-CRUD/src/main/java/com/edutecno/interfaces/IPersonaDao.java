package com.edutecno.interfaces;

import java.util.List;

import com.edutecno.model.Persona;

//funciona como repositorio para el objeto Persona
public interface IPersonaDao {

	public List<Persona> findAll();
	public Persona findById(int id);
	public boolean add(Persona person);
	public boolean update(Persona person);
	public boolean delete(Persona person);

}
