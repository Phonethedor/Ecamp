package com.edutecno.main;

import java.sql.SQLException;

import com.edutecno.dao.CursoDAO;
import com.edutecno.dao.FormaPagoDAO;
import com.edutecno.dao.InscripcionDAO;
import com.edutecno.model.InscripcionDTO;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		CursoDAO cursoDAO  = new CursoDAO();
//		
//		System.out.println(cursoDAO.obtieneCursos());
//		
//		FormaPagoDAO formaPagoDAO = new FormaPagoDAO();
//		System.out.println(formaPagoDAO.obtieneFormasDePago());
		
		InscripcionDAO inscripcionDAO = new InscripcionDAO();
		
		InscripcionDTO inscripcionPrueba = new InscripcionDTO();
		inscripcionPrueba.setNombre("Fulanito");
		inscripcionPrueba.setTelefono("9990000");
		inscripcionPrueba.setIdCurso(1);
		inscripcionPrueba.setIdFormaPago(2);
		
//		InscripcionDTO inscripcion = inscripcionDAO.insertarInscripciones(new InscripcionDTO(0,"Fulanito","9690000",1,1));
		
		InscripcionDTO inscripcion = inscripcionDAO.insertarInscripciones(inscripcionPrueba);
		
		System.out.println(inscripcion.getIdInscripcion());
		
	}
}
