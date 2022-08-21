<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.edutecno.model.Producto"%>
<%@page import="com.edutecno.vo.ProductoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/4.3.0/css/bootstrap.min.css" />
<title>Empresa Logistiqal</title>
</head>
<body>
	<!-- navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/home">Logistiqal</a>
			<div class="navbar">
				<div class="navbar-nav">					
				</div>
			</div>
		</div>
	</nav>
	<!-- Inicio Contenido -->
	<div class="container mt-5 p-5">
		<div class="p-3">
			<h1>Editar usuario</h1>
			<c:if test="${mensaje != null ? true : false}">
				<div class="alert alert-secondary alert-dismissible fade show" role="alert">${mensaje}
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<form action="editar" method="post">
				<input type="hidden" name="idProducto" value="${VO.getIdProducto()}" />
				<table>
					<tr>
						<td class="p-2"><label for="codigo">Código:</label></td>
						<td>
							<input class="form-control" type="text" name="codigo" placeholder="Código" value="${VO.getCodigo()}" />
						</td>
					</tr>
					<tr>
						<td class="p-2"><label for="nombre">Nombre:</label></td>
						<td><input class="form-control" type="text" placeholder="Nombre" name="nombre" value="${VO.getNombre()}" />
						</td>
					</tr>
					<tr>
						<td class="p-2"><label for="rut">Precio:</label></td>
						<td><input class="form-control" type="number" placeholder="Precio" name="precio" value="${VO.getPrecio()}" /></td>						
					</tr>
					<tr>
						<td class="p-2"><label for="rut">Stock:</label></td>
						<td><input class="form-control" type="number" placeholder="Stock" name="stock" value="${VO.getStock()}" /></td>						
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" class="btn m-2 btn-success" value="Guardar" />
							<a type="button" class="btn m-2 btn-warning" href="/home">Volver</a>
						</td>
						
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- footer -->
	<footer
		class="container-fluid text-center bg-dark text-white py-2 fixed-bottom">
		<h1>JSP PRODUCTO</h1>
		<a href="" class="text-white">web site developed by Popopo <i class="far fa-registered"></i>
		</a>
	</footer>
</body>
</html>