package logincred;
import java.util.*;
public class Loginscreen{
	Userfunctions u = new Userfunctions();
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
		
			u.function();
		
		}
		else {
			System.out.println("\ninvalid credentials");
		
		}
	}
}
