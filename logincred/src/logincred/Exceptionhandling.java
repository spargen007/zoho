package logincred;

public class Exceptionhandling {
	public static  boolean stringcheck(String s) {
		if(s!=null && s.matches("^[a-zA-z ]*$")){
		return true;	
		}
		else {
		System.out.println("enter letters only");
		return false;
		}
	}
public static boolean integercheck(String s) {	
	if(s!=null && s.matches("^[0-9]*$")){
	return true;	
	}
	else {
	System.out.println("enter numbers only");
	return false;
	}
}

}
