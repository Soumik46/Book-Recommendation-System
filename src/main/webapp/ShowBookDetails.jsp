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
<% String user= (String)request.getAttribute("user");
String pass=(String) request.getAttribute("pass");
System.out.println("From show book details jsp:");
System.out.println(user);
System.out.println(pass);%>
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
                            <br><br>
		 					<p>Downloads: <%=book.getViews() %> </p>
                    </div>
                    
                    <form action="Download" method="post">
                    <input type="hidden" value=<%=user %> name="user">
							<input type="hidden" value=<%=pass %> name="pass">
                    <input type="hidden" value=<%=book.getId()%> name="bookId">
                    <div class="download">
                    <button type="submit"  class="button">
                        Download
                    </button>
                	</div>
                    </form>
                    
        </section>
  <form action="BackToDashboard" method="post"><input type="hidden" value=<%=user %> name="user">
							<input type="hidden" value=<%=pass %> name="pass">
							<input type="submit" value="Back"> </form>
    </div>
</body>
</html>