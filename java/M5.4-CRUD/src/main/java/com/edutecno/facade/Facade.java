package com.edutecno.facade;

import java.util.List;

import com.edutecno.dao.PersonaDaoImp;
import com.edutecno.interfaces.IPersonaDao;
import com.edutecno.model.Persona;

public class Facade {
	//instancia para acceder al data access object mediante la interfaz
	private IPersonaDao personaDao = new PersonaDaoImp();
	
	public List<Persona> findAll() {
		return personaDao.findAll();
	}

	public Persona findById(int id) {
		return personaDao.findById(id);
	}

	public boolean add(Persona person) {
		return personaDao.add(person);
	}

	public boolean update(Persona person) {
		return personaDao.update(person);
	}

	public boolean delete(Persona person) {
		return personaDao.delete(person);
	}
}
