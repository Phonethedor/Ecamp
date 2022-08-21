<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0 shrink-to-fit=no" />

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous" />

		<!-- Google fonts -->
		<link href="https://fonts.googleapis.com/css?family=Cabin:400,700" rel="stylesheet" />
		<link href="https://fonts.googleapis.com/css?family=Lobster:400,700" rel="stylesheet" />

		<!-- Font awesome -->
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
			integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
			crossorigin="anonymous" />

		<!-- mi estilo -->
		<link rel="stylesheet" href="assets/css/style.css" />
		<title>Error a añadiendo persona</title>
	</head>

	<body>

		<!-- barra de navegacion -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="index.jsp">
					<h1>CRUD</h1>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="index.jsp">Inicio
								<span class="sr-only">(current)</span>
							</a></li>
						<li class="nav-item active"><a class="nav-link" href="addpersonform.jsp">Añadir Persona</a></li>
						<li class="nav-item"><a class="nav-link" href="listarPersona">Ver
								personas</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container mt-5 text-left">
			<div class="col-sm-6">
				<p>Error añadiendo a la persona</p>
			</div>
			<div class="btn-group mt-1 col-sm-6" role="group" aria-label="Basic example">
				<a class="nav-link" href="addpersonform.jsp">
					<button type="button" class="btn btn-primary">Añadir
						Persona</button>
				</a> <a class="nav-link" href="listarPersonas">
					<button type="button" class="btn btn-primary">Ver personas
					</button>
				</a>
			</div>
		</div>

		<!--jQuery 3.4.0 version no slim-->
		<script src="https://code.jquery.com/jquery-3.4.0.min.js"
			integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
		<!--Popper JS 1.14.3-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<!--bootstrap JS 4.2.1-->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
		<!--Mi script-->
		<script src="assets/js/script.js"></script>
	</body>

	</html>