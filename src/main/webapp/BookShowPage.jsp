<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="utils.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Book book= (Book)request.getAttribute("book");
%>
		<h1>Book Title:<%=book.getTitle() %></h1>
		<h5>Author(s):<%=book.getAuthor() %></h5>
		<h6>Publication:<%=book.getPublication() %></h6>
		
		
		
		 <p>Added on: <%=book.getDate() %></p> 
		 <p>Viewed <%=book.getViews() %> times </p>
</body>
</html>