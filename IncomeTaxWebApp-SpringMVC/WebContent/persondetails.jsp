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
	<form action="person" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name"/></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create"/></td> 
			</tr>
		</table>
	</form>
</body>
</html>