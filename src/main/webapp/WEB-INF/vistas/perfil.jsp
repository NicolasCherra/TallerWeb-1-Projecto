<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil | One Gift</title>
<link href="css/perfil.css" rel="stylesheet">
</head>
<body>

	<%@ include file="./layout/Header.jsp"%>


	<div class="container mt-5 pt-5 mb-5">
		<div class="main-body">
			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://i.postimg.cc/gjB3FpSR/profile.jpg" alt="Admin"
									class="rounded-circle" width="150">
								<div class="mt-3">
									<h3>${usuario.nombreUsuario}</h3>
									<p class="font-weight-normal">Usuario</p>
								</div>
							</div>
						</div>
					</div>
				</div>

				<c:if test="${not empty error}">
					<h6>
						<span class="text-warning">${error}</span>
					</h6>
					<br>
				</c:if>


				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Nombre</h6>
								</div>
								<div class="col-sm-9 text-secondary">${usuario.nombre}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Apellido</h6>
								</div>
								<div class="col-sm-9 text-secondary">${usuario.apellido}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">${usuario.email}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Miembro desde</h6>
								</div>
								<div class="col-sm-9 text-secondary">${usuario.fechaRegistro}</div>
							</div>
						</div>
					</div>
					<div class="row gutters-sm">
						<div class="col-sm-6 mb-3">
							<div class="card h-100">
								<div class="card-body">
									<h6 class="d-flex align-items-center mb-3">
										<i class="material-icons text-info mr-2">4</i>Regalos hechos
									</h6>
									<ul>
										<li>Experiencia virtual</li>
										<li>Estadia</li>
										<li>Cubo rubik</li>
										<li>Desayuno</li>

									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-6 mb-3">
							<div class="card h-100">
								<div class="card-body">
									<h6 class="d-flex align-items-center mb-3">
										<i class="material-icons text-info mr-2">2</i>Regalos
										recibidos
									</h6>
									<c:forEach items="${cajas}" var="caja">
									<form:form method="POST" action="canjearRegalo"
										modelAttribute="CajaDeRegalo">
										<form:hidden path="numeroDeCaja" value="${caja.numeroDeCaja}" />
										<form:button class="btn-success" type="submit">Canjear!</form:button>
									</form:form>									
									</c:forEach>
									<ul>
										<li class="m-1">Fotografía</li>
										<button type="button" class="btn-success">Canjear!</button>
										<li class="m-1">Impresión 3D</li>
										<button type="button" class="btn-success">Canjear!</button>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${not empty regalarError}">
		<div class="modal fade" id="modalOk" tabindex="-1" role="dialog"
			aria-labelledby="modal-register-label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="modal-register-label">Felicidades,</h4>
						<p>se completó el envío</p>
					</div>

					<div class="modal-body">
						<div class="js-modal d-flex align-items-center flex-column">
							<div class="modal-image mt-3">
								<svg viewBox="0 0 32 32" style="fill: #48DB71">
								<path d="M1 14 L5 10 L13 18 L27 4 L31 8 L13 26 z"></path></svg>
							</div>
							<h1 class="mt-2">Regalado!</h1>
							<p>Solo queda que el beneficiario lo canjee</p>
							<button class="btn btn-info w-50 mt-4 p-2 js-close"
								data-dismiss="modal">Volver</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<%@ include file="./layout/Footer.jsp"%>
</body>
</html>