<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscripcion</title>

<!-- BOOTSTRAP CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>

	<!-- BARRA DE NAVEGACION -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Listar Inscripciones</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item">
					<a class="nav-link" href="preInscripcion">Home</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="preInscripcion">Agregar Inscripción</a></li>
					<li class="nav-item">
					<a class="nav-link" href="preListarInscripciones">Listar Inscripciones</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- SECCION CONFIRMACION INSCRIPCION -->
	<section class="container mt-5 p-5">
		<div>
			<h1>Solicitud generada correctamente</h1>
			<p>sus datos generados son los siguientes</p>
			<p>Id de inscripcion: <c:out value="${inscripcion.getIdInscripcion()}"></c:out></p>
			<p>Nombre: <c:out value="${inscripcion.getNombre()}"></c:out></p>
			<p>Teléfono: <c:out value="${inscripcion.getTelefono()}"></c:out></p>
		</div>
	</section>

	<!-- BOOTSTRAP POPPER -->

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>
	<!-- BOOTSTRAP JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
</body>
</html>