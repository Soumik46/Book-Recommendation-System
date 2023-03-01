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
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <header>
            <div class="align">
            <div class="title"><b>Book Recommendation</b></div>
            <div class="horizontal"> 
                <button type="submit">
                    Register
                </button>
            <div class="Filter">      
                <select name="Categories" id="">
                  <option value=""><b>Categories</b></option>
                  <option value="abc">abc</option>
                  <option value="def">def</option>
                  <option value="ghi">ghi</option>
              </select>
            </div>
                    <div class="Filter">
                    <select name="stream" id="">
                      <option value="">Select Writer</option>
                      <option value="abc">abc</option>
                      <option value="def">def</option>
                      <option value="ghi">ghi</option>
                  </select>
                </div>
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
                        <%
							List<Book> RecommendedBooks = BookDAO.getBooksRecommended();

							for (Book bk : RecommendedBooks) {
							%>
							<a href="BookShowServlet?id=<%=bk.getId()%>">
								<div class="top">
									<div class="in-div">
										<b><%=bk.getTitle()%></b>
									</div>
									<div class="in-div">
										Author:
										<%=bk.getAuthor()%></div>
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
								<a href="BookShowServlet?id=<%=bk.getId()%>">
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
    </form>
</body>

</html>