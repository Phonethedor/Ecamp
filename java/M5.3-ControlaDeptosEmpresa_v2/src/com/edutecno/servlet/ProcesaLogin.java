package com.edutecno.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edutecno.dao.LoginDao;
import com.edutecno.dao.LoginDaoImp;
import com.edutecno.facade.Facade;

@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean usuarioExiste = false;
		
		String correo = request.getParameter("email");//requere el atributo name="name" del input en el login.jsp dentro del formulario
		String password = request.getParameter("password");
		//LoginDao loginDao = new LoginDaoImp();
		Facade facade = new Facade();
		usuarioExiste= facade.usuarioRegistrado(correo,password);
		request.setAttribute("usuarioExiste", usuarioExiste);
		
		if (usuarioExiste) {
			HttpSession sesionUsuario = request.getSession(true);
			sesionUsuario.setAttribute("correo", correo);
			request.setAttribute("correo", correo);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
