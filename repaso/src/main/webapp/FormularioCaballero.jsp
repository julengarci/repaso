<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
          <select class="form-select" id="arma" name="arma" required>
              <option value="" selected disabled>arma</option>
              <c:forEach items="${armas}" var="arma">
                  <option value="${arma.id}"> ${arma.nombre}</option>
              </c:forEach>
          </select>
      </div>
	  <div class="mb-3">
          <label class="form-label">escudo:</label> 
          <select class="form-select" id="escudo" name="escudo" required>
              <option value="" selected disabled>escudo</option>
              <c:forEach items="${escudos}" var="escudo">
                  <option value="${escudo.id}"> ${escudo.nombre}</option>
              </c:forEach>
          </select>
      </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>