<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Categoria</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/Style.css" rel="stylesheet">
		<script src="js/jquery-3.5.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
	<%@ include file="./layout/Header.jsp"%>
	<body>
		<div class="container mr-5">
			<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">			
				<form:form action="crear-categoria" method="POST" modelAttribute="categoria">
					<h3 class="form-signin-heading">Categoria</h3>
					<hr class="colorgraph">
					<br>
					<form:input path="tipo" id="tipo" type="text"  placeholder="tipo" class="form-control m-5" />
					<br>
					<button class="btn btn-lg btn-primary btn-block m-5" Type="Submit" />Crear</button>
				</form:form>
			</div>
		</div>
	</body>
	<%@ include file="./layout/Footer.jsp"%>
</html>