package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Map;

import java.util.HashMap;

import Models.Items;
import Models.Order;

public class Ordered_itemsdbcontroller {
    Itemdbcontroller itemdbcontroller =new Itemdbcontroller();
    public int  createordereditems(Order order) throws ClassNotFoundException, SQLException, Exception{
        HashMap<Items,Integer> ordered_items=new HashMap<Items,Integer>();
        ordered_items=order.getOrdered_items();
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            Items item;
            int quantity;
            String sql = "INSERT INTO Ordered_items(order_id, item_id, item_name, item_quantity, item_price, item_total) VALUES (?,?,?,?,?,?)";
            for(Map.Entry<Items, Integer> entry: ordered_items.entrySet()) {
                sucess=0;
                item=itemdbcontroller.viewitemsbyname(entry.getKey().getName());
                quantity=entry.getValue();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,order.getId());
                preparedStatement.setString(2, item.getId());
                preparedStatement.setString(3, item.getName());
                preparedStatement.setInt(4, quantity);
                preparedStatement.setDouble(5, item.getPrice());
                preparedStatement.setDouble(6, quantity*item.getPrice());
                sucess=preparedStatement.executeUpdate();
            }
            if (sucess == 0) {
                throw new Exception("adding ordered items failed! Check your query and try again!!!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
}
public Order viewordereditemsbyorderid(String id) throws ClassNotFoundException, SQLException{
    HashMap<Items,Integer> ordered_items=new HashMap<Items,Integer>();
    int quantity;
    Order order=new Order();
    try(Connection connection = Mysqlconnection.getConnection()){
        String sql="SELECT order_id, item_id, item_name, item_quantity, item_price, item_total FROM Ordered_items WHERE order_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet rs= preparedStatement.executeQuery();
        while(rs.next()){
            Items item=new Items();
            item.setId(rs.getString("item_id"));
            item.setName(rs.getString("item_name"));
            item.setPrice(rs.getDouble("item_price"));
            quantity=rs.getInt("item_quantity");
            ordered_items.put(item, quantity);
        }
        order.setId(id);
        order.setOrdered_items(ordered_items);
    }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return order;
}

}