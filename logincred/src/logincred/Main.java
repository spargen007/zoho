package logincred;
import java.util.*;
public class Main {
	static Scanner v=new Scanner(System.in);
	public static void real(){
		System.out.println("\n-----user-details-management-----\n");
        System.out.println("    *** Enter 1 for Login");
        System.out.println("    *** Enter 2 for register");
        System.out.println("    *** Enter 3 to exit\n");
        System.out.print("Enter Choice : ");
        int n = v.nextInt();
        if (n == 1) {
            new Loginscreen();
            real();
        } else if (n == 2) {
            new Register();
            real();
        } else if (n == 3) {
            System.exit(0);
        } else {
            System.out.println("Invalid Choice !\nEnter correct option");
            real();
        }
	}
	public static void main(String args[]) {
		real();
		
	}

}
