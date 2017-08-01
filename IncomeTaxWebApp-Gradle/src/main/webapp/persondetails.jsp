<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${error}</p>
	<form:form action="person.action" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input type="text" path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input type="text" path="lastName"/></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input type="text" path="age"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create"/></td> 
			</tr>
		</table>
	</form:form>
</body>
</html>