package logincred;
import java.util.*;
import java.util.regex.*;
public class Userid {
	static String v;
	Userid(){
		System.out.print(
	            "1. A userid must have at least six characters and maximum of 30 characters.\n" +
	            "2. A userid consists of only letters,digits,hypen and underscore.\n" +
	            "3. The first and last character of the username must be an alphabetic character. \n"+
	            "4. The last character of the username must be an alphanumeric character. \n"
	            + "\nInput a userid (You are agreeing to the above Terms and Conditions.): ");
		Scanner s=new Scanner(System.in);
		boolean t;
		int f=0;
		while(f==0) {
		v=s.nextLine();
		t=valid(v);
		if(t) {
		     System.out.println("\n username  is valid: " + v);
		     f=1;
		}
		else {
		     System.out.println("\nusername is invalid : Re-enter it ");
		     f=0;
		}
		}
	}

    public static boolean valid(String name) 
    { 
    	String r="^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){3,28}[a-zA-Z0-9]$";
    	
        Pattern p = Pattern.compile(r); 

        if (name == null) { 
            return false; 
        } 
        Matcher m = p.matcher(name); 

        return m.matches(); 
    } 
    public static String getuser() {
    	return v;
    }
	public static void main(String args[]) {

		new Userid();
	}

}
