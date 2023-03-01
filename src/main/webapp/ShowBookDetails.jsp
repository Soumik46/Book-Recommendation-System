<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="utils.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <link rel="stylesheet" href="styles/stylebookview.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Details</title>
</head>
<body>
<%
Book book= (Book)request.getAttribute("book");
%>
    <div class="container">
        <header>
            <div class="title"><b><br>Book Title :<%=book.getTitle() %> </b></div>
        </header>
        <br>
        <br>
        <section>
            <div class="content">
                    <div class="details">
                     <b> Author:</b>
                    <div class="author">
                           <h3><%=book.getAuthor() %></h3> 
                    </div>
                    <br>
                    <b> Publication:</b>
                    <div class="publication">
                            <h4><%=book.getPublication() %></h4>
                    </div>
                    <br>
                    <b> More Details</b>
                    <div class="desc">
                            <p>Added on: <%=book.getDate() %></p> 
		 					<p>Viewed <%=book.getViews() %> times </p>
                    </div>

        </section>

    </div>
</body>
</html>