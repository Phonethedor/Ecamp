package com.ejb.sessionbean;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestEJB")
public class TestEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB//inyeccion de un enterprise java bean
	public CalculadoraBean ejb = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		float result = 0;
		ejb = new CalculadoraBean();

		try {
			String s1 = request.getParameter("num1");
			String s2 = request.getParameter("num2");
			String s3 = request.getParameter("group1");

			System.out.println(s3);

			if (s1 != null && s2 != null) {
				Float num1 = new Float(s1);
				Float num2 = new Float(s2);

				if (s3.equals("add")) {
					result = ejb.add(num1.floatValue(), num2.floatValue());
				} else if (s3.equals("sub")) {
					result = ejb.subtract(num1.floatValue(), num2.floatValue());
				} else if (s3.equals("multi")) {
					result = ejb.mutliply(num1.floatValue(), num2.floatValue());
				} else {
					result = ejb.divide(num1.floatValue(), num2.floatValue());
				}
			}
		} // end of try
		catch (Exception e) {
			e.printStackTrace();
			// result = "Not valid";
		}
		request.setAttribute("result", result);//seteo de atributo en el request para despachar a la pagina result
		request.getRequestDispatcher("result.jsp").forward(request, response);//despacho del request y response al request
	}
}
