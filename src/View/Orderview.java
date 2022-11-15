package View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.Employeecontroller;
import Controller.Ordercontroller;
import Database.Itemdbcontroller;
import Models.Customer;
import Models.Employee;
import Models.Items;
import Models.Order;
import Models.Order.OrderStatus;
import Models.Order.PaymentStatus;

public class Orderview {
    Itemdbcontroller itemdbcontroller=new Itemdbcontroller();
    Ordercontroller ordercontroller =new Ordercontroller();
    Employeecontroller employeecontroller=new Employeecontroller();
    Scanner scanner =new Scanner(System.in);
    public void vieworder(Order order){
       System.out.println("+------------------------------+");
       System.out.println("|         Order Details        |");
       System.out.println("+------------------------------+");
       System.out.println("| Order ID       : " + order.getId());
       System.out.println("| TotalAmount    : " + order.getTotal_amount());
       System.out.println("| Status         : " +order.getStatus());
       System.out.println("| Payment Status : " + order.getPaymentStatus());
       System.out.println("+------------------------------+");
       System.out.println("");
    }
    public void vieworder(List<Order>orders){
        System.out.println("+---------------------------------+");
        System.out.println("|          Orders                 |");
        System.out.println("+----------------------------------");
        System.out.println("| Order_id       Order_status      ");
        System.out.println();
        for (Order order : orders) {
        System.out.println("|   "+order.getId()+"               "+order.getStatus());
        }
        System.out.println();
    }
    public void ordereditemsview(Order order) throws Exception{
       Order order2 = ordercontroller.viewordereditemsbyorderid(order.getId());
        HashMap<Items,Integer> ordereditems=order2.getOrdered_items();
        int quantity;
        System.out.println("|  #  Product Name  | Price | Quantitiy  | Amount");
        for(Map.Entry <Items, Integer> entry: ordereditems.entrySet()) {
            Items item=new Items();
            item=itemdbcontroller.viewitemsbyname(entry.getKey().getName());
            quantity=entry.getValue();
        System.out.println("|  "+item.getId()+"|  "+item.getName()+"|  "+item.getPrice()+"|  "+"|    "+entry.getValue()+"|   "+(item.getPrice()*quantity));
        }
        System.out.println("+--------------+");
        System.out.println("| Total_Amount:|"+order.getTotal_amount());
        System.out.println("+--------------+");

    }
    public void vieworder(Customer customer){
        if (customer.isCustomerloginSession()) {
            boolean run=true;
            int orderlistChoice;
            do{
            try {
                    System.out.println();
                    System.out.println("+--------------------------------+");
                    System.out.println("|        Orders_List             |");
                    System.out.println("+--------------------------------+");
                    System.out.println("| 1. Placed orders               |");
                    System.out.println("| 2. Processed orders            |");
                    System.out.println("| 3. Shipped orders              |");
                    System.out.println("| 4. Delivered orders            |");
                    System.out.println("| 5. Pay for Placed orders       |");
                    System.out.println("| 6. Exit                        |");
                    System.out.println("+--------------------------------+");
                    System.out.println();
                    System.out.println("Note:");
                    System.out.println("+--------------------------------------------------------+");
                    System.out.println("Dear customer, Placed orders by you are moved to Processed");
                    System.out.println("when you done payment for the order.");
                    System.out.println("+--------------------------------------------------------+");
                    Thread.sleep(1000);
                    System.out.println();
                    System.out.print("| Enter Your Choice:");
                    orderlistChoice=Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    switch (orderlistChoice) {
                       case 1:
                       List<Order>orderlist= ordercontroller.viewpendingorderslist(customer);
                       if(orderlist.size()==0){
                        System.out.println();
                        System.out.println("Sorry, there is no Orders!!!!");
                        Thread.sleep(1000);
                        break;}
                       vieworder(orderlist);
                       System.out.print("| Enter order_id to view order :");
                       int choice=Integer.parseInt(scanner.nextLine());
                       Order order=ordercontroller.vieworderbyid(choice);
                       vieworder(order);
                       System.out.println("| 1. View Items Of Order");
                       System.out.println("| Press any Key for Back<--------------");
                       System.out.println();
                       System.out.print("| Enter Your Choice:");
                       System.out.println();
                      int orderchoice=Integer.parseInt(scanner.nextLine());
                       if(orderchoice==1){
                        System.out.println("Loading...");
                        Thread.sleep(2000);
                        ordereditemsview(order);
                        Thread.sleep(5000);
                        break;
                       }
                       else{
                       System.out.println("Loading...");
                       Thread.sleep(3000);
                        break;
                       }
                       case 2:
                       orderlist=ordercontroller.viewprocessedorderslist(customer);
                       if(orderlist.size()==0){
                        System.out.println();
                        System.out.println("Sorry, there is no Orders!!!!");
                        Thread.sleep(1000);;
                        break;}
                       vieworder(orderlist);
                       System.out.print("| Enter order_id to view order :");
                       choice=Integer.parseInt(scanner.nextLine());
                       order=ordercontroller.vieworderbyid(choice);
                       vieworder(order);
                       System.out.println("| 1. View Items Of Order");
                       System.out.println("| Press any Key for Back<--------------");
                       System.out.println();
                       System.out.print("| Enter Your Choice:");
                       System.out.println();
                       orderchoice=Integer.parseInt(scanner.nextLine());
                       if(orderchoice==1){
                        System.out.println("Loading...");
                        Thread.sleep(2000);
                        ordereditemsview(order);
                        Thread.sleep(5000);
                        break;
                       }
                       else{
                       System.out.println("Loading...");
                       Thread.sleep(3000);
                        break;
                       }
                        case 3:
                        orderlist=ordercontroller.viewordersfordeliveryList(customer);
                        if(orderlist.size()==0){
                            System.out.println();
                         System.out.println("Sorry, there is no Orders!!!!");
                         Thread.sleep(1000);;
                         break;}
                        vieworder(orderlist);
                        System.out.print("| Enter order_id to view order :");
                        choice=Integer.parseInt(scanner.nextLine());
                        order=ordercontroller.vieworderbyid(choice);
                        vieworder(order);
                        System.out.println("| 1. View Items Of Order");
                        System.out.println("| 2. View Provider Of Order");
                        System.out.println("| Press any Key for Back<--------------");
                        System.out.println();
                        System.out.print("| Enter Your Choice:");
                        System.out.println();
                        orderchoice=Integer.parseInt(scanner.nextLine());
                        if(orderchoice==1){
                         System.out.println("Loading...");
                         Thread.sleep(2000);
                         ordereditemsview(order);
                         Thread.sleep(5000);
                         break;
                        }
                        if(orderchoice==2){
                            Employee employee=employeecontroller.viewemployeebyid(Integer.parseInt(order.getProvider().getId()));
                            Employeeview employeeview=new Employeeview();
                            employeeview.viewemployee(employee);
                            Thread.sleep(4000);
                        }
                        else{
                        System.out.println("Loading...");
                        Thread.sleep(3000);
                         break;
                        }
                        case 4:
                        orderlist=ordercontroller.viewcompleteddeliveryList(customer);
                        if(orderlist.size()==0){
                            System.out.println();
                            System.out.println("Sorry, there is no Orders!!!!");
                            Thread.sleep(1000);;
                            break;}
                        vieworder(orderlist);
                        System.out.print("| Enter order_id to view order :");
                        choice=Integer.parseInt(scanner.nextLine());
                        order=ordercontroller.vieworderbyid(choice);
                        vieworder(order);
                        System.out.println("| 1. View Items Of Order");
                        System.out.println("| Press any Key for Back<--------------");
                        System.err.println();
                        System.out.print("| Enter Your Choice:");
                        System.out.println();
                        orderchoice=Integer.parseInt(scanner.nextLine());
                        if(orderchoice==1){
                         System.out.println("Loading...");
                         Thread.sleep(2000);
                         ordereditemsview(order);
                         Thread.sleep(5000);
                         break;
                        }
                        else{
                        System.out.println("Loading...");
                        Thread.sleep(3000);
                         break;
                        }
                        case 5:
                        orderlist= ordercontroller.viewpendingorderslist(customer);
                        if(orderlist.size()==0){
                            System.out.println();
                            System.out.println("Sorry, there is no Orders!!!!");
                            Thread.sleep(1000);;
                            break;}
                        vieworder(orderlist);
                        System.out.print("| Enter order_id to pay order :");
                        choice=Integer.parseInt(scanner.nextLine());
                        order=ordercontroller.vieworderbyid(choice);
                        payorder(customer, order);
                        System.out.println("Loading...");
                        Thread.sleep(3000);
                        break;
                        case 6:
                        System.out.println("you are Redirecting to dashboard....<---------");
                        System.out.println();
                        Thread.sleep(2000);
                        run=false;
                        break;
                        default:
                            break;
                    }
                }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(run);
    }    
}
public void payorder(Customer customer,Order order) throws Exception{
    try{
                        System.out.println("+--------------------------------+");
                        System.out.println("|        Payment_Option          |");
                        System.out.println("+--------------------------------+");
                        System.out.println("| 1. Online");
                        System.out.println("| 2. Cash");
                        System.out.print("| Enter option to pay order :");
                        int choice=Integer.parseInt(scanner.nextLine());
                        if(choice==1 || choice==2){
                            order.setPaymentStatus(PaymentStatus.PAID);
                            order.setStatus(OrderStatus.PROCESSED);
                            ordercontroller.changepaymentstatus(order);
                            ordercontroller.changeorderstatus(order);
                            System.out.println("Your payment is sucessfull!!!!!");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
    }
}
