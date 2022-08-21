package com.edutecno.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;

/**
 * Servlet implementation class ProcesaEmpleado
 * responsabilidad de acceder al data access object mediante el facade y consultar por los empleados
 * despachando los datos necesarios hacia la vista
 */
@WebServlet("/procesaEmpleado")
public class ProcesaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instancia del Facade para acceder al data access object
		Facade facade = new Facade();
		
		//se setea en el request la lista de empleados obtenida de la consulta a la base de datos
		request.setAttribute("empleados", facade.obtieneEmpleados());
		
		//se despacha hacia la vista empleados.jsp
		request.getRequestDispatcher("empleados.jsp").forward(request, response);
	}
}
