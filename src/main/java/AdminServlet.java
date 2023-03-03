
import java.io.IOException;

import utils.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import net.javaguides.employeemanagement.dao.EmployeeDao;
//import net.javaguides.employeemanagement.model.Employee;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    private AdminDao adminDao= new AdminDao();

//    public void init() {
//        AdminDao = new AdminDao();
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       

        Admin admin = new Admin();
        admin.setName(name);
        admin.setPhone(phone);
        admin.setEmail(email);
        admin.setPassword(password);
       int res=0;
        
       String user=request.getParameter("user");	
		String pass= request.getParameter("pass");
		System.out.println("From AdminServlet");
		System.out.println(user+" "+pass);
		if(Validate.isAdmin(user, pass)) {
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
			try {
            res=AdminDao.registerAdmin(admin);
			} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
			}
			if(res>0) {
				request.setAttribute("user", user);
				request.setAttribute("pass", pass);
				request.setAttribute("newAdmin", name);
				RequestDispatcher dispatcher= request.getRequestDispatcher("ViewResult.jsp");
				dispatcher.forward(request, response);
			}
    }
}
}