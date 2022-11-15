package Controller;

import java.util.*;

import Database.Itemcategorydb;
import Database.Itemdbcontroller;
import Models.Itemcategory;
import Models.Items;
public class Itemcontroller {
    Scanner scanner =new Scanner(System.in);
    Itemdbcontroller itemdbcontroller=new Itemdbcontroller();
    Itemcategorydb itemcategorydb=new Itemcategorydb();

    public List<Items> viewitems() throws Exception {

        return itemdbcontroller.viewitems();
    }
    public Items viewitemsbyid(int productChoice) throws Exception {
        return itemdbcontroller.viewitemsbyid(productChoice);
    }
    public Itemcategory getItemcategoryByItemcategoryId(int productCategoryChoice) throws Exception {
        return itemcategorydb.getItemcategoryByItemcategoryId(productCategoryChoice);
    }
    public int createitem(Items product) throws Exception {

        return itemdbcontroller.createitem(product);
    }
    public int addCategory(Itemcategory itemcategory) throws Exception {
        return itemcategorydb.addCategory(itemcategory);
    }
    public void deletecategorybyid(int choice) throws Exception {
        itemcategorydb.deletecategorybyid(choice);
    }
    public void deleteitembyid(int choice) throws Exception {
        itemcategorydb.deletecategorybyid(choice);
    }
    public List<Items> viewitemsbycategory(String itemcategoryName) throws Exception {
        return itemdbcontroller.viewitemsbycategory(itemcategoryName);
    }
    public Items viewitemsbyname(String name) throws Exception {
        return itemdbcontroller.viewitemsbyname(name);
    }
}

