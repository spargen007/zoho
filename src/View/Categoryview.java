package View;

import java.util.List;

import Database.Itemcategorydb;
import Models.Itemcategory;

public class Categoryview {
    Itemcategorydb itemcategorydb=new Itemcategorydb();
    public void allcategory() throws Exception{
        List<Itemcategory> productCategoryList = itemcategorydb.viewItemcategory();
        Thread.sleep(1000);
        System.out.println("+------------------------------+");
        System.out.println("|         All Categories       |");
        System.out.println("+------------------------------+");
        System.out.println("| #  Category Name              ");
        System.out.println("|                               ");
         for (Itemcategory productCategory : productCategoryList) {
            System.out.println("| " + productCategory.getItemcategoryId() + ". " + productCategory.getItemcategoryName());
         }
        System.out.println("+------------------------------+");
    }
}
