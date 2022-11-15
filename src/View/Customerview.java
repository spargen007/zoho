package View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.Cartcontroller;
import Controller.Customercontroller;
import Controller.Itemcontroller;
import Models.Customer;
import Models.Itemcategory;
import Models.Items;
import Validation.Customer_Validation;

public class Customerview {
    Customercontroller customercontroller=new Customercontroller();
    Customer_Validation customer_validation =new Customer_Validation();
    Itemview itemview=new Itemview();
    Orderview orderview=new Orderview();
    Cartview cartview=new Cartview();
    Categoryview categoryview=new Categoryview();
    Itemcontroller itemcontroller=new Itemcontroller();
    Cartcontroller cartcontroller=new Cartcontroller();
    Scanner scanner =new Scanner(System.in);
    public void registercustomer() throws Exception{
        int sucess=0;
        do{
            Customer customer =new Customer();
            Thread.sleep(500);
            System.out.println("+-------------------------------- +");
            System.out.println("|      Register New Customer      |");
            System.out.println("+---------------------------------+");
            System.out.println("| Hello..!!                       |");
            System.out.println("| We are glad to see u here!!!!   |");
            System.out.println("| Use this form to register       |");
            System.out.println("|                                 |");
            System.out.print("| Enter Name :");
            String customername;
            while(true){
            try{
                customername=scanner.nextLine();
                if(customer_validation.validatename(customername)){
                customer.setName(customername);
                break;
                }
                else{
                    System.out.println("Pls Enter Correct Name! Try Again!");
                    continue;
                }
            }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("| Enter phonenumber:");
            String phonenumber;
            while(true){
                try{
                    phonenumber=scanner.nextLine();
                    if(customer_validation.validcustomerphonenumber(phonenumber)){
                    customer.setPhonenumber(phonenumber);
                    break;
                }
                else{
                    continue;
                }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("| Enter address:");
            String customeraddress;
            while(true){
            try{
                customeraddress=scanner.nextLine();
                customer.setAddress(customeraddress);
                break;
            }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            int flag=0;
            while(flag==0){
            try{
            System.out.print("| Enter UserName :");
            String username=scanner.nextLine();
            if (customer_validation.validcustomerusername(username) && !customercontroller.iscustomerusernamealreadyexit(username)) {
                customer.setUsername(username);
                System.out.print("| Enter Password :");
                String password=scanner.nextLine();
                if(customer_validation.validcustomerpassword(password)){
                    customer.setPassword(password);
                    flag=1;
                }
            }
            if(customercontroller.iscustomerusernamealreadyexit(username)){
                System.out.println("+-------------------------------- +");
                System.out.println("\nusername already exit pls re-enter it!\n");
                System.out.println("+-------------------------------- +");
            }
        }catch (Exception e) {
                System.out.println("|                                 |");
                System.out.println("+---------------------------------+");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("+-------------------------------- +");
        Thread.sleep(200);
        System.out.println("wait a minute there is still one benefit from us!!\n yeah its premium membership.");
        Thread.sleep(3000);
        System.out.println("Benefits:\n * you will get special combo offers\n * you will get discount of 5% on every orders\n");
        Thread.sleep(5000);
        System.out.println();
        System.out.println("Note:\n * membership amount of Rs.1000 will be collected for every 3 months.\n * this subscription is applicable only at registration you can't avail it later");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("+--------------------------------");
        System.out.println("Just grab this opening offer!!!");
        System.out.println("+--------------------------------");
        Thread.sleep(200);
        System.out.println("| Do You Want Premium Membership?(Y-for yes||N-for No|");
        System.out.println("+--------------------------------");
        while(true){
        String m=scanner.nextLine();
        if(m.equalsIgnoreCase("y")){
            customer.setPremiummembership(true);
            break;
        }
        else if(m.equalsIgnoreCase("n"))
        {
            customer.setPremiummembership(false);
            break;
        }
        else{
            System.out.println("+-------------------------------- +");
            System.out.println("Pls Enter Either Y or N! Re-enter It!");
            System.out.println("+-------------------------------- +");
            continue;
        }
        }
        sucess=customercontroller.createcustomer(customer);
     if(sucess==1){
        System.out.println("+-------------------------------- +");
        System.out.println("your account has been created sucesssfully.\n Thank You for joining us.");
        System.out.println("+-------------------------------- +");
     }
    } while(sucess!=1);
    }
    public void logincustomer() throws Exception{
        boolean sucess= false;
            do {
                Customer customer;
                System.out.println();
                System.out.println("+*********************************+");
                System.out.println("|        Customer Login           |");
                System.out.println("+*********************************+");
                System.out.println("| Welcome To customer login..     |");
                System.out.println("| Please enter your details..     |");
                System.out.println("|                                 |");
                System.out.print("| Enter Username :");
                try{
                String customerusername = scanner.nextLine();
                if(customercontroller.iscustomerusernamealreadyexit(customerusername)){
                    System.out.print("| Enter Password :");
                    String customerpassword=scanner.nextLine();
                    if(customercontroller.passwordcheck(customerusername, customerpassword)){
                        System.out.println("+---------------------------------+");
                        customer = customercontroller.searchCustomerbycustomerusername(customerusername);
                        customer.setCustomerloginSession(true);
                        sucess = true;
                        Thread.sleep(1000);
                        System.out.println("\nLogin Sucessfull!");
                        Thread.sleep(1500);
                        System.out.println("\nHello, "+customer.getName());
                        System.out.println("+-----------------------------------------------+");
                        System.out.println("Please wait, Redirecting to your customized page.");
                        System.out.println("+-----------------------------------------------+");
                        Thread.sleep(1500);
                        dashboard(customer);
                        break;
                    }
                    else {
                        System.out.println("+---------------------------------+");
                        System.out.println("");
                        System.out.println("The username and password you entered is not matching.");
                        System.out.println("Try again :)");
                        Thread.sleep(1000);
                    }
                }
                else {
                    System.out.println("+---------------------------------+");
                    System.out.println("The username doesn't exist.");
                    Thread.sleep(500);
                    System.out.println("Enter a different username or get a new one.");
                    Thread.sleep(1000);
                    break;
                }
            }catch(Exception e){
    
                System.out.println(e.getMessage());
    
            }
    
    }while(sucess==false);
    }
    public void dashboard(Customer customer){
        boolean run=true;
            if(customer.isCustomerloginSession()){
                int dashoption=0;
                do{
                try{
                        System.out.println("");
                        System.out.println("+------------------------------+");
                        System.out.println("|          Dashboard           |");
                        System.out.println("+------------------------------+");
                        System.out.println("| Hello..!!                    |");
                        System.out.println("| Welcome To SS Supermarket... |");
                        System.out.println("|                              |");
                        System.out.println("| 1. My Account Details        |");
                        System.out.println("| 2. My Orders                 |");
                        System.out.println("| 3. My Cart                   |");
                        System.out.println("| 4. Shop by Category          |");
                        System.out.println("| 5. LogOut                    |");
                        System.out.println("+------------------------------+");
                        System.out.print("| Enter your choice :");
                        dashoption=Integer.parseInt(scanner.nextLine());
                        System.out.println("+------------------------------+");
                        System.out.println();
                        switch (dashoption) {
                            case 1:
                            System.out.println("+------------------------------+");
                            System.out.println("|          My Account          |");
                            System.out.println("+------------------------------+");
                            customer=customercontroller.searchCustomerbycustomerusername(customer.getUsername());
                            viewcustomer(customer);
                            System.out.println("Press 1 For Back <--------------");
                            System.out.println();
                            while(true){
                            dashoption=Integer.parseInt(scanner.nextLine());
                            if(dashoption==1){
                            break;
                            }
                            else{
                                System.out.println("Enter Correct Option!!!!");
                            }
                        }
                        break;
                            case 2:
                            orderview.vieworder(customer);
                            Thread.sleep(1000);
                            break;
                            case 3:
                            cartview.viewCart(customer);
                            break;
                            case 4:
                            HashMap<Items,Integer> ordering_items=new HashMap<Items,Integer>();
                            int dupicate_check=0;
                            while(true){
                            System.out.println("| Select Category to add items to cart |");
                            categoryview.allcategory();
                            System.out.print("| Enter id:");
                            int choice=Integer.parseInt(scanner.nextLine());
                            Itemcategory category =itemcontroller.getItemcategoryByItemcategoryId(choice);
                            List<Items> items =itemcontroller.viewitemsbycategory(category.getItemcategoryName());
                            itemview.viewitem(items);
                            System.out.print("| Enter itemid to add items to cart:");
                            int id=Integer.parseInt(scanner.nextLine());
                            Items item=itemcontroller.viewitemsbyid(id);
                            System.out.println("| Enter quantity of  item "+item.getName());
                            int quantity=Integer.parseInt(scanner.nextLine());
                            int oldquantity=0;
                            if(dupicate_check==1){
                                for(Map.Entry <Items, Integer> entry: ordering_items.entrySet()) {
                                    if(item.getName().equals(entry.getKey().getName()))
                                    oldquantity=entry.getValue();
                                    ordering_items.remove(entry.getKey());
                                }
                            ordering_items.put(item,(oldquantity+quantity));
                            }
                            else{
                                ordering_items.put(item,(oldquantity+quantity));
                            }
                            System.out.println("| Do you want to add any other item!! (Y-yes and N- for No) |");
                            String otherchoice=scanner.nextLine();
                            if(otherchoice.equalsIgnoreCase("y")){
                                dupicate_check=1;
                                continue;
                            }
                            else if(otherchoice.equalsIgnoreCase("n")){
                                cartcontroller.addproducttocart(customer, ordering_items);
                                System.out.println("| You can confirm your Order in * My Cart * option in dashboard.....  ");
                                Thread.sleep(2000);
                                System.out.println("| You are Redirecting to Dashboard!!!!|");
                                Thread.sleep(5000);
                                break;
                            }
                            else{
                                System.out.println("| Sorry you entered wrong option!!!!|");
                                cartcontroller.addproducttocart(customer, ordering_items);
                                System.out.println("| Don't Worry you previously selected items are saved to cart sucessfully!!");
                                Thread.sleep(2000);
                                System.out.println("| You can confirm your Order in * My Cart * option in dashboard.....  ");
                                Thread.sleep(2000);
                                System.out.println("| You are Redirecting to Dashboard!!!!|");
                                Thread.sleep(5000);
                                break;
                            }
                        }
                            break;
                            case 5:
                            customer.setCustomerloginSession(false);
                            System.out.println("");
                            System.out.println();
                            System.out.println("Oh no! You're leaving");
                            Thread.sleep(1000);
                            System.out.println("Bye!!");
                            System.out.println("");
                            run=false;
                            break;
                            default:
                            System.out.println("Invalid User Input : Please enter numbers between (1-5)...");
                                break;
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    }while(run);
             

            }
        

    }
    public void viewcustomer(Customer customer){
        System.out.println("+------------------------------+");
        System.out.println("| Hello!!, " + customer.getName());
        System.out.println("| Customerid : " + customer.getId());
        System.out.println("| Username   : " + customer.getUsername());
        System.out.println("| Phonenumber: " + customer.getPhonenumber());
        System.out.println("| Address    : " + customer.getAddress());
        System.out.println("+------------------------------+");

    }
    
}
