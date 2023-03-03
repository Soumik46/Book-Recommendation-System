<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%-- <%@page import="net.javaguides.employeemanagement.dao.*"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Complete</title>
</head>
<body>
<% String user= (String)request.getAttribute("user");
String pass=(String) request.getAttribute("pass");
String newAdmin= (String)request.getAttribute("newAdmin");
System.out.println("From ViewResult jsp:");
System.out.println(user);
System.out.println(pass);%>
 <h1>New Admin <%=newAdmin %> successfully registered!</h1>
<form action="Login" method="post">
	<input type="hidden" value=<%=user %> name="userID">
	<input type="hidden" value=<%=pass %> name="pass">
	<input type="submit" value="Back to dashboard">;
</form>
</body>
</html>