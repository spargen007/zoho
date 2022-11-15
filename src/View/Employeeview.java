package View;

import java.util.List;
import java.util.Scanner;

import Controller.Customercontroller;
import Controller.Employeecontroller;
import Controller.Ordercontroller;
import Models.Employee;
import Models.Order;
import Models.Order.OrderStatus;
import Validation.Customer_Validation;

public class Employeeview {
    Orderview orderview=new Orderview();
    Customercontroller customercontroller=new Customercontroller();
    Ordercontroller ordercontroller=new Ordercontroller();
    Employeecontroller employeecontroller=new Employeecontroller();
    Customer_Validation validation=new Customer_Validation();
    Scanner scanner =new Scanner(System.in);
    public void viewemployee(Employee employee){
        System.out.println("+------------------------------+");
        System.out.println("| Employee_name: " + employee.getName());
        System.out.println("| Employee_id  : " + employee.getId());
        System.out.println("| Username     : " + employee.getUsername());
        System.out.println("| Phonenumber  : " + employee.getPhonenumber());
        System.out.println("+------------------------------+");
    }
    public void loginemployee() throws Exception{
        boolean sucess= false;
            do {
                Employee employee;
                System.out.println();
                System.out.println("+********************************+");
                System.out.println("|        Employee Login          |");
                System.out.println("+********************************+");
                System.out.println("| Welcome To employee login..    |");
                System.out.println("| Please enter your details..    |");
                System.out.println("|                                |");
                System.out.print("| Enter Username :");
                try{
                String username = scanner.nextLine();
                if(employeecontroller.isemployeeusernamealreadyexit(username)){
                    System.out.print("| Enter Password :");
                    String password=scanner.nextLine();
                    if(employeecontroller.passwordcheck(username, password)){
                        System.out.println("+---------------------------------+");
                        employee = employeecontroller.searchemployeebyemployeeusername(username);
                        employee.setEmployeeloginSession(true);
                        sucess = true;
                        Thread.sleep(1000);
                        System.out.println("\nLogin Sucessfull!");
                        Thread.sleep(1500);
                        System.out.println("\nHello, "+employee.getName());
                        System.out.println("+-----------------------------------------------+");
                        System.out.println("Please wait, Redirecting to your customized page.");
                        System.out.println("+-----------------------------------------------+");
                        Thread.sleep(1500);
                        employeecontroller.searchemployeebyemployeeusername(username);
                        dashboard(employee);
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
                    System.out.println("Enter a correct username or contact Admin.");
                    Thread.sleep(1000); 
                    break;
                }
            }catch(Exception e){
    
                System.out.println(e.getMessage());
    
            }
    
    }while(sucess==false);
    }
    public void dashboard(Employee employee) throws Exception{
        boolean run=true;
            if(employee.isEmployeeloginSession()){
                int dashoption=0;
                do{
                try{
                        System.out.println("");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|          Emp_Dashboard               |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("| Hello..!!                            |");
                        System.out.println("| Welcome To SS Supermarket...         |");
                        System.out.println("|                                      |");
                        System.out.println("| 1. My Account Details.               |");
                        System.out.println("| 2. View Pending orders for packing.  |");
                        System.out.println("| 3. View Pending orders for delivery. |");
                        System.out.println("| 4. My Orders for delivery.           |");
                        System.out.println("| 5. LogOut                            |");
                        System.out.println("+--------------------------------------+");
                        System.out.print("| Enter your choice :");
                        dashoption=Integer.parseInt(scanner.nextLine());
                        System.out.println("+--------------------------------------+");
                        System.out.println();
                        switch (dashoption) {

                            case 1:
                            System.out.println("+------------------------------+");
                            System.out.println("|          My Account          |");
                            System.out.println("+------------------------------+");
                            viewemployee(employee);
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
                            Order order;
                            List<Order> orderlist=ordercontroller.viewprocessedorderslist();
                            if(orderlist.size()==0){
                                System.out.println();
                             System.out.println("Sorry, there is no Orders!!!!");
                             Thread.sleep(2000);;
                             break;}
                            orderview.vieworder(orderlist);
                            System.out.print("| Enter order_id to view order :");
                            int choice=Integer.parseInt(scanner.nextLine());
                            order=ordercontroller.vieworderbyid(choice);
                            orderview.vieworder(order);
                            System.out.println("| 1. View Items Of Order To Pack");
                            System.out.println("| Press any Key for Back<--------------");
                            System.out.print("| Enter Your Choice:");
                           int orderchoice=Integer.parseInt(scanner.nextLine());
                            if(orderchoice==1){
                             orderview.ordereditemsview(order);
                             System.out.println("| 1.To change status to packed");
                             System.out.println("| 2.Back------->");
                             if(scanner.nextInt()==1){
                               order.setStatus(OrderStatus.PACKED);
                               ordercontroller.changeorderstatus(order);
                               System.out.println("Status changed sucessfully!!!!");
                               Thread.sleep(2000);
                               break;
                             }
                             else{
                                break;
                             }
                            }
                            else{
                            System.out.println("Loading...");
                            Thread.sleep(3000);
                             break;
                            }
                            case 3:
                            orderlist=ordercontroller.viewpackedorderslist();
                            if(orderlist.size()==0){
                                System.out.println();
                             System.out.println("Sorry, there is no Orders!!!!");
                             Thread.sleep(2000);;
                             break;}
                            orderview.vieworder(orderlist);
                            System.out.print("| Enter order_id to view order :");
                            choice=Integer.parseInt(scanner.nextLine());
                            order=ordercontroller.vieworderbyid(choice);
                            orderview.vieworder(order);
                            System.out.print("| Address for Delivery:");
                            System.out.print((customercontroller.searchCustomerbycustomerid(order.getCustomer().getId())).getAddress());
                            System.out.println();
                            System.out.println("| 1.To Confirm Delivery. ");
                            System.out.println("| Press any Key for Back<--------------");
                            System.out.print("| Enter Your Choice:");
                            orderchoice=Integer.parseInt(scanner.nextLine());
                            if(orderchoice==1){
                             order.setStatus(OrderStatus.SHIPPED);
                             order.setProvider(employeecontroller.searchemployeebyemployeeusername(employee.getUsername()));
                             ordercontroller.changeorderstatus(order);
                             ordercontroller.setprovider(order);
                             System.out.println("Status changed sucessfully!!!!");
                             Thread.sleep(2000);
                             break;
                            }
                            else{
                            System.out.println("Loading...");
                            Thread.sleep(3000);
                             break;
                            }
                            case 4:
                            orderlist=ordercontroller.viewordersfordeliveryList(employee);
                            if(orderlist.size()==0){
                                System.out.println();
                             System.out.println("Sorry, there is no Orders!!!!");
                             Thread.sleep(2000);;
                             break;}
                            orderview.vieworder(orderlist);
                            System.out.print("| Enter order_id to view order :");
                            choice=Integer.parseInt(scanner.nextLine());
                            order=ordercontroller.vieworderbyid(choice);
                            orderview.vieworder(order);
                            System.out.print("| Address for Delivery:");
                            System.out.print((customercontroller.searchCustomerbycustomerid(order.getCustomer().getId())).getAddress());
                            System.out.println();
                            System.out.println("| 1.To change status to delivered.");
                            System.out.println("| Press any Key for Back<--------------");
                            System.out.print("| Enter Your Choice:");
                            orderchoice=Integer.parseInt(scanner.nextLine());
                            if(orderchoice==1){
                             order.setStatus(OrderStatus.DELIVERED);
                             ordercontroller.changeorderstatus(order);
                             System.out.println("Status changed sucessfully!!!!");
                             Thread.sleep(2000);
                             break;
                            }
                            else{
                            System.out.println("Loading...");
                            Thread.sleep(3000);
                            break;
                            }
                            case 5:
                            run=false;
                            break;
                            
                            default:
                                break;
                        }

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }while(run!=false);

    }
    else{
        System.out.println("+---------------------+");
        System.out.println("### UNAUTHORISATION ###");
        System.out.println("+---------------------+");
        Thread.sleep(4000);
    }
}
    public void manageemployee() throws Exception{
        boolean run =true;
        while(run){
            try{
        int Choice;
        System.out.println("+------------------------------+");
        System.out.println("|       Manage Employees       |");
        System.out.println("+------------------------------+");
        System.out.println("| 1. View Employee.            |");
        System.out.println("| 2. Add new Employee.         |");
        System.out.println("| 3. Delete Existing Employee. |");
        System.out.println("| 4. Go Back.                  |");
        System.out.println("+------------------------------+");
        System.out.print("| Enter your choice :");
        Choice = Integer.parseInt(scanner.nextLine());
        System.out.println("+------------------------------+");
        switch (Choice) {
            case 1:
            try {
                int empChoice=0;
                List<Employee> employeeList = employeecontroller.viewemployee();
                if(employeeList.size()==0){
                    System.out.println();
                    System.out.println("+------------------------------+");
                    System.out.println("Pls Add Employee to Show!!!");
                    System.out.println("+------------------------------+");
                    System.out.println();
                    System.out.println();
                    break;
                }
                viewemployee(employeeList);
                System.out.print("| Enter employeeid...");
              while(true){
                empChoice = Integer.parseInt(scanner.nextLine());
                Employee employee = employeecontroller.viewemployeebyid(empChoice);
                if(employee.getId()==null){
                    System.out.println("Enter Correct Id!!!");
                    continue;
                }
                else{
                    break;
                }
              }
                System.out.println("+------------------------------+\n");
                Employee employee = employeecontroller.viewemployeebyid(empChoice);
                viewemployee(employee);
                System.out.println("| Password  : " + employee.getPassword());
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }  
                break;
            case 2:
            int sucess = 0;
            do {
                try {
                   Employee employee=new Employee();
                   System.out.println();
                   System.out.println("+-------------------------------- +");
                   System.out.println("|          Add Employee           |");
                   System.out.println("+---------------------------------+");
                   System.out.print("| Enter Employee Name :");
                   String Name;
                   while(true){
                   Name = scanner.nextLine();
                   if(validation.validatename(Name)){
                    employee.setName(Name);
                    break;
                   }
                   else{
                    System.out.println("Enter correct Name!!!");
                   }
                   }
                   System.out.print("| Enter Employee Phonenumber :");
                   String number;
                   while(true){
                    number = scanner.nextLine();
                    if(validation.validcustomerphonenumber(number)){
                     employee.setPhonenumber(number);
                     break;
                    }
                    else{
                     System.out.println("Enter correct Phone number!!!");
                    }
                    }
                    employee.setUsername(Name.substring(0, 4)+number.substring(0, 4));
                    employee.setPassword(employeecontroller.generatepassword());
                    employeecontroller.createemployee(employee);
                    employee.setId(employeecontroller.lastinsertedid());
                    System.out.println("+-------------------------------- +");
                    System.out.println("| Employee added sucessfully....  |");
                    System.out.println("+---------------------------------+");
                    Employeeview employeeview=new Employeeview();
                    employeeview.viewemployee(employee);
                    System.out.println("| Password  : " + employee.getPassword());
                    System.out.println();
                    System.out.println("| Share this Username and password with your employee...|");
                    System.out.println();
                    Thread.sleep(3000);
                    System.out.println();
                    sucess=1;
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }while(sucess!=1);
            break;
            case 3:
            try{
            int empChoice=0;
            List<Employee> employeeList = employeecontroller.viewemployee();
            if(employeeList.size()==0){
                System.out.println();
                System.out.println("+------------------------------+");
                System.out.println("Pls Add Employee to Show!!!");
                System.out.println("+------------------------------+");
                System.out.println();
                System.out.println();
                break;
            }
            viewemployee(employeeList);
            System.out.print("| Enter employeeid...");
          while(true){
            empChoice = Integer.parseInt(scanner.nextLine());
            Employee employee = employeecontroller.viewemployeebyid(empChoice);
            if(employee.getName()==null){
                System.out.println("Enter Correct Id!!!");
                continue;
            }
            else{
                break;
            }
          }
            System.out.println("+------------------------------+\n");
            int status = employeecontroller.deleteemployeebyid(empChoice);
            if(status==0){
                System.out.println("+------------------------------+");
                System.out.println("Employee deleted sucessfully..........");
                System.out.println("+------------------------------+");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
            break;
            case 4:
            run=false;
            System.out.println("Loading..........");
            Thread.sleep(3000);
            break;
            default:
                break;
        }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
}
    }
    private void viewemployee(List<Employee> employeelist) {
        System.out.println("+-------------------------------- +");
        System.out.println("|         Employees_List          |");
        System.out.println("+---------------------------------+");
        System.out.println("| id  Product Name              ");
        System.out.println();
        for (Employee employee : employeelist) {
        System.out.println("| " + employee.getId() + ". " + employee.getName());
        }
        System.out.println("+------------------------------+");
    }
}
