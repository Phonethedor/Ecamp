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
	<!-- Inicio navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/home">Logistiqal</a>
			<div class="navbar">
				<div class="navbar-nav">					
				</div>
			</div>
		</div>
	</nav>
	<!-- Fin navbar -->
	<!-- Inicio Contenido -->
	<div class="p-3">
		<!-- Inicio Mensajes -->
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show" role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<!-- Fin Mensajes -->
		<!-- Boton agregar usuario -->
			<!-- <a href="agregarForm" class="btn m-2 btn-success">Agregar usuario</a> -->
		<div class="container-fluid p-5">
		<!-- Paginacion bootstrap -->
		
		<div class="row">
			<div class="col-sm-12">
				<form method="POST" action="cantidad">					
					<table class="float-right">
						<tr>
			       			<td><input class="form-control" type="number" placeholder="${cantres}" value="${cantres}" name="cantprod" /></td>
			       			<td><input type="submit" class="btn m-2 btn-dark" value="Registros" /></td>
		    	</form>			
			    <form method="POST" action="buscar">
			                <td>
			                	<input class="form-control" type="text" placeholder="Buscador" name="textoBuscado" />
			                </td>
			                <td colspan="2"><input type="submit" class="btn m-2 btn-dark" value="Buscar" /></td>
			            </tr>
			        </table>
			    </form>
		    </div>
	    </div>
	    <ul class="pagination pagination-lg justify-content-center">
			<c:forEach items="${paginas}" var="pagina">
				<li class="page-item ${paginaActual == pagina ? 'disabled' : ''}"><a class="page-link" href="home?p=${pagina}" tabindex="-1">${pagina}</a></li>
			</c:forEach>
		</ul>
	</div>
		
		<!-- Inicio Tabla -->
		<div class="container-fluid">
			<table border="1" class="table table-dark table-striped">
				<thead class="thead-dark">
					<tr class="text-center">						
						<th class="col-2 align-middle" scope="col">Código</th>
						<th class="col-2 align-middle" scope="col">Nombre</th>						
						<th class="col-2 align-middle" scope="col">Precio</th>
						<th class="col-2 align-middle" scope="col">Stock</th>
						<th class="col-2 align-middle" scope="col">Acciones<a href="agregarForm" class="btn m-2 btn-secondary">Agregar Producto</a></th>
					</tr>
				</thead>
				<tbody class="text-center">
					<c:forEach items="${VO.productos}" var="u">
						<tr>							
							<td>${u.getCodigo()}</td>
							<td>${u.getNombre()}</td>
							<td>${u.getPrecio()}</td>
							<td>${u.getStock()}</td>
							<td>
								<a href="editarForm?idProducto=${u.getIdProducto()}"class="btn btn-secondary btnsm"> Editar</a> 
								<a href="eliminar?idProducto=${u.getIdProducto()}" class="btn btn-danger btnsm"> Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<ul class="pagination pagination-lg justify-content-center">
			<c:forEach items="${paginas}" var="pagina">
				<li class="page-item ${paginaActual == pagina ? 'disabled' : ''}"><a class="page-link" href="home?p=${pagina}" tabindex="-1">${pagina}</a></li>
			</c:forEach>
		</ul>
		<!-- Fin tabla -->
	</div>
	<!-- Fin Contenido -->
	<!-- footer -->
	<footer
		class="container-fluid text-center bg-dark text-white py-2 fixed-bottom">
		<h1>JSP PRODUCTO</h1>
		<a href="" class="text-white">web site developed by Popopo <i class="far fa-registered"></i>
		</a>
	</footer>
</body>
</html>