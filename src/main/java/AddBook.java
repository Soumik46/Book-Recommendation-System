

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import utils.*;
/**
 * Servlet implementation class AddBook
 */
@MultipartConfig(maxFileSize=16177215) //upload file's size is upto 16mb
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		String user=request.getParameter("user");	
		String pass= request.getParameter("pass");
		System.out.println("From AddBook servlet");
		System.out.println(user);
		System.out.println(pass);
		String title=request.getParameter("book_title");
		String author=request.getParameter("book_author");
		String publication=request.getParameter("book_publication");
		String category=request.getParameter("book_category");
		System.out.println(title);
		System.out.println(author);
		System.out.println(publication);
		System.out.println(category);
		if(category.contentEquals("new category"))
		{
			category=request.getParameter("new_category_Name");
//			System.out.println("New category: "+Category);
		}
//		InputStream inputStream= null;
//		
//		String message= null;
//		//obtains the upload file part in this multipart request
//		Part filePart= request.getPart("pdf");
//		if(filePart!=null) {
//			//prints out information for debugging
//			System.out.println(filePart.getName());
//			System.out.println(filePart.getSize());
//			System.out.println(filePart.getContentType());
//			
//			//obtains input stream to upload file
//			inputStream= filePart.getInputStream();
//		}
		try {
			int ID= BookDAO.addBook(title,author,publication,category);
//			request.setAttribute("id", ID);
			if(Validate.isAdmin(user, pass))
			{
				request.setAttribute("user", user);
				request.setAttribute("pass", pass);
				RequestDispatcher dispatcher= request.getRequestDispatcher("BookShowServlet?id="+ID+"&user="+user+"&pass="+pass);
			dispatcher.forward(request, response);
			}
			else
			{
				out.println("Invalid user: Access Denied");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
