

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import utils.*
;/**
 * Servlet implementation class BookShowServlet
 */
public class BookShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");	
		String pass= request.getParameter("pass");
		System.out.println("From BookShow servlet");
		System.out.println(user);
		System.out.println(pass);
		String bookId=request.getParameter("id");
		System.out.println("Book id: "+bookId);
		if(Validate.isAdmin(user, pass) || Validate.isUser(user, pass))
		{
			try {
		Book book= BookDAO.getBookDetails(bookId);
		request.setAttribute("book", book);
		request.setAttribute("user", user);
		request.setAttribute("pass", pass);
		RequestDispatcher dispatcher= request.getRequestDispatcher("ShowBookDetails.jsp");
		dispatcher.forward(request, response);
		
	}catch(Exception e) {
		e.printStackTrace();
		}
			
		
	}
		else
		{
			out.println("Invalid user: Access Denied");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
