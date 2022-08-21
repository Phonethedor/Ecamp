package com.edutecno.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dao.BusquedaEmpleadoDao;
import com.edutecno.dao.BusquedaEmpleadoDaoImp;
import com.edutecno.facade.Facade;
import com.edutecno.model.Empleado;

@WebServlet("/procesaBusquedaEmpleado")
public class ProcesaBusquedaEmpleado extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		
		String nombre = request.getParameter("nombre");//obteniendo los input del index.jsp en las tarjetas de entrada
		String numEmpleado = request.getParameter("numEmpleado");
		String numDepartamento = request.getParameter("numdDepto");
		
		if (numEmpleado.isEmpty()) {
			numEmpleado = "0";
		}
		if (numDepartamento.isEmpty()) {
			numDepartamento = "0";
		}
		
		//BusquedaEmpleadoDao busqueda = new BusquedaEmpleadoDaoImp();
		Facade facade = new Facade();
		listaEmpleados = facade.busquedaEmpleado(nombre, Integer.parseInt(numEmpleado), Integer.parseInt(numDepartamento));
		request.setAttribute("empleadoDao", listaEmpleados);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
