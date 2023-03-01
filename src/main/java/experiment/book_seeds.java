package experiment;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.text.*;
public class book_seeds {
	
	public static Connection getConnection() throws Exception {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver"); // load and register
		String url=("jdbc:mysql://localhost:3306/demo");
		String USER= "root";
		String PASS="system";
		con= DriverManager.getConnection(url,USER,PASS);
		return con;
	}
	public static String getBookTitle(int i) {
		String[] titles= new String[] 
				{"The Name of the Wind",
				"It",
				"The Green Mile",
				"Dune",
				"The Hobbit",
				"Eragon",
				"A Wise Mans Fear",
				"Harry Potter and the Philosophers Stone",
				"Hard Boiled Wonderland and The End of the World",
				"The Giving Tree"};
		
		return titles[i];
	}
	public static String getBookPublication(int i) {
		String[] publications= new String[] 
				{"DAW Books",
				"Viking",
				"Signet Books",
				"Chilton Books",
				"George Allen & Unwin"
				,"Alfred A. Knopf",
				"DAW Books","Bloomsbury",
				"Shinchosa",
				"Harper and Row"};
		
		return publications[i];
	}
	public static String getAuthor()
	{
		String[] authors= new String[] {"John Wick", "Adolf Bitler","Cristiano Siuuuu","Ankara Messi"};
		int max= authors.length;
		int i=(int) (Math.random()*max);
		return authors[i];
	}
	
	public static String getCategory() {
		String[] categories = new String[] {"abc","mnop","xyz","kmn"};
		int max= categories.length;
		int i=(int)(Math.random()*max);
		return categories[i];
	}
	public static int getViews()
	{
		int i=(int)(Math.random()*100);
		return i;
	}
	public static java.sql.Date getDate() throws Exception{
		String[] dates={"2022/10/13","2022/08/27","2023/01/29","2022/12/30"};
		int i=(int)(Math.random()*dates.length);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date parsed = format.parse(dates[i]);
        java.sql.Date date= new java.sql.Date(parsed.getTime());
        System.out.println(date);
		return date;
	}
	public static void SeedData() throws Exception{
		int result=0,total=0;
		int i=0;
		Connection con= getConnection();
		while(i<10)
		{
			PreparedStatement ps= con.prepareStatement("Insert into books_demo values (?,?,?,?,?,?)");
			ps.setInt(1, i);
			ps.setString(2, getBookTitle(i));
			ps.setString(3, getBookPublication(i));
			ps.setString(4, getAuthor());
			ps.setString(5, getCategory());
			ps.setInt(6, getViews());
			System.out.println(ps);
			result= ps.executeUpdate();
			if(result==1) {
				total++;
			}
			i++;
		}
		System.out.println("No of data entered: "+total );
	}
	
	public static boolean Delete() throws Exception
	{
		boolean st=false;
		Connection con= getConnection();
		
			PreparedStatement ps=con.prepareStatement("Delete from books_demo");
			st=ps.execute();
			return st;
	}
	public static void Update() throws Exception{
		boolean st=false;
		Connection con= getConnection();
		int i=0;
		while(i<10) {
			PreparedStatement ps=con.prepareStatement("Update books_demo set date_added=? where book_id=?");
			ps.setDate(1, getDate());
			ps.setInt(2, i);
			System.out.println(ps);
			st=ps.execute();
			i++;
			System.out.println(st);
		}
		
	}
	public static void returnId() throws Exception
	{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select max(book_id) from books_demo as max");
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println(rs.getInt(1));
		}
		
	}
	public static void AddPDF() throws Exception{
		String filePath = "C:/Users/Soumik/Desktop/html pages/Dummy pdf.pdf";
		InputStream inputStream = new FileInputStream(new File(filePath));
		System.out.println(inputStream);
		Connection con=getConnection();
		for(int i=0;i<=10;i++) {
		PreparedStatement ps=con.prepareStatement("update books_demo set book_pdf=? where book_id=?");
		ps.setBlob(1, inputStream);
		ps.setInt(2, i);
		int row=ps.executeUpdate();
		if(row>0)
		{
			System.out.println("File was added for book_id:"+i);
		}
	}
	}
	public static void main(String args[]) throws Exception{
		
//		SeedData();
//		Delete();
//		Update();
		returnId();
//		AddPDF();
	}
	
}
