<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coming from hello.jsp</title>
</head>
<body>
	<ul>
		<li>Current Time : <%= new java.util.Date() %></li>
		<li>Server: <%= application.getServerInfo() %></li>
		<li>Session: <%= session.getId() %></li>
		<li>Hello <%= request.getParameter("name") %>
		<li>Roles <%
			String[] roles = request.
				getParameterValues("role");
			for(int i=0;i<roles.length;i++){
				out.println(roles[i] + "<br>");
			}
		%>
	</ul>
</body>
</html>