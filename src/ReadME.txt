welcome page:index.html
index.html submits to Login.java(servlet)
Create tag on index.html redirects to RegisterUser.jsp
Login servlet calls 
1. ShowPageAdmin.java if admin login
2. ShowPageUser.java if user login
3.Invalid.jsp if not valid user

ShowPageAdmin calls ShowPageAdmin.jsp
Register Button on ShowPageAdmin submits to AdminRegister.java servlet
Add New Book button on ShowPageAdmin submits to UploadNewBook.java servlet
Select category submits to ShowByCategory

a tag hyperlink redirects to BookShowServlet.java Servlet

AdminRegister invokes AdminRegister.jsp (form page)
Form on AdminRegister.jspp submits to AdminServlet

AdminServlet calls ViewResult.jsp if successfully entered
ViewResult.jsp button Back to Dashboard submits to Login Servlet

UploadNewBook calls UploadNewBook.jsp or Invalid.jsp if user!= admin
UploadNEwBook.jsp form submits to AddBook.java Servlet
AddBook.java makes the new entry and calls BookShowServlet with the details of the new book

BookShowServlet invokes ShowBookDetails.jsp with details of the book