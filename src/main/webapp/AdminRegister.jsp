<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New Admin</title>
<meta charset="UTF-8">
    <link rel="stylesheet" href="styles/styleadmin1.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<% String user= (String)request.getAttribute("user");
String pass=(String) request.getAttribute("pass");
System.out.println("From AdminRegister jsp:");
System.out.println(user);
System.out.println(pass);%>
    <div class="container">
        <header>
            <div class="title"><b> <br>Create an admin Account</b></div>
        </header>
        <section>
            <div class="content">
                <form method="post" action="AdminServlet">
                    <div class="details">
                            <div class="input1">
                            <label for="Enter User ID">
                                <span class="details"><br><b>Enter Your Name:</b></span>
                            </label>
                            <input type="text" placeholder="Enter Your Name" name="name" id="Enter Your Name" required><br>
                        </div>
                        <div class="input1">
                            <label for="Enter Your Password">
                                <span class="details"><b> <br>Enter Your Phone no.:</b></span>
                            </label>
                            <input type="text" placeholder="Enter Your Phone no." name="phone" id=" Enter Your Phone no."
                                required><br>
                        </div>
                        <div class="input1">
                            <label for="Enter User ID">
                                <span class="details"><br><b>Enter Your E-mail:</b></span>
                            </label>
                            <input type="email" placeholder=" Enter Your E-mail" name="email" id="Enter Your E-mail" required><br>
                        </div>
                        <div class="input1">
                            <label for="Enter User ID">
                                <span class="details"><br><b>Create Password:</b></span>
                            </label>
                            <input type="password" placeholder="Password" name="password" id="Password" required><br>
                        </div>
                          <input type="hidden" value=<%=user %> name="user">
					<input type="hidden" value=<%=pass %> name="pass">
                        <div class="button">
                            <input type="submit"value="Submit">
                        </div>
                        <div class="Signup">
                        <!-- &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<a href>Create New Account/Signup</a href> -->
                        </div>
                    </div>
                    </form>
                    </div>
        </section>
    </div>
    
</body>
</html>