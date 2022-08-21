package com.edutecno.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.edutecno.facade.Facade;
import com.edutecno.model.Persona;
 
@WebServlet("/editPerson")
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String country = request.getParameter("country");
 
        Facade facade = new Facade();
 
        Persona persona = new Persona(id, name, password, email, sex, country);
        
        if (facade.update(persona)) {
            request.getRequestDispatcher("listarPersonas").forward(request, response);
        } else {
            request.getRequestDispatcher("addperson-error.jsp").forward(request, response);
        }
    }
}
