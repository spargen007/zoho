package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Models.Itemcategory;
import Models.Items;

public class Itemdbcontroller {
    public int createitem(Items item) throws Exception {
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO Items( name, category, price) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getCategory().getItemcategoryName());
            preparedStatement.setDouble(3,item.getPrice());
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
    public List<Items> viewitems() throws Exception{
        List<Items> itemlist=new ArrayList<Items>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, name, category, price FROM Items";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Items item=new Items();
                Itemcategory itemcategory=new Itemcategory();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                itemcategory.setItemcategoryName(rs.getString("category"));
                item.setPrice(rs.getDouble("price"));
                item.setCategory(itemcategory);
                itemlist.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return itemlist; 
    }
    public List<Items> viewitemsbycategory(String category) throws Exception{
        List<Items> itemlistbycategory=new ArrayList<Items>();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, name, category, price FROM Items WHERE category= ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, category);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Items item=new Items();
                Itemcategory itemcategory=new Itemcategory();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                itemcategory.setItemcategoryName(rs.getString("category"));
                item.setPrice(rs.getDouble("price"));
                item.setCategory(itemcategory);
                itemlistbycategory.add(item);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return itemlistbycategory; 
    }
    public Items viewitemsbyid(int productChoice) throws Exception{
        Itemcategory itemcategory=new Itemcategory();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, name, category, price FROM Items WHERE id= ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, productChoice);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Items item=new Items();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                itemcategory.setItemcategoryName(rs.getString("category"));
                item.setPrice(rs.getDouble("price"));
                item.setCategory(itemcategory);
                return item;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null; 
    }
    public Items viewitemsbyname(String name) throws Exception{
        Itemcategory itemcategory=new Itemcategory();
        try(Connection connection = Mysqlconnection.getConnection()){
            String sql="SELECT id, name, category, price FROM Items WHERE name= ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()){
                Items item=new Items();
                item.setId(rs.getString("id"));
                item.setName(rs.getString("name"));
                itemcategory.setItemcategoryName(rs.getString("category"));
                item.setPrice(rs.getDouble("price"));
                item.setCategory(itemcategory);
                return item;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null; 
    }
    
    public int deleteitembyid(int id) throws Exception {
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "DELETE FROM Items WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("item deletion failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
}
