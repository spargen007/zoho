package Controller;
import java.sql.SQLException;
import java.util.Scanner;

import Database.Cartdbcontroller;
import Database.Customerdbcontroller;
import Database.Itemcategorydb;
import Database.Itemdbcontroller;
import Database.Orderdbcontroller;
import Models.Customer;
import View.Categoryview;
import View.Itemview;

public class Customercontroller {
    Scanner scanner = new Scanner(System.in);
    Customerdbcontroller customerdbcontroller=new Customerdbcontroller();
    Orderdbcontroller orderdbcontroller=new Orderdbcontroller();
    Ordercontroller ordercontroller=new Ordercontroller();
    Cartdbcontroller cartdbcontroller=new Cartdbcontroller();
    Cartcontroller cartcontroller=new Cartcontroller();
    Itemdbcontroller itemdbcontroller=new Itemdbcontroller();
    Itemcategorydb itemcategorydb=new Itemcategorydb();
    Categoryview categoryview=new Categoryview();
    Itemview itemview=new Itemview();
    public boolean iscustomerusernamealreadyexit(String name) throws ClassNotFoundException, SQLException, Exception{
        return customerdbcontroller.iscustomerusernamealreadyexit(name);
    }


    public int createcustomer(Customer customer) throws ClassNotFoundException, SQLException, Exception {
        return customerdbcontroller.createcustomer(customer);
    }


    public boolean passwordcheck(String customerusername, String customerpassword) throws Exception {
        return customerdbcontroller.passwordcheck(customerusername, customerpassword);
    }


    public Customer searchCustomerbycustomerusername(String customerusername) throws Exception {
        return customerdbcontroller.searchCustomerbycustomerusername(customerusername);
    }


    public Customer searchCustomerbycustomerid(String id) throws Exception {
        return customerdbcontroller.searchCustomerbycustomerid(id);
    }

    
}
