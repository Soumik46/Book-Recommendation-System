

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.Book;
import utils.BookDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ShowByCategory
 */
public class ShowByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowByCategory() {
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
//		PrintWriter out=response.getWriter();
//		out.println("Showing by category");
		String category=request.getParameter("Categories");
			try {
				List<Book> booksRecommended=BookDAO.getByCategoryRecommended(category);
				List<Book> booksRecentlyAdded=BookDAO.getByCategoryRecentlyAdded(category);
				//show by category page needed
//				System.out.println(booksRecommended);
//				System.out.println("\n\nRecommended: \n\n");
//				for(Book bk:booksRecommended)
//				{
//					System.out.println(bk.getAuthor()+" \t" + bk.getTitle() + " \t" + bk.getCategory());
//				}
//				System.out.println("\n\n\n");
//				System.out.println(booksRecentlyAdded);
//				System.out.println("Recently added: \n\n");
//				for(Book bk:booksRecentlyAdded)
//				{
//					System.out.println(bk.getAuthor()+" \t" + bk.getTitle() + " \t" + bk.getCategory());
//				}
				request.setAttribute("booksRecommended",booksRecommended);
				request.setAttribute("booksRecent",booksRecentlyAdded);
				request.setAttribute("category", category);
				if(!category.equalsIgnoreCase("all"))
				{
				RequestDispatcher dispatch=request.getRequestDispatcher("ShowByCategory.jsp");
				dispatch.forward(request,response);
				}
				else
				{
					RequestDispatcher dispatch= request.getRequestDispatcher("ShowPageUser");
					dispatch.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}


