package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import Models.Customer;

public class Customerdbcontroller {
    public int createcustomer(Customer customer) throws Exception{
        int sucess=0;
        try(Connection connection=Mysqlconnection.getConnection()){
            String sql = "INSERT INTO Customer(name,phonenumber,username,password,address,ismembership) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhonenumber());
            preparedStatement.setString(3, customer.getUsername());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setBoolean(6, customer.isPremiummembership());

            sucess=preparedStatement.executeUpdate();
            if(sucess==0){
                throw new Exception("Customer creation failed! check your query and try again!");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
public boolean iscustomerusernamealreadyexit(String username) throws Exception{
    try(Connection connection = Mysqlconnection.getConnection()) {
        String sql = "SELECT username FROM Customer WHERE username = ?";
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
        String sql = "SELECT password FROM Customer WHERE password = ? AND username = ?";
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
public List<Customer> viewCustomer() throws Exception {
    List<Customer> customerList = new ArrayList<>();
    try(Connection connection = Mysqlconnection.getConnection()) {
        String sql = "SELECT id, name, phonenumber, username, password, address, ismembership FROM Customer";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
            customer.setName(resultSet.getString("name"));
            customer.setPhonenumber(resultSet.getString("phonenumber"));
            customer.setUsername(resultSet.getString("username"));
            customer.setPassword(resultSet.getString("password"));
            customer.setAddress(resultSet.getString("address"));
            customer.setPremiummembership(resultSet.getBoolean("ismembership"));
            customerList.add(customer);
        }
        if (customerList.size() == 0) {
            throw new Exception("customer database is empty");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new Exception("Internal error occurred!");
    }
    return customerList;
}
public Customer searchCustomerbycustomerusername(String customerUsername) throws Exception {
    Customer customer = new Customer();
    try(Connection connection = Mysqlconnection.getConnection()) {
        String sql = "SELECT id, name, phonenumber, username, password, address, ismembership FROM Customer WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customerUsername);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            customer.setId(resultSet.getString("id"));
            customer.setName(resultSet.getString("name"));
            customer.setPhonenumber(resultSet.getString("phonenumber"));
            customer.setUsername(resultSet.getString("username"));
            customer.setPassword(resultSet.getString("password"));
            customer.setAddress(resultSet.getString("address"));
            customer.setPremiummembership(resultSet.getBoolean("ismembership"));
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new Exception("Internal error occurred! contact systemAdmin");
    }
    return customer;
}
public Customer searchCustomerbycustomerid(String id) throws Exception {
    Customer customer = new Customer();
    try(Connection connection = Mysqlconnection.getConnection()) {
        String sql = "SELECT id, name, phonenumber, username, password, address, ismembership FROM Customer WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            customer.setId(resultSet.getString("id"));
            customer.setName(resultSet.getString("name"));
            customer.setPhonenumber(resultSet.getString("phonenumber"));
            customer.setUsername(resultSet.getString("username"));
            customer.setPassword(resultSet.getString("password"));
            customer.setAddress(resultSet.getString("address"));
            customer.setPremiummembership(resultSet.getBoolean("ismembership"));
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new Exception("Internal error occurred! contact systemAdmin");
    }
    return customer;
}
}
