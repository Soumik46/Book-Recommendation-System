import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {

	public static Connection getConnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load and register
			String url=("jdbc:mysql://localhost:3306/fsp_project");
			String USER= "root";
			String PASS="system";
			con= DriverManager.getConnection(url,USER,PASS);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static boolean isAdmin(String user, String pass) 
	{
		boolean st=false;
		try{
		Connection con= getConnection();
		PreparedStatement ps=con.prepareStatement(
				"select * from admin where username=? and password=?");
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		st=rs.next();
	
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		return st;
}
	public static boolean isUser(String user, String pass) 
	{
		boolean st=false;
		try{
		
		Connection con= getConnection();
		PreparedStatement ps=con.prepareStatement(
				"select * from users where username=? and pass=?");
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		st=rs.next();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		return st;
}
}
