package com.edutecno.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;

/**
 * Servlet implementation class ProcesaBusquedaEmplDept
 * responsabilidad de recibir el dato del formulario, para buscar el departamento y sus empleados
 * despachar los datos encontrados mediante el facade que accede al data access object a la vista
 */
@WebServlet("/procesaBusquedaEmplDept")
public class ProcesaBusquedaEmplDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//se obtiene el dato que viaja en el request, peticion enviada desde la vista
		String nombreDepartamento = request.getParameter("nomDepto");
		
		//invocación del Facade mediante la instancia para acceder al data access object
		Facade facade = new Facade();
		
		//List<DepartamentoEmpleado> listaDepartamentoEmpleado = facade.obtieneDepartamento(nombreDepartamento);
		//request.setAttribute("departamentoEmpleado",listaDepartamentoEmpleado)
		
		//seteo de los datos a enviar en el request para ser despachados
		request.setAttribute("departamentoEmpleado", facade.obtieneDepartamento(nombreDepartamento));
		
		//despachar los datos mediante Dispatcher
		request.getRequestDispatcher("listaUnoMuchos.jsp").forward(request, response);
	}

}
