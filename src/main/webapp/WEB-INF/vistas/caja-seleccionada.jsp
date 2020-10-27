<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>One Gift | Home</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Style.css" rel="stylesheet">
</head>
<%@ include file="./layout/Header.jsp"%>
<body>

	<div class="container">
		<div class="container-fluid h-500 mt-5 ">
			<div class="row w-100 align-items-center">
				<div class="col text-center ">
					
				</div>
			</div>
		</div>

		<div class="card-deck">
				<div class="card">
					<div class="card-img">
						<img src="${caja.imagen}"
							class="card-img-top img-fluid">
					</div>
					<div class="card-body text-center">
						<h5 class="card-title">${caja.nombre}</h5>
						<p class="card-text">${caja.descripcion}</p>
						<p class="card-text">Precio: $${caja.precio}</p>
						<p class="card-text">Cantidad de personas: ${caja.cantidadPersonas}</p>
					</div>
					<div class="card-footer">
					<form:form  method="POST" action="mostrarCaja" modelAttribute="CajaDeRegalo"> 
						<form:hidden path="numeroDeCaja" value="${caja.numeroDeCaja}"/>
						<form:button class="btn btn-danger w-100" type="submit">Comprar</form:button>
					</form:form >
					</div>
				</div>
		</div>
	</div>

<%@ include file="./layout/Footer.jsp"%>

	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>