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

	<c:if test="${validacion == false}">
	    <div class="alert alert-danger alert-dismissable mx-4" role="alert">
	       no se ha podido insertar
	        <button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	</c:if>

	<form action="InsertCaballero" method="POST">
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">nombre</label>
	    <input type="text" class="form-control" id="nombre" name="nombre">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">fuerza</label>
	    <input type="text" class="form-control" id="fuerza" name="fuerza">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">experiencia</label>
	    <input type="text" class="form-control" id="experiencia" name="experiencia">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">foto</label>
	    <input type="text" class="form-control" id="foto" name="foto">
	  </div>
	  <div class="mb-3">
          <label class="form-label">arma:</label> 
          <select class="form-select" id="arma" name="arma">
              <option value="arma">arma</option>
              <c:forEach items="${armas}" var="arma">
                  <option value="${arma.id}"> ${arma.nombre}</option>
              </c:forEach>
          </select>
      </div>
	  <div class="mb-3">
          <label class="form-label">escudo:</label> 
          <select class="form-select" id="escudo" name="escudo">
              <option value="escudo">escudo</option>
              <c:forEach items="${escudos}" var="escudo">
                  <option value="${escudo.id}"> ${escudo.nombre}</option>
              </c:forEach>
          </select>
      </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	

</body>
</html>