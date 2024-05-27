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

<p>${caballero1}</p>

<form method="get" action="Lucha">
	<c:forEach items="${caballeros}" var="caballero">
	    <div class="form-check">
	        <input class="form-check-input" type="radio" id="caballero${caballero.id}" name="caballero" value="${caballero.id}">
	        <label class="form-check-label" for="caballero${caballero.id}">
	            ${caballero.nombre} <!-- Asumiendo que 'caballero' tiene una propiedad 'nombre' -->
	        </label>
	    </div>
	</c:forEach>
	<button type="submit">seleccionar</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>