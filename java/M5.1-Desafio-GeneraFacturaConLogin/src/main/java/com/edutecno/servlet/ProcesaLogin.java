package com.edutecno.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcesaLogin
 * tiene la responsabilidad de obtener los datos del formulario de login y verificar mediante un usuario y password estaticos si son correctos
 * y tomar la decision de redirigir a areaPrivada.jsp o ejecutar una alerta de usuario o password incorrecto enviando de nuevo a index.jsp
 * 
 * se creara la session y la cookie
 */
@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String LOGIN = "usuario";//variables final o constantes que serviran para comprobar los datos ingresados del usuario
	private final String PASS = "admin";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obteniendo los input ingresados por el usuario, a traves del name="" de cada input
		String requestLogin = request.getParameter("login"); //name="login"
		String requestPass = request.getParameter("pass");//name="pass";
		
		PrintWriter out = response.getWriter();//instanciando un PrintWriter que funciona como un document.write() en javascript y permite escribir estructuras HTML,CSS,SCRIPT
		
		if (!LOGIN.contentEquals(requestLogin) || !PASS.contentEquals(requestPass)) {//si el ingreso no es igual a las variables existentes se da una alerta
			//ejecutando una alerta mediante un script si los datos ingresados son erroneos
			out.println("<script type=\"text/javascript\">");
			out.println("alert('usuario o password incorrectos');");
			out.println("location='login.jsp';");
			out.println("</script>");
		} else {//si no, si los parametros ingresados en el input son correctos
			
			//se apertura la sesion y esta disponible para ser despachada a otros servlet o vista
			HttpSession session = request.getSession(true);
			
			//seteando valores en la sesion que luego se pueden obtener en el servlet o el jsp
			//se establece el nombre de usuario ingresado y validado o el obtenido de la consulta a la base de datos
			session.setAttribute("requestLogin", requestLogin); //setAtribute(identificador,objeto)
			
			//se establece el tiempo de la sesion en segundos
			session.setMaxInactiveInterval(0);//0 establece que la sesion no termina, hasta que se haga un logout
			
			//instancia de objeto Cookie para crear una cookie cuando los datos son correctos
							//Cookie(nombre,valor)
			Cookie cookie = new Cookie(requestLogin,"2022");
			
			cookie.setMaxAge(7000);//maximo de vida de la cookie
			cookie.setDomain("www.fullstackjava.com");//estableciendo el dominio
			cookie.setHttpOnly(true);//la cookie se establece solo con metodo HTTP
			cookie.setComment("cookie generada en procesa login");//comentario de la cookie
			cookie.setPath("/procesaLogin");//ruta o path de la cookie
			
			response.addCookie(cookie); //se agrega la cookie en el response y luego se puede obtener en otros servlet o vistas
			
			//se despachan los datos necesarios en el request y se redirige hacia una vista o servlet sea el caso
			request.getRequestDispatcher("ingresoValores.jsp").forward(request, response);
		}
	}
}
