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
                <th scope="col">capacidad_danio</th>
                <th scope="col">foto</th>
             </tr>
         </thead>
         <tbody>
             <c:forEach items="${armas}" var="arma" >
                 <tr>
                     <td>${arma.id}</td>
                     <td>${arma.nombre}</td>
                     <td>${arma.capacidad_danio}</td>
                     <td>${arma.foto}</td>
                 </tr>
             </c:forEach>
		</tbody>
	</table>
</body>
</html>