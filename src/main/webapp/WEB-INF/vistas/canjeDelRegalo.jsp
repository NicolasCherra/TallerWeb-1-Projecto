<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>One Gift | Home</title>
<link href="css/stylecajaexp.css" rel="stylesheet">
</head>
<body>
	<%@ include file="./layout/Header.jsp"%>


	<div class="container mt-5 pt-5">
		<div class="masthead-heading text-uppercase">Caja de regalo</div>
	</div>

	<div class="container mt-3">
		<div class="card-deck row">
			<div class="col-7">
				<img src="${caja.imagen}" class="card-img-top img-fluid">
			</div>
			<div class="col-5 pl-3 p-1 data-container">
				<div>
					<h3 class="text-uppercase">${caja.nombre}</h3>
					<p class="mt-4 font-weight-normal">${caja.descripcion}</p>
					<p class="mt-5">
						<i class="fas fa-dollar-sign mr-3"></i>Precio: <b>$${caja.precio}</b>
					</p>
					<p>
						<i class="fas fa-users mr-2"></i>Personas: <b>${caja.cantidadPersonas}</b>
					</p>
				</div>

			</div>
		</div>
	</div>

	<hr>

	<div class="container-fluid contenedor text-center" id="experiencias">
		<div class="masthead-heading mt-1">Elegí tu experiencia de la caja</div>
		<h1 class="text-info">${caja.nombre}</h1>
		<div class=" container-fluid d-flex row justify-content-center text-center">

			<c:forEach items="${experiencias }" var="experiencia">
				<div class="carousel-item">
  					<img src="${experiencia.imagen }" alt="">
  					<div class="carousel-caption d-none d-md-block">
    					<h5>${experiencia.nombre }</h5>
    					<p>${experiencia.descripcion }</p>
    					<button class="btn btn-danger btn-xl w-50 m-1">Confirmar Experiencia</a>
  					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<%@ include file="./layout/Footer.jsp"%>
</body>
</html>
