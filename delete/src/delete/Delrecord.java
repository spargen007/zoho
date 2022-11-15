package delete;
import java.sql.*;
public class Delrecord {
	static final String url = "jdbc:mysql://localhost/School";
    static final String user = "root";
	static final String pass = "Spargen007";
	public static void main(String args[])throws Exception{
		try {
		Connection co = DriverManager.getConnection(url,user,pass);
		Statement stmt =co.createStatement();
		String sql="DELETE FROM Students"+" WHERE Regno=4;";
		stmt.executeUpdate(sql);
		sql="SELECT * FROM Students";
		ResultSet r=stmt.executeQuery(sql);
		while(r.next()) {
            System.out.print("Regno: " + r.getInt("Regno")+"\n");
            System.out.print("Name: " + r.getString("Name")+"\n");
            System.out.print("dob: "+r.getDate("DOB")+"\n");
            System.out.print("Age: " + r.getInt("AGE")+"\n");
            System.out.print("Gender: " + r.getString("Gender")+"\n");
            System.out.println("phone: "+r.getString("Phone")+"\n");
            System.out.println();
		}
		System.out.println("deleted sucessfully");
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	}


