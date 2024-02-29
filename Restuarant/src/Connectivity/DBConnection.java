package Connectivity;
import java.sql.*; 
public class DBConnection {

	public static Connection getConnection() 
	{

		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url="jdbc:mysql://localhost:3306/Food";

		try 
		{
			conn= DriverManager.getConnection(url,"root","Yaswanth@2003");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return conn;
	}

}

