<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
<style type="text/css">
	.errors{
		color:red;
		font-family: Calibri;
		font-style: italic;
	}
</style>
</head>
<body>
<center>
<h1>UPDATE USER</h1>
	<form:form action="updateUser" method="POST" modelAttribute="user">
		<form:hidden path="id"/>
		Enter phone: <form:input path="phone"/><form:errors path="phone" class="errors"/><br/><br/>
		Enter address: <form:input path="address"/><form:errors path="address" class="errors"/><br/><br/>
		Enter roles: <form:select path="roles" items="${roles }"/><form:errors path="roles" class="errors"/><br/><br/>
		Enter active: <form:radiobuttons path="active" items="${active }"/><form:errors path="active" class="errors"/><br/><br/>
		<center>
		<input type="submit"/>
		</center>
	</form:form>
</center>
</body>
</html>