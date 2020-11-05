<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>One Gift | Home</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Style.css" rel="stylesheet">
<link href="css/stylecajaexp.css" rel="stylesheet">
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
					<div class="card-footer d-inline">
						<a class="btn btn-danger w-50" data-toggle="modal" data-target="#myModal">Regalar</a>
						<a class="btn btn-info w-50" onclick="mostrar()">ver dentro</a>
					</div>
				</div>
		</div>
	</div>
	
	<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <br>
        </div>
          <h4 class="modal-title">Hacer regalo</h4>
        <div class="modal-body">
          <p></p>
          <form:form  method="POST" action="hacerRegalo" modelAttribute="RegaloForm" class="form-inline"> 
          	<form:input path="email" placeholder="email del destinatario"/>
          	<form:hidden path="idRegalador" value="${IDUSUARIO}"/>
          	<form:hidden path="numeroCajaDeRegalo" value="${caja.numeroDeCaja}"/>
          	<form:button type="submit" class="btn btn-default">Enviar</form:button>
		  </form:form >
        </div>
        <div class="modal-footer">
        </div>
      </div>
      
    </div>
  </div>
	
	
	<hr>
		
	<div class="container-fluid contenedor text-center" id = "experiencias">
   		<h1 class="text-center" >Experiencias de la caja </h1><h1 style= "color:#ff00d0">${caja.nombre}</h1>
   		<div class=" container-fluid d-flex row justify-content-center text-center">
			
			<c:forEach items="${experiencias }" var="experiencia">	
      		<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 m-2 container_foto ">
       			
       				<article class="text-left">
            			<h2>${experiencia.nombre }</h2>
            			<h4>${experiencia.descripcion }</h4>
         			</article>
         			<img src="${experiencia.imagen}" alt="">		      		
     	 	</div>	
       		</c:forEach>
       		
   		</div>
	</div>
	
<%@ include file="./layout/Footer.jsp"%>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/experiencias.js"></script>
</body>
</html>
