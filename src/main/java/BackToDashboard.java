

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BackToDashboard
 */
public class BackToDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackToDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");	
		String pass= request.getParameter("pass");
		System.out.println("From Back servlet");
		System.out.println(user);
		System.out.println(pass);
		String address="";
		if(Validate.isAdmin(user, pass))
		{
			address="ShowPageAdmin";
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
		}
		else if(Validate.isUser(user, pass)) {
			address="ShowPageUser";
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
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
