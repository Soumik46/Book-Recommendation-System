

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import utils.*;
/**
 * Servlet implementation class ShowPageUser
 */
public class ShowPageUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPageUser() {
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
		try {
			List<Book> books= BookDAO.getBooksRecommended();
//			System.out.println(books);
			request.setAttribute("books", books);
			String user= (String) request.getAttribute("user");
			String pass= (String) request.getAttribute("pass");
			request.setAttribute("user", user);
			request.setAttribute("password", pass);
			System.out.println("Show page user servlet \n");
			System.out.println(user);
			System.out.println(pass);
			if(Validate.isUser(user,pass))
			{
				RequestDispatcher dispatcher= request.getRequestDispatcher("ShowPageUser.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				out.println("Invalid user: Access Denied");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
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
