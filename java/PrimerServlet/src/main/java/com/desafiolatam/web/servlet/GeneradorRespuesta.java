package com.desafiolatam.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/generadorRespuesta")
public class GeneradorRespuesta extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nombre;
		String apellido;
		String fechaActual;
		PrintWriter printWriter = response.getWriter();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		fechaActual = formato.format(new Date());
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("Bienvenido/a " + nombre + " " + apellido); 
		printWriter.println("La fecha es: " + fechaActual); printWriter.println("</body>");
		printWriter.println("</html>");		
	}
}















