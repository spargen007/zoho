package logincred;
import java.util.*;
public class Loginscreen{
	static String loginuserid;
	String loginpassword;
	Loginscreen(){
		Scanner s=new Scanner(System.in);
		System.out.println("             **************welcome to user portal**************\n");
		System.out.print("             userid:");
		loginuserid=s.next();
		System.out.println();
		System.out.print("             password:");
		loginpassword=s.next();
		String temp=Register.m.get(loginuserid);
		if(loginpassword.equals(temp)) {
			Userfunctions u = new Userfunctions();
			u.function();
		
		}
		else {
			System.out.println("\ninvalid credentials");
		
		}
	}
	public static void main(String args[]) {
//		Scanner s=new Scanner(System.in);
//		String u,p;
//		System.out.println("             **************welcome to user portal**************\n");
//		System.out.print("             userid:");
//		u=s.next();
//		System.out.println();
//		System.out.print("             password:");
//		p=s.next();
//		String temp=Register.m.get(u);
//		System.out.println(temp);
//	}
		new Loginscreen();

}
}
