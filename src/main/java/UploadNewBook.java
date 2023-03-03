

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UploadNewBook
 */
public class UploadNewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadNewBook() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		String user=request.getParameter("user");	
		String pass= request.getParameter("pass");
		System.out.println("From UploadNewBook servlet");
		System.out.println(user);
		System.out.println(pass);
		
		if(Validate.isAdmin(user, pass))
		{
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
			RequestDispatcher dispatcher= request.getRequestDispatcher("UploadNewBook.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher= request.getRequestDispatcher("invalid.jsp");
			dispatcher.forward(request, response);
		}
			
	}

}
