package Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import Models.Cart;
import Models.Customer;
import Models.Items;

public class Cartdbcontroller {
    public int addproducttocartdb(Cart cart) throws Exception{
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql;
            for(Map.Entry <Items, Integer> entry: cart.getCart_items().entrySet()) {
                Items item=entry.getKey();
               int quantity=entry.getValue();
            sql = "INSERT INTO Cart(id,item_name,item_price,item_quantity,total_amount) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cart.getCustomer().getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setDouble(3, item.getPrice());
            preparedStatement.setInt(4, quantity);
            preparedStatement.setDouble(5, item.getPrice()*quantity);
            sucess= preparedStatement.executeUpdate();
            }
            if (sucess == 0) {
                throw new Exception("product creation failed! Check your query and try again!!!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
    public boolean checkcart(Customer customer){
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql="SELECT id FROM Cart where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,customer.getId());
            ResultSet resultset=preparedStatement.executeQuery();
            while(resultset.next()){
                if(resultset.getString("id")==null)
                return false;
                else
                return true;
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Cart viewCart(Customer customer) throws Exception {
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql;
            Cart cart=new Cart();
            int quantity;
            double total=0;
            HashMap<Items, Integer> itemsandquantity= new HashMap<Items, Integer>();
            sql = "SELECT id,item_name,item_price,item_quantity,total_amount FROM Cart where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customer.getId());
            ResultSet resultset=preparedStatement.executeQuery();
            while(resultset.next()){
                Items item=new Items();
                item.setName(resultset.getString("item_name"));
                item.setPrice(resultset.getDouble("item_price"));
                quantity=resultset.getInt("item_quantity");
                total=total+resultset.getDouble("total_amount");
                itemsandquantity.put(item, quantity);
            }
            cart.setCartId(Integer.parseInt(customer.getId()));
            cart.setCartProductTotal(total);
            cart.setCart_items(itemsandquantity);
            return cart;
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    return null;
}

public int deletecart(Cart cart) throws Exception{
    int sucess=0;
    try(Connection connection=Mysqlconnection.getConnection()){
        String sql="Delete From Cart WHERE id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1, cart.getCartId());
        sucess=preparedStatement.executeUpdate();
        if(sucess==0){
            throw new Exception("Cart deletion failed! Check your query and try again!!!");
        }
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
        throw new Exception("Internal error occurred!");
    }
    return sucess;
}
public int checkisitalreadyexit(Customer customer,Items item) throws Exception{
    int oldquantity=0;
    try(Connection connection=Mysqlconnection.getConnection()){
        Items itemm=new Items(); 
        itemm.setName(null);
        String sql="SELECT item_name,item_quantity FROM Cart WHERE id=? AND item_name=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getId());
        preparedStatement.setString(2, item.getName());
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            itemm.setName(resultSet.getString("item_name"));
            if(itemm.getName()==null){
                oldquantity=0;
                return oldquantity;
            }
            else{
                oldquantity=resultSet.getInt("item_quantity");
                return oldquantity;
            }
        }
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
        throw new Exception("Internal error occurred!");
    }
    return oldquantity;
}

public int deletecartbyitemname(Customer customer,Items key) throws Exception {
    int sucess=0;
    try(Connection connection=Mysqlconnection.getConnection()){
        String sql="Delete From Cart WHERE id=? AND item_name=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getId());
        preparedStatement.setString(2, key.getName());
        sucess=preparedStatement.executeUpdate();
        if(sucess==0){
            throw new Exception(" deletion failed! Check your query and try again!!!");
        }
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
        throw new Exception("Internal error occurred!");
    }
    return sucess;

}

}

