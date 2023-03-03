

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BookDAO;

import java.io.IOException;

/**
 * Servlet implementation class Download
 */
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
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
		String bookId= request.getParameter("bookId");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		System.out.println("From download servlet");
		System.out.println(user+" "+pass);
		boolean st=false;
		try {
		BookDAO.Download(bookId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
			RequestDispatcher dispatcher= request.getRequestDispatcher("BookShowServlet?id="+bookId);
			dispatcher.forward(request,response);
		
		
	}

}
