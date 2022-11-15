package View;

import java.util.Scanner;

public class Adminview {
    Scanner scanner =new Scanner(System.in);
    Itemview itemview=new Itemview();
    Orderview orderview=new Orderview();
    Employeeview employeeview =new Employeeview();
    public void loginadmin() {
        System.out.println("+********************************+");
        System.out.println("|        Admin Login             |");
        System.out.println("+********************************+");
        System.out.println("| Welcome To Admin login..       |");
        System.out.print("| Enter password :");
        String password=scanner.nextLine();
        if(password.equals("SSsupermarket2022")){
        boolean run=true;
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
                        System.out.println("| 1. To Manage Products.               |");
                        System.out.println("| 2. To Manage Employees.              |");
                        System.out.println("| 3. To view Total Sales report.       |");
                        System.out.println("| 4. To Update discount.               |");
                        System.out.println("| 5. LogOut                            |");
                        System.out.println("+--------------------------------------+");
                        System.out.print("| Enter your choice :");
                        dashoption=Integer.parseInt(scanner.nextLine());
                        switch (dashoption) {
                            case 1:
                            itemview.manageitems();
                            break;
                            case 2:
                            employeeview.manageemployee();
                            break;
                            case 3:
                            break;
                            case 4:
                            break;
                            case 5:
                            run=false;
                            break;
                            default:
                                break;
                        }
                }catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }while(run);
    }
    else{
        System.out.println("Incorrect password!!! pls try again!!!");
    }
}
    
}