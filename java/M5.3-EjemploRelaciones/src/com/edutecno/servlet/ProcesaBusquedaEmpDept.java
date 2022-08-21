package com.edutecno.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dao.DepartamentoEmpleadoDaoImpl;
import com.edutecno.modelo.DepartamentoEmpleado;

@WebServlet("/procesaBusquedaEmplDept")
public class ProcesaBusquedaEmpDept extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//atributo para requerir del formulario
		String nomDepartamento = (String) req.getParameter("nomDepto");
		
		//lista de tipo DepartamentoEmpleado
		List<DepartamentoEmpleado> deptosEmpleadosList = new ArrayList <DepartamentoEmpleado>();
		//instancia del dao DepartamentoEmpleadoDaoImpl para utilizar el metodo obtieneDepartamento que como se
		//vio anteriormente recibe como parámetro el nombre del elemento a buscar.
		DepartamentoEmpleadoDaoImpl obtieneDeptoEmpleado = new DepartamentoEmpleadoDaoImpl();
		
		deptosEmpleadosList = obtieneDeptoEmpleado.obtieneDepartamento(nomDepartamento);
		
		//Luego de obtener los valores y guardarlos en la lista creada utilizando el objeto request añade la
		//lista obtenida y luego redirige a la vista pasando tal request.
		req.setAttribute("departamentoEmpleado", deptosEmpleadosList);
		
		req.getRequestDispatcher("listaUnoMuchos.jsp").forward(req, resp);
	}
	
}
