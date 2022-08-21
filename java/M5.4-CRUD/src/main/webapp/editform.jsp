<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.edutecno.interfaces.IPersonaDao"%>
<%@page import="com.edutecno.dao.PersonaDaoImp"%>
<%@page import="com.edutecno.model.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 shrink-to-fit=no" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />

<!-- Google fonts -->
<link href="https://fonts.googleapis.com/css?family=Cabin:400,700"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/css?family=Lobster:400,700"
	rel="stylesheet" />

<!-- Font awesome -->
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

<!-- mi estilo -->
<link rel="stylesheet" href="assets/css/style.css" />
<title>Editar persona</title>
</head>
<body>

	

	<%
	String id = request.getParameter("id");
	PersonaDaoImp personaDaoImp = new PersonaDaoImp();
	Persona u = personaDaoImp.findById(Integer.parseInt(id));
	System.out.println(u);
	%>

	<!-- barra de navegacion -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"><h1>CRUD</h1></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp">Inicio <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="addpersonform.jsp">Añadir Persona</a></li>
					<li class="nav-item"><a class="nav-link" href="listarPersonas">Ver
							personas</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	
	<!-- Formulario -->
	<div class="container border border-white col-sm-12">
		<div class="form-body">
			<div class="row">
				<div class="col-sm-12">
					<div class="form-holder">
						<div class="form-content container mx-5 px-5">
							<div class="form-items form-body-color">
								<h3>Editar Usuario</h3>
								<p>Complete los datos a continuación.</p>
								<form class="requires-validation" novalidate
									action="editPerson" method="post">
									
									
									<div class="col-md-12 col-sm-12"><!-- el input id esta escondido (type="hidden") -->
										<input class="form-control" type="hidden" name="id" value="<%=u.getId()%>">
									</div>

									<div class="col-md-12 col-sm-12">
										<input class="form-control" type="text" name="name" value="<%=u.getName()%>"
											placeholder="Nombre completo" required>
										<div class="valid-feedback">El campo de nombre de
											usuario es válido!</div>
										<div class="invalid-feedback">El campo del nombre de
											usuario no puede estar en blanco!</div>
									</div>

									<div class="col-md-12 col-sm-12">
										<input class="form-control" type="email" name="email" value="<%=u.getEmail()%>"
											placeholder="E-mail" required>
										<div class="valid-feedback">El campo de correo
											electrónico es válido!</div>
										<div class="invalid-feedback">El campo de correo
											electrónico no puede estar en blanco!</div>
									</div>

									<div class="col-md-12 col-sm-12">
										<select class="form-select mt-3" name="country" required>
											<option selected disabled><%=u.getCountry()%> </option>
                                            <option selected style="color:red"><%=u.getCountry()%> </option>
											<option>Chile</option>
											<option>Argentina</option>
											<option>Venezuela</option>
											<option>Otro</option>
										</select>
										<div class="valid-feedback">Seleccionaste un país!</div>
										<div class="invalid-feedback">Por favor seleccione un
											país!</div>
									</div>


									<div class="col-md-12 col-sm-12">
										<input class="form-control" type="password" name="password" value="<%=u.getPassword()%>"
											placeholder="Password" required>
										<div class="valid-feedback">El campo de contraseña es
											válido!</div>
										<div class="invalid-feedback">El campo de la contraseña
											no puede estar en blanco!</div>
									</div>


									<div class="col-md-12 col-sm-12 mt-3">
										<label class="mb-3 mr-1" for="gender">Genero: </label> 
										<input
											type="radio" class="btn-check" name="sex" value="male"
											id="male" autocomplete="off" required> <label
											class="btn btn-sm btn-outline-secondary" for="male">Hombre</label>

										<input type="radio" class="btn-check" name="sex"
											value="female" id="female" autocomplete="off" required>
										<label class="btn btn-sm btn-outline-secondary" for="female">Mujer</label>

										<input type="radio" class="btn-check" name="sex"
											value="secret" id="secret" autocomplete="off" required>
										<label class="btn btn-sm btn-outline-secondary" for="secret">Secreto</label>
										<div class="valid-feedback mv-up">Seleccionaste un
											género!</div>
										<div class="invalid-feedback mv-up">Por favor seleccione
											un género!</div>
									</div>

									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="invalidCheck" required> <label
											class="form-check-label">Confirmo que todos los datos
											son correctos</label>
										<div class="invalid-feedback">Confirme que todos los
											datos ingresados son correctos!</div>
									</div>


									<div class="form-button mt-3">
										<button id="submit" type="submit" class="btn btn-success">
											Editar Persona</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<footer
		class="container-fluid text-center bg-dark text-white py-4 fixed-bottom">
		<h1>CRUD</h1>
		<a href="" class="text-white">web site developed by FS-0001 <i
			class="far fa-registered"></i>
		</a>
	</footer>

	<!--jQuery 3.4.0 version no slim-->
	<script src="https://code.jquery.com/jquery-3.4.0.min.js"
		integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
		crossorigin="anonymous"></script>
	<!--Popper JS 1.14.3-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<!--bootstrap JS 4.2.1-->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<!--Mi script-->
	<script src="assets/js/script.js"></script>
</body>
</html>