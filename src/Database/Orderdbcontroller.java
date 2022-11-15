package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Models.Customer;
import Models.Employee;
import Models.Order;
import Models.Order.OrderStatus;
import Models.Order.PaymentStatus;

public class Orderdbcontroller {
    public int createorder(Order order) throws Exception{
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO Orders(status, customer_id, customer_name, total_amount, payment_status) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getStatus().toString());
            preparedStatement.setString(2, order.getCustomer().getId());
            preparedStatement.setString(3, order.getCustomer().getName());
            preparedStatement.setDouble(4, order.getTotal_amount());
            preparedStatement.setString(5, order.getPaymentStatus().toString());
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("Order creation failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sucess;
    }
    public void setprovider(Order order) throws Exception{
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "UPDATE Orders SET provider_id=?,provider_name=? WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getProvider().getId());
            preparedStatement.setString(2, order.getProvider().getName());
            preparedStatement.setString(3, order.getId());
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("provider assigning failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
    }
    public int changeorderstatus(Order order) throws Exception{
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "UPDATE Orders SET status=? WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getStatus().toString());
            preparedStatement.setString(2, order.getId());
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("product creation failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
    public int changepaymentstatus(Order order) throws Exception{
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "UPDATE Orders SET payment_status=? WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, order.getPaymentStatus().toString());
            preparedStatement.setString(2, order.getId());
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("product creation failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
    public List<Order> vieworders(){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    public Order vieworderbyid(int id){
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
               return order;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public String lastinsertedid(){
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="select MAX(id) from Orders;";
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
    //

    public List<Order> viewpendingorderslist(){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "PLACED");
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    public List<Order> viewpendingorderslist(Customer customerin){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=? AND customer_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "PLACED");
            preparedStatement.setString(2, customerin.getId());
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    ///


    public List<Order> viewprocessedorderslist(){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "PROCESSED");
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    public List<Order> viewprocessedorderslist(Customer customerin){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=? AND customer_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "PROCESSED");
            preparedStatement.setString(2, customerin.getId());
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    ////


    public List<Order> viewpackedorderslist(){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "PACKED");
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    public List<Order> viewpackedorderslist(Customer customerin){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=? AND customer_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "PACKED");
            preparedStatement.setString(2, customerin.getId());
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }






///////
    public List<Order> viewordersfordeliveryList(Employee employee){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=? AND provider_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "SHIPPED");
            preparedStatement.setString(2, employee.getId());
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    public List<Order> viewordersfordeliveryList(Customer customerin){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=? AND customer_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "SHIPPED");
            preparedStatement.setString(2, customerin.getId());
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    //////



    public List<Order> viewcompleteddeliveryList(){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "DELIVERED");
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }
    public List<Order> viewcompleteddeliveryList(Customer customerin){
        List<Order> orderlist=new ArrayList<Order>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, status, customer_id, customer_name, total_amount, payment_status FROM Orders WHERE status=? AND customer_id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "DELIVERED");
            preparedStatement.setString(2, customerin.getId());
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Order order=new Order();
                Customer customer=new Customer();
                order.setId(rs.getString("id"));
                customer.setId(rs.getString("customer_id"));
                customer.setName(rs.getString("customer_name"));
                OrderStatus status=OrderStatus.valueOf(rs.getString("status"));
                order.setStatus(status);
                order.setTotal_amount(rs.getDouble("total_amount"));
                PaymentStatus pay_status = PaymentStatus.valueOf(rs.getString("payment_status"));
                order.setPaymentStatus(pay_status);
                order.setCustomer(customer);
                orderlist.add(order);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orderlist;
    }





    }
