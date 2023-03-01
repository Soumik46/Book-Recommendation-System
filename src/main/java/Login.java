

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String user=request.getParameter("userID");
		String pass= request.getParameter("pass");
		String address = null;
		if(Validate.isAdmin(user,pass))
		{
			
//			admin	admin
//			out.println("<h1>Welcome Admin"+ ;user+ "</h1>" );
//			address="welcomeAdmin.jsp";
			address="adminview.html";
			request.setAttribute("user", user);
		}
		else if(Validate.isUser(user,pass))
		{
//			user user
//			out.println("<h1>Welcome User "+ user+ "</h1>" );
//			address="welcomeUser.jsp";
			address="ShowPageUser";
			request.setAttribute("user", user);
		}
		else
		{
			address="invalid.jsp";
			request.setAttribute("user", user);
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
