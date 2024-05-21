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
	</table>
</body>
</html>