<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
			<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
			<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
			<form:form action="validar-login" method="POST"
				modelAttribute="usuario">
				<h3 class="form-signin-heading">Login</h3>
				<hr class="colorgraph">
				<br>

				<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
				<form:input path="email" id="email" type="email"
					placeholder="email@example.com" class="form-control" />
				<form:input path="password" type="password" id="password"
					placeholder="Contrase�a" class="form-control" />

				<button class="btn btn-lg btn-primary btn-block mb-2" Type="Submit" />Entrar</button>
					No estas registrado ?
					<a href="registrarse">Darse de alta</a>
			</form:form>

			<%--Bloque que es visible si el elemento error no está vacío	--%>
			<c:if test="${not empty error}">
				<h4>
					<span>${error}</span>
				</h4>
				<br>
			</c:if>
		</div>
	</div>
</body>
</html>
