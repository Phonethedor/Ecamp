package com.edutecno.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;

/**
 * Servlet implementation class ProcesaDepartamento
 * responsabilidad de obtener todos los departamentos mediante el Facade que accede al data access object
 * despachar hacia la vista los elementos a desplegar o hacia un servlet
 */
@WebServlet("/procesaDepartamento")//URL mapping para acceder al servlet
public class ProcesaDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//invocación del Facade mediante instancia
		Facade facade = new Facade();
		
		//en el request se setean los datos que se enviaran o despacharan a la vista mediante Dispatcher
		request.setAttribute("departamentos", facade.obtieneDepartamentos());
		
		//se despacha hacia la vista departamentos.jsp
		request.getRequestDispatcher("departamentos.jsp").forward(request, response);
	}
}
