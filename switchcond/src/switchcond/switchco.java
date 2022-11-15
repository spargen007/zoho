package switchcond;
import java.util.*;

public class switchco {
	public static void main(String args[]) {
		System.out.println("coffee making machine");
		System.out.println("please select one option from our menu\n"
				+ "1.bru coffe\n"+"2.espresso\n"+"3.capuccino\n"+"4.continental\n"+"5.sunrise");
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		switch(t){
		case 1:
			System.out.println("please take and taste your delicious bru coffee with happiness");
			break;
		case 2:
			System.out.println("please take and taste your delicious espresso coffee with happiness");
			break;
		case 3:
			System.out.println("please take and taste your delicious capuccino coffee with happiness");
			break;
		case 4:
			System.out.println("please take and taste your delicious continental coffee with happiness");
			break;
		case 5:
			System.out.println("please take and taste your delicious sunrise coffee with happiness");
			break;
		default:
			System.out.println("sorry sir we don't have any other coffees other than these");
			break;
			
		}
		System.out.println("thank you visit again!!");
	}

}
