<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Hello, welcome to JSP ${ name }
	<hr />
	<ul>
		<c:forEach items="${doctorList}" var="doctor">
			<li><c:out value="${doctor.name}"></c:out></li>
		</c:forEach>
	</ul>

	<form:form action="createDoctor" method="POST" modelAttribute="doctor">

		Name : <form:input path="name" /> 
		Speciality : <form:input type="text" path="speciality" />  
		Degree : <form:input type="text" path="degree" />

		<button type="submit">Add Doctor</button>

	</form:form>

</body>
</html>