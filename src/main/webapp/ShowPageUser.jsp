<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="utils.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/styleuserview.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="align">
				<div class="title">
					<b>Book Recommendation</b>
				</div>
				<div class="horizontal">
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
					<!--  <div class="Filter">
						<select name="stream" id="">
							<option value="">Select Author</option>
							<option value="2020-2024">abc</option>
							<option value="2019-2023">def</option>
							<option value="2021-2025">ghi</option>
						</select>
					</div> -->
				</div>
			</div>
		</header>

		<section>
			<div class="content">
				<form action="#">
					<div class="details">
						<div class="input1">
							<label for="Recommended"> <span class="details"><br>
								<b>Top Recommended Books</b></span>
							</label>
							<div class="home-content"></div>
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
								<label for="Recently Added"> <span class="details"><b>
											<br>Recently Added
									</b></span>
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