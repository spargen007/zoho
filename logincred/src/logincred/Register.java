package logincred;
import java.util.*;
public class Register {
    static HashMap<String,String> m=new HashMap<String, String>();
	String username;
	String password;
	Register(String username,String password){
		this.username=username;
		this.password=password;
	}
	Register() {
		String u,p;
		//Scanner s=new Scanner(System.in);
		System.out.println("welcome to registration\n");
		System.out.println("enter user id:");
		new Userid();
		u=Userid.getuser();
		System.out.println();
		System.out.println("enter passsword");
		new Password();
		p=Password.getpass();
		Register r=new Register(u,p);
		m.put(r.username,r.password);
		System.out.println("\nRegistered sucessfully\n");
	}

}
