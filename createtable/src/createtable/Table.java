package createtable;
import java.sql.*;
public class Table {
	static final String url = "jdbc:mysql://localhost/School";
    static final String user = "root";
	static final String pass = "Spargen007";
	public static void main(String args[])throws Exception {
		try {
		Connection co = DriverManager.getConnection(url,user,pass);
		Statement stmt =co.createStatement();
		String sql="CREATE TABLE Students"+
		" (Regno INT(11) NOT NULL,\n"
		+ "  Name VARCHAR(50) NOT NULL,\n"
		+ "  DOB DATE DEFAULT NULL,\n"
		+ "  AGE INT(3)DEFAULT NULL,\n "
		+ "  Gender VARCHAR(15) DEFAULT NULL,\n"
		+ "  Phone VARCHAR(13) DEFAULT NULL,\n"
		+ "  PRIMARY KEY (Regno))";
		stmt.executeUpdate(sql);
		System.out.println("created table sucessfully");
	}
		catch(Exception e) {
			System.out.println("error occured!");
		}
		
		
		
	}

}
