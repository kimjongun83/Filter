<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN FORM</h1>
	<%
		if(request.getAttribute("message") != null){
	%>
		<label><%= request.getAttribute("message") %></label>
	<%	
		}
	%>
	<form action='<%= request.getContextPath() %>/login' method='POST'>
	<label>Username</label> <br>
	<input type='text' name='username' value='<%= request.getParameter("username") %>'  /> <br>
	<label>Password</label> <br>
	<input type='password' name='password' value='<%= request.getParameter("password") %>' /> <br>
	<input type='submit' value='LOGIN'  /> <br>
	</form>
</body>
</html>