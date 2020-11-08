<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil</title>
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
									<h4>${USERNAME}</h4>
									<p class="text-secondary mb-1">Usuario</p>
									<p class="text-muted font-size-sm">${EMAIL}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Nombre</h6>
								</div>
								<div class="col-sm-9 text-secondary">${USERNAME}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Apellido</h6>
								</div>
								<div class="col-sm-9 text-secondary">${SURNAME}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">${EMAIL}</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h6 class="mb-0">Miembro desde</h6>
								</div>
								<div class="col-sm-9 text-secondary">${REGISTERDATE}</div>
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
									<ul>
										<li>Fotografía</li>
										<li>Impresión 3D</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="./layout/Footer.jsp"%>

	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>