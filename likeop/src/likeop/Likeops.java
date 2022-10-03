package likeop;
import java.sql.*;
public class Likeops {
	static final String url = "jdbc:mysql://localhost/School";
    static final String user = "root";
	static final String pass = "Spargen007";
	public static void main(String args[]) {
		try {
			Connection con=DriverManager.getConnection(url,user,pass);
			Statement stmt=con.createStatement();
			String sql="SELECT * FROM Students";
			ResultSet r=stmt.executeQuery(sql);
			System.out.println("without like command\n");
			while(r.next()) {
	            System.out.print("Regno: " + r.getInt("Regno")+"\n");
	            System.out.print("Name: " + r.getString("Name")+"\n");
	            System.out.print("dob: "+r.getDate("DOB")+"\n");
	            System.out.print("Age: " + r.getInt("AGE")+"\n");
	            System.out.print("Gender: " + r.getString("Gender")+"\n");
	            System.out.println("phone: "+r.getString("Phone")+"\n");
	            System.out.println();
			}
				sql="SELECT * FROM Students WHERE Name LIKE '%ar%'";
				r=stmt.executeQuery(sql);
				System.out.println("with like command\n");
				while(r.next()) {
		            System.out.print("Regno: " + r.getInt("Regno")+"\n");
		            System.out.print("Name: " + r.getString("Name")+"\n");
		            System.out.print("dob: "+r.getDate("DOB")+"\n");
		            System.out.print("Age: " + r.getInt("AGE")+"\n");
		            System.out.print("Gender: " + r.getString("Gender")+"\n");
		            System.out.println("phone: "+r.getString("Phone")+"\n");
		            System.out.println();
	            
			}
			}
	catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
