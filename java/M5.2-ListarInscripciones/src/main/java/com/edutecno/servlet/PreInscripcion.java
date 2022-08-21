package com.edutecno.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.model.CursoDTO;
import com.edutecno.model.FormaPagoDTO;
import com.edutecno.service.Facade;

/**
 * Servlet implementation class PreInscripcion
 * responsabilidad de obtener los cursos y las formas de pago para enviarlas a la vista
 */
@WebServlet("/preInscripcion")//path para acceder, mapping
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instanciar Facade para acceder a los metodos y obtener los cursos y formas de pago
		Facade facade = new Facade();
		
		try {
			
			//se obtiene la lista de cursos
			List<CursoDTO> listaCursos = facade.obtieneCursos();
			//se obtiene la lista de formas de pago
			List<FormaPagoDTO> listaFormasPago = facade.obtieneFormasDePago();
			
			//setear los datos en el request para despacharlos a la vista mediante el request
			request.setAttribute("listaCursos", listaCursos);
			request.setAttribute("listaFormasPago", listaFormasPago);
			
			//despachar hacia la vista o servlet que procesara los datos
			request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
}
