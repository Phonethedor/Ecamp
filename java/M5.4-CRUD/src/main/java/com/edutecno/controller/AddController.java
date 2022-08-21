package com.edutecno.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.edutecno.facade.Facade;
import com.edutecno.model.Persona;
 
/**
 * Servlet implementation class AddController
 */
@WebServlet("/addPerson")
public class AddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String country = request.getParameter("country");
 
        Facade facade = new Facade();
 
        Persona persona = new Persona();
        persona.setName(name);
        persona.setPassword(password);
        persona.setEmail(email);
        persona.setCountry(country);
        persona.setSex(sex);
 
        if (facade.add(persona)) {
            request.getRequestDispatcher("addperson-success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("addperson-error.jsp").forward(request, response);
        }
    }
}
