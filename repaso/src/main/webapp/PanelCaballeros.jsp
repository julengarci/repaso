<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>	

	<c:if test="${validacion == true}">
	    <div class="alert alert-success alert-dismissable mx-4" role="alert">
	       insertado
	        <button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>
	
	<table>
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">nombre</th>
                <th scope="col">fuerza</th>
                <th scope="col">experiencia</th>
                <th scope="col">foto</th>
                <th scope="col">arma</th>
                <th scope="col">escudo</th>
             </tr>
         </thead>
         <tbody>
             <c:forEach items="${caballeros}" var="caballero" >
                 <tr>
                     <td>${caballero.id}</td>
                     <td>${caballero.nombre}</td>
                     <td>${caballero.fuerza}</td>
                     <td>${caballero.experiencia}</td>
                     <td>${caballero.foto}</td>
                     <td>${caballero.arma.nombre}</td>
                     <td>${caballero.escudo.nombre}</td>
                 </tr>
             </c:forEach>
		</tbody>
		<a href="InsertCaballero">insertar caballero</a>
		<form method="post">
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">busqueda</label>
		    <input type="text" class="form-control" id="busqueda" name="busqueda" >
		  </div>
		   <button type="submit" class="btn btn-primary">Buscar</button>
		 </form>
	</table>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
</body>
</html>