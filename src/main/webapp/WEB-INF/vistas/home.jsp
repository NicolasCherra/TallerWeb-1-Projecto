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
			<c:forEach items="${categorias}" var="categoria">
				<div class="card">
					<div class="card-img">
						<img src="${categoria.imagen}"
							class="card-img-top img-fluid">
					</div>
					<div class="card-body">
						<h5 class="card-title">${categoria.tipo}</h5>
						<p class="card-text">${categoria.descripcion}</p>
					</div>
					<div class="card-footer">
						<a href="categorias" class="btn btn-primary w-100">Ver más</a>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

<%@ include file="./layout/Footer.jsp"%>

	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
