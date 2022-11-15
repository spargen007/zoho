package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysqlconnection {
    private static Connection con = null;
    private Mysqlconnection(){
    }
    public static Connection getConnection() throws Exception
    {
        Connection con=Mysqlconnection.con;
        if(con==null){
            String url = "jdbc:mysql://localhost:3306/Supermarketapp";
            String user = "root";
            String pass = "Spargen007";
            try {
                con = DriverManager.getConnection(url, user, pass);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
