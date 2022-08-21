package com.edutecno.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.model.InscripcionDTO;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class PreListarInscripciones
 * responsabilidad de cosultar por las inscripciones existentes en la base de datos
 */
@WebServlet("/preListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instanciamos el facade y accedemos a el data access object InscripcionDAO
		Facade facade = new Facade();
		
		try {
			//se obtiene la lista de inscripciones consultada
			List<InscripcionDTO> listaInscripciones = facade.obtieneInscripciones();
			//seteando los datos a despachar en el request
			request.setAttribute("listaInscripciones", listaInscripciones);
			//despachando el request hacia un servlet o una vista
			request.getRequestDispatcher("listaInscripciones.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
