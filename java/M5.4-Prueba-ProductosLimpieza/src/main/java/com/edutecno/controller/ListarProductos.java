package com.edutecno.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.dto.ProductoCategoria;
import com.edutecno.facade.Facade;

/**
 * Servlet implementation class ListarProductos
 * responsabilidad de consultar por los Productos y Cetegorias, despachar los datos a listarProductos.jsp
 */
@WebServlet("/listarProductos")
public class ListarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//acceder al Facade mediante instancia y obtener todos los Productos con sus Categorias
		Facade facade = new Facade();
		List<ProductoCategoria> listaProductosCategorias = facade.findAllProductoCategoria();
		
				//setAttribute(identificador,Object)
		request.setAttribute("productos", listaProductosCategorias);//seteando en el request los datos a despachar
		request.getRequestDispatcher("listarProductos.jsp").forward(request, response);//despachando hacia la vista listarProductos.jsp
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
