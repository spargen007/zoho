package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Models.Employee;

public class Employeedbcontroller {
    public int createemployee(Employee employee) throws Exception{
        int sucess=0;
        try(Connection connection=Mysqlconnection.getConnection()){
            String sql = "INSERT INTO Employee(name,phonenumber,username,password) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPhonenumber());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            sucess=preparedStatement.executeUpdate();
            if(sucess==0){
                throw new Exception("Employee creation failed! check your query and try again!");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }

    public List<Employee> viewemployee() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT id, name FROM Employee";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getString("id"));
                employee.setName(resultSet.getString("name"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred! contact systemAdmin");
        }

        return employeeList;
    }
    public Employee viewemployeebyid(int id) throws Exception {
        Employee employee =new Employee();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT id, name, phonenumber, username FROM Employee WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee.setId(resultSet.getString("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPhonenumber(resultSet.getString("phonenumber"));
                employee.setUsername(resultSet.getString("username"));
            }
        } catch (Exception e) {
            throw new Exception("Internal error occurred! contact systemAdmin");
        }
        return employee;
    }

    public int deleteemployeebyid(int empChoice) throws Exception {
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "DELETE FROM Employee WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, empChoice);
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("Employee deletion failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
    public boolean isemployeeusernamealreadyexit(String username) throws Exception{
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT username FROM Employee WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if(resultSet.getString("username")==null)
                return false;
                else 
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return false;
    }
    public boolean passwordcheck(String username, String password) throws Exception {
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT password FROM Employee WHERE password = ? AND username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if(resultSet.getString("password")==null)
                return false;
                else if(resultSet.getString("password").equals(password))
                return true;
                else
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Internal error occurred!");
        }
        return false;
    }
    public Employee searchemployeebyusername(String Username) throws Exception {
        Employee employee = new Employee();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT id, name, phonenumber, username FROM Employee WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Username);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                employee.setId(resultSet.getString("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPhonenumber(resultSet.getString("phonenumber"));
                employee.setUsername(resultSet.getString("username"));
            }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred! contact systemAdmin");
        }
        return employee;
    }
    public String lastinsertedid(){
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="select MAX(id) from Employee;";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                return rs.getString("MAX(id)");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
