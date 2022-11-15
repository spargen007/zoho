package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Models.Itemcategory;

public class Itemcategorydb {
    public List<Itemcategory> viewItemcategory() throws Exception {
        List<Itemcategory> ItemcategoryList = new ArrayList<>();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT Itemcategoryid, Itemcategoryname FROM Itemcategory";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Itemcategory Itemcategory = new Itemcategory();
                Itemcategory.setItemcategoryId(resultSet.getString("Itemcategoryid"));
                Itemcategory.setItemcategoryName(resultSet.getString("Itemcategoryname"));
                ItemcategoryList.add(Itemcategory);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred! contact systemAdmin");
        }
        return ItemcategoryList;
    }

    
    public Itemcategory getItemcategoryByItemcategoryId(int ItemcategoryId) throws Exception {
        Itemcategory Itemcategory = new Itemcategory();
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "SELECT Itemcategoryid, Itemcategoryname FROM Itemcategory WHERE Itemcategoryid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ItemcategoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Itemcategory.setItemcategoryId(resultSet.getString("Itemcategoryid"));
                Itemcategory.setItemcategoryName(resultSet.getString("Itemcategoryname"));
            }
        } catch (Exception e) {
            throw new Exception("Internal error occurred! contact systemAdmin");
        }
        return Itemcategory;
    }
    
    public int addCategory(Itemcategory itemcategory) throws Exception {
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "INSERT INTO Itemcategory(Itemcategoryname) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, itemcategory.getItemcategoryName());
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("itemcategory creation failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
    public int deletecategorybyid(int id) throws Exception {
        int sucess = 0;
        try(Connection connection = Mysqlconnection.getConnection()) {
            String sql = "DELETE FROM Itemcategory WHERE Itemcategoryid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            sucess = preparedStatement.executeUpdate();
            if (sucess == 0) {
                throw new Exception("itemcategory creation failed! Check your query and try again!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Internal error occurred!");
        }
        return sucess;
    }
}
