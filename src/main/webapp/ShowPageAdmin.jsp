<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="utils.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/styleadminview.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin's Dashboard</title>
</head>
<body>
<% String user= (String)request.getAttribute("user");
String pass=(String) request.getAttribute("pass");
System.out.println("From show page admin jsp:");
System.out.println(user);
System.out.println(pass);%>
    <div class="container">
        <header>
            <div class="align">
            <div class="title"><b>Book Recommendation</b></div>
           <div class="horizontal">
           <form action="AdminRegister" method="post">
           <input type="hidden" value=<%=user %> name="user">
			<input type="hidden" value=<%=pass %> name="pass">
           <button type="submit">          
                    Register
                </button>
                </form>
           <form action="UploadNewBook" method="post">
           <input type="hidden" value=<%=user %> name="user">
			<input type="hidden" value=<%=pass %> name="pass">
           <button type="submit">          
                    Add New Book
                </button>
                </form>
					<div class="Filter">
					<form action="ShowByCategory" method="post">
					
						<select name="Categories" id="" onchange='this.form.submit()'>
							<option selected disabled><b>Categories</b></option>
							<%List<String> categories= BookDAO.getAllCategories();
							for(String category:categories){%>
							<option value="<%=category%>"><b><%=category%></b></option>
							<%} %>
						</select>
						</form>
					</div>
				</div>
        </header>
                 
        <section>
            <div class="content">
                <form action="#">
                    <div class="details">
                        <div class="input1">
                            <label for="Recommended">
                                <span class="details"><br><b>Top Recommended Books</b></span>
                            </label>
                             <div class="home-content">

                        </div>
                        
							<form id="form" action="BookShowServlet" method="post">
							<input type="hidden" value=<%=user %> name="user">
							<input type="hidden" value=<%=pass %> name="pass">
							</form>
							
                        <%
							List<Book> RecommendedBooks = BookDAO.getBooksRecommended();

							for (Book bk : RecommendedBooks) {
							%>
							<a id="auto-submit" href="BookShowServlet?id=<%=bk.getId()%>&user=<%=user%>&pass=<%=pass %>" )>
							<!--  form daal autosubmit -->
							
								<div class="top" >
								
									<div class="in-div">
										<b><%=bk.getTitle()%></b>
									</div>
									<div class="in-div">
										Author:
										<%=bk.getAuthor()%>
										</div>
									</div>	
							
							</a> <br>
							<%
							}
							%>
                        <div class="input1">
                            <label for="Recently Added">
                                <span class="details"><b> <br>Recently Added</b></span>
                            </label>
                        <%
								List<Book> RecentBooks = BookDAO.getBooksRecentlyAdded();
								for (Book bk : RecentBooks) {
								%>
								<a id="auto-submit" href="BookShowServlet?id=<%=bk.getId()%>&user=<%=user%>&pass=<%=pass %>" )>
								<div class="top">
									<div class="in-div">
										<b><%=bk.getTitle()%></b>
									</div>
									<div class="in-div">
										Author:
										<%=bk.getAuthor()%></div>


								</div>
								</a>
								<br>
								<%
								}
								%>
                        
                    </div>
                    </div>
        </section>

    </div>
    <script>
    function submitForm()
    {
    	
    	console.log("Reached function");
    	form= getElementById("form");
    	form.submit();
    }
    </script>
</body>

</html>