package com.edutecno.service;

import java.sql.SQLException;
import java.util.List;

import com.edutecno.dao.CursoDAO;
import com.edutecno.dao.FormaPagoDAO;
import com.edutecno.dao.InscripcionDAO;
import com.edutecno.model.CursoDTO;
import com.edutecno.model.FormaPagoDTO;
import com.edutecno.model.InscripcionDTO;

//el face es un patrón de diseño que establece una entrada única a la capa de persistencia de datos
public class Facade {
	
	//metodo encargado de comunicarse con el CursoDAO y acceder a los cursos
	public List<CursoDTO> obtieneCursos() throws ClassNotFoundException, SQLException{
		CursoDAO cursoDao = new CursoDAO();//instancia para acceder al data access object
		return cursoDao.obtieneCursos();
	}
	
	//metodo encargado de comunicarse con el FormaPagoDAO y acceder a las formas de pago
	public List<FormaPagoDTO> obtieneFormasDePago() throws ClassNotFoundException, SQLException{
		FormaPagoDAO formaPagoDAO = new FormaPagoDAO();
		return formaPagoDAO.obtieneFormasDePago();
	}
	
	//metodo encargado de comunicarse con el InscripcionDAO y acceder a las inscripciones
	public List<InscripcionDTO> obtieneInscripciones() throws ClassNotFoundException, SQLException{
		InscripcionDAO inscripcionDAO = new InscripcionDAO();
		return inscripcionDAO.obtieneInscripciones();
	}
	
	//metodo encargado de comunicarse con el InscripcionDAO e inscribir o registrar(INSERT) la inscripcion recibida
	public InscripcionDTO insertarInscripciones(InscripcionDTO inscripcionDTO) throws ClassNotFoundException, SQLException {
		InscripcionDAO inscripcionDAO = new InscripcionDAO();
		return inscripcionDAO.insertarInscripciones(inscripcionDTO);
	}
	
	//delete(Object object)
	//save()
	//update()
	//findAll
	//findById()
	//findByNombre()
}
