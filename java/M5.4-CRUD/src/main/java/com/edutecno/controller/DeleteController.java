package com.edutecno.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.edutecno.facade.Facade;
import com.edutecno.model.Persona;
 
@WebServlet("/deletePerson")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int id = Integer.parseInt(request.getParameter("id"));
        Facade facade = new Facade();
        Persona persona = facade.findById(id);
 
        if (persona.getId() != 0) {
            facade.delete(persona);
        }
 
        request.getRequestDispatcher("listarPersonas").forward(request, response);
    }
 
}
