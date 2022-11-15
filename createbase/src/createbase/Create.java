package createbase;
import java.sql.*;
public class Create {
	static final String url = "jdbc:mysql://localhost/";
    static final String user = "root";
	static final String pass = "Spargen007";

	   public static void main(String[] args) {
	      try {
	    	  Connection conn = DriverManager.getConnection(url, user, pass);
		      Statement stmt = conn.createStatement();		      
	         String sql = "CREATE DATABASE School";
	         stmt.executeUpdate(sql);
	         System.out.println("Database created successfully...");   	  
	      } catch (SQLException e) {
	         System.out.println("error occured");
	      } 
	   }
	}
