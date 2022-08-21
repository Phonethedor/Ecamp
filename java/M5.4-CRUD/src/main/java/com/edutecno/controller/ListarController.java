package com.edutecno.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;
import com.edutecno.model.Persona;

@WebServlet("/listarPersonas")
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Facade facade = new Facade();
		
		List<Persona> listPersonas = facade.findAll();
		request.setAttribute("listPersonas", listPersonas);
		
		request.getRequestDispatcher("viewpersons.jsp").forward(request, response);

	}
}