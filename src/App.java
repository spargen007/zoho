
import java.util.*;
import View.Adminview;
import View.Customerview;
import View.Employeeview;
public class App {
    public static void main(String[] args) throws Exception {
        Customerview customerview=new Customerview();
		Adminview adminview= new Adminview();
		Employeeview employeeview=new Employeeview();
		try (Scanner scanner = new Scanner(System.in)) {
			int menuChoice=0;
				do{
					try {
						System.out.println("");
						System.out.println();
				        System.out.println("+-------------------------------- +");
				        System.out.println("|    Welcome To SS supermarket    |");
				        System.out.println("+---------------------------------+");
				        Thread.sleep(500);
				        System.out.println("|    Amazing finds only here!     |");
				        Thread.sleep(1000);
				        System.out.println("|                                 |");
				        System.out.println("| 1. New Customer Registration    |");
				        System.out.println("| 2. Customer Login               |");
				        System.out.println("| 3. Employee Login               |");
						System.out.println("| 4. Admin Login                  |");
				        System.out.println("| 5. Exit                         |");
				        System.out.println("+---------------------------------+");
				        System.out.print("| Choose your option :");
				        menuChoice = Integer.parseInt(scanner.nextLine());
				        System.out.println("+---------------------------------+");
				        switch (menuChoice) {
				            case 1:
				                customerview.registercustomer();
				                break;
				            case 2:
				                customerview.logincustomer();
				                break;
				            case 3:
				                employeeview.loginemployee();
				                break;
							case 4:
						        adminview.loginadmin();
						     	break;
				            case 5:
				                System.out.println("Oh no! You're leaving");
				                System.out.println("Bye!!");
				                System.exit(0);
				                break;
				            default:
				              System.out.println("Invalid Input : Please enter numbers between (1-4)...");
							  break;
				        }
					}
				catch (InterruptedException | NumberFormatException e) {
						System.out.println();
						System.out.println("Pls Enter Correct Option!!!!");
					}

				    } while (true);
		}

    }
}
