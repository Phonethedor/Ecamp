package com.desafiolatam.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inicio")
public class GeneradorIndex extends HttpServlet{ 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter writer = response.getWriter();
			String formatoFecha = "yyyy-MM-dd";
			SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
			String fechaActual = formato.format(new Date());
			writer.println("<html><body>");
			writer.println("Tu primer servlet ");
			writer.println("La fecha actual es: " + fechaActual);
			writer.println("<body><html>");
	}
}


