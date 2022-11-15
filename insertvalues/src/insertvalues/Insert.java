package insertvalues;
import java.sql.*;
public class Insert {
	static final String url = "jdbc:mysql://localhost/School";
    static final String user = "root";
	static final String pass = "Spargen007";
	public static void main(String args[])throws Exception{
		try {
			Connection con =DriverManager.getConnection(url,user,pass);
			Statement stmt =con.createStatement();
			System.out.println("inserting records into students table!......");
			String sql="INSERT INTO Students VALUES (1, 'Zara', '2009-05-01', 18,'Female',9876534229)";
			stmt.executeUpdate(sql);
			sql="INSERT INTO Students VALUES (2, 'Jack', '2007-08-01', 20,'Male',9236534345)";
			stmt.executeUpdate(sql);
			sql="INSERT INTO Students VALUES (3, 'Aravindh', '2005-07-22', 22,'Male',7876534329)";
			stmt.executeUpdate(sql);
		    sql="INSERT INTO Students VALUES (4, 'thulasi', '2009-05-06', 18,'Female',8876534229)";
			stmt.executeUpdate(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
