package utils;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;

public class BookDAO {
	public static Connection getConnection() throws Exception{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver"); // load and register
		String url=("jdbc:mysql://localhost:3306/demo");
		String USER= "root";
		String PASS="system";
		con= DriverManager.getConnection(url,USER,PASS);
		return con;
	}
	public static List<Book> getBooksRecommended ()throws Exception
	{
		List<Book> books= new ArrayList<Book>(4);
		int i=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from books_demo order by views DESC");
		ResultSet rs=ps.executeQuery();
		while(i<4 && rs.next())
		{
			Book bk= new Book();
			bk.setId(rs.getInt(1));
			bk.setTitle(rs.getString(2));
			bk.setPublication(rs.getString(3));
			bk.setAuthor(rs.getString(4));
			bk.setCategory(rs.getString(5));
			bk.setViews(rs.getInt(6));
			i++;
			books.add(bk);
		}
		return books;
	}
	public static List<Book> getBooksRecentlyAdded ()throws Exception
	{
		List<Book> books= new ArrayList<Book>(4);
		int i=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from books_demo order by date_added DESC");
		ResultSet rs=ps.executeQuery();
//		System.out.println(rs);
		while(i<3 && rs.next())
		{
			Book bk= new Book();
			bk.setId(rs.getInt(1));
			bk.setTitle(rs.getString(2));
			bk.setPublication(rs.getString(3));
			bk.setAuthor(rs.getString(4));
			bk.setCategory(rs.getString(5));
			bk.setViews(rs.getInt(6));
			i++;
			books.add(bk);
		}
		return books;
	}
	public static Book getBookDetails(String bookId) throws Exception{
		// TODO Auto-generated method stub
//		System.out.println(bookId);
		Book book= new Book();
		Connection con= getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("Select * from books_demo where book_id=?");
			ps.setString(1, bookId);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPublication(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setCategory(rs.getString(5));
				book.setViews(rs.getInt(6));
				book.setDate(rs.getDate(7));
//				Blob blob= rs.getBlob(8);
//				InputStream file= blob.getBinaryStream();
//				book.setFile(file);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	public static int addBook (String title, String author, String publication, String category) 
	throws Exception{
		// TODO Auto-generated method stub
		Book book=new Book();
		int id=-1;
		int row=0;
//		InputStream inputStream = new FileInputStream(new File(file));
		Connection con= getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("Insert into books_demo values(?,?,?,?,?,?,?)");
			// book_id int title string publication string
			//author string category string views int added_date date
			id=returnId();
			java.sql.Date date= getCurrentDate();
			ps.setInt(1,id );
			ps.setString(2, title);
			ps.setString(3, publication);
			ps.setString(4, author);
			ps.setString(5, category);
			ps.setInt(6, 0);
			ps.setDate(7, date);
//			System.out.println(ps);
			row=ps.executeUpdate();
			if(row>1)
				System.out.println("Added new book");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return id;
	}
	
private static java.sql.Date getCurrentDate() {
		// TODO Auto-generated method stub
	java.util.Date date= new java.util.Date();
	System.out.println(date);
	java.sql.Date sqlDate= new java.sql.Date(date.getTime());
		return sqlDate;
	}
public static int returnId() throws Exception {
	Connection con= getConnection();
	PreparedStatement ps=con.prepareStatement("Select max(book_id) from books_demo as max");
	ResultSet rs=ps.executeQuery();
	int id=0;
	if(rs.next())
	{
		
		id=rs.getInt(1);
		System.out.println(id);
	}
	return (id+1);
}
public static List<String> getAllCategories() throws Exception{
	List<String> categories= new ArrayList<String>();
	Connection con= getConnection();
	try {
	PreparedStatement ps=con.prepareStatement("SELECT book_category FROM books_demo group by book_category");
	ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		String category= rs.getString(1);
//		System.out.println(category);
		categories.add(category);
	}
	con.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return categories;
}
public static List<Book> getByCategoryRecommended(String category) throws Exception {
	// TODO Auto-generated method stub
	List<Book> books=new ArrayList<Book>();
	Connection con=getConnection();
//	System.out.println(category);
	int i=0;
	try {
	PreparedStatement ps=con.prepareStatement("Select * from books_demo where book_category=? order by views desc");
	ps.setString(1, category);
//	System.out.println(ps);
	ResultSet rs= ps.executeQuery();
	
	while(i<4 && rs.next())
	{
		Book book= new Book();

		book.setId(rs.getInt(1));
		book.setTitle(rs.getString(2));
		book.setPublication(rs.getString(3));
		book.setAuthor(rs.getString(4));
		book.setCategory(rs.getString(5));
		book.setViews(rs.getInt(6));
		book.setDate(rs.getDate(7));
		i++;
		books.add(book);
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	con.close();
//	System.out.println("Recommended: \n\n");
//	for(Book bk:books)
//	{
//		System.out.println(bk.getAuthor()+" \t" + bk.getTitle() + " \t" + bk.getCategory());
//	}
	return books;
}
public static List<Book> getByCategoryRecentlyAdded(String category) throws Exception {
	// TODO Auto-generated method stub
	List<Book> books=new ArrayList<Book>();
	Connection con=getConnection();
//	System.out.println(category);
	int i=0;
	try {
	PreparedStatement ps=con.prepareStatement("Select * from books_demo where book_category=? order by date_added desc");
	ps.setString(1, category);
//	System.out.println(ps);
	ResultSet rs= ps.executeQuery();
	
	while(i<4 && rs.next())
	{
		Book book= new Book();

		book.setId(rs.getInt(1));
		book.setTitle(rs.getString(2));
		book.setPublication(rs.getString(3));
		book.setAuthor(rs.getString(4));
		book.setCategory(rs.getString(5));
		book.setViews(rs.getInt(6));
		book.setDate(rs.getDate(7));
		i++;
		books.add(book);
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	con.close();
//	System.out.println("Recently added: \n\n");
//	for(Book bk:books)
//	{
//		System.out.println(bk.getAuthor()+" \t" + bk.getTitle() + " \t" + bk.getCategory());
//	}
	return books;
}
public static boolean Download(String bookId) throws Exception {
	Connection con=getConnection();
	boolean st= false;
	PreparedStatement ps=con.prepareStatement("Update books_demo set views=views+1 where book_id=?");
	ps.setString(1, bookId);
	st=ps.execute();
	return st;
}

}
