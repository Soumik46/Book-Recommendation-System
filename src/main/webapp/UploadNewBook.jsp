<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="utils.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/styleupload.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Upload New Book</title>
</head>
<body>
<% String user= (String)request.getAttribute("user");
String pass=(String) request.getAttribute("pass");
System.out.println("From UploadNewBook jsp:");
System.out.println(user);
System.out.println(pass);%>
<div class="container">
        <header>
            <div class="title"><b> <br>Upload File</b></div>
        </header>
        <section>
            <div class="content">
                <form action="AddBook" method="post" >
                 <input type="hidden" value=<%=user %> name="user">
			<input type="hidden" value=<%=pass %> name="pass">
                    <div class="details">
                          
                         <div class="Filter">
                                <select name="book_category" id="" onchange="yesnoCheck(this)" required>
                                  <option selected disabled><b>Categories</b></option>
							<%List<String> categories= BookDAO.getAllCategories();
							for(String category:categories){%>
							<option value="<%=category%>"><b><%=category%></b></option>
							<%} %>
                                  <option value="new category"><b>New category</b></option>
                              </select>
                            </div>
                        <div class="input1" id="ifNew" style="display:none">
                            <label for="Category Name">
                                <span class="details"><br><b>Category Name</b></span>
                            </label>
                            <input type="text" placeholder="Category Name" id="Category Name" name="new_category_Name" ><br>
                        </div>
                        <div class="input1">
                            <label for="Book Title">
                                <span class="details"><br><b>Book Title</b></span>
                            </label>
                            <input type="text" placeholder="Book Title" id="Book Title" name="book_title" required><br>
                        </div>
                        <div class="input1">
                            <label for="Book Author">
                                <span class="details"><b> <br>Book Author</b></span>
                            </label>
                            <input type="text" placeholder="Book Author" id="Book Author" name="book_author"
                                required><br>
                        </div>
                        <div class="input1">
                            <label for="Book Publication">
                                <span class="details"><b> <br>Book Publication</b></span>
                            </label>
                            <input type="text" placeholder="Book Publication" id="Book Publication" name="book_publication"
                                required><br>
                        </div>
                        
             
                        <div class="button">
                            <input type="submit"value="Upload">
                        </div>
                    </div>
        		</form>
        		</div></section>

    				
    
    <script>
function yesnoCheck(that) {
    if (that.value == "new category") {
  //alert("check");
        document.getElementById("ifNew").style.display = "block";
        document.getElementById("ifNew").setAttribute('required','true');
    } else {
        document.getElementById("ifNew").style.display = "none";
    }
}
</script>
</body>
</html>