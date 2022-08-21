package com.edutecno.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.model.InscripcionDTO;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class PosInscripcion
 * responsabilidad de recibir los datos del formulario de inscripcion
 * asignarlos a un objeto InscripcionDTO
 * invicar al facade y llamar al data access object e insertar la inscripcion en la base de datos
 */
@WebServlet("/posInscripcion")//ruta de acceso al servlet, o path (mapping)
public class PosInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtenemos los datos enviados mediante el request.getParameter()
		String nombre = request.getParameter("nombre");
		String telefono = request.getParameter("telefono");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		int idFormaPago = Integer.parseInt(request.getParameter("idFormaPago"));
		
		//setear los datos en InscripcionDTO para insertar el registro en la base de datos mediante el facade
		InscripcionDTO inscripcionDTO = new InscripcionDTO();
		inscripcionDTO.setNombre(nombre);
		inscripcionDTO.setTelefono(telefono);
		inscripcionDTO.setIdCurso(idCurso);
		inscripcionDTO.setIdFormaPago(idFormaPago);
		System.out.println(inscripcionDTO);
		//invocacion al facade para acceder al data access object InscripcionDAO
		Facade facade = new Facade();
		
		try {
			
			//inscripcionDTO = facade.insertarInscripciones(inscripcionDTO);
			InscripcionDTO inscripcionRegistrada = facade.insertarInscripciones(inscripcionDTO);
			
			//seteando los datos a enviar en el request.setAttribute()
			request.setAttribute("inscripcion", inscripcionRegistrada);
			//despachando hacia un servlet o vista
			request.getRequestDispatcher("preConfirmacion").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
