package logincred;

import java.util.Scanner;

public class Password {
	static String s;

    static int charCount = 0;
    static int numCount = 0;
    static  int upCount=0;
    static  int lowCount=0;
    static int specialCount=0;
    static int not=0;
Password(){
	int f=0;
	System.out.print(
            "1. A password must have at least eight characters and maximum of 20 characters.\n" +
            "2. A password consists of only letters,digits and special character.\n" +
            "3. A password must contain at least three digits. \n" +
            "4. A password must contain at least one uppercase. \n" +
            "5. A password must contain at least one lower case. \n" +
            "6. A password must contain at least one special character($,@,#,%,^,&,*,!,?,_,=,).\n" +
            "Input a password (You are agreeing to the above Terms and Conditions.): ");
	while(f==0) {
    Scanner i = new Scanner(System.in);
    s = i.nextLine();
    
    if(passwordlengthcheck(s)) {

    if (is_Valid_Password(s)) {
        System.out.println("\nPassword is valid: " + s);
        f=1;
    } else {
    	if(numCount<3)
    		System.out.println("\n!!!enter atleast 3 number ");
    	if(upCount<1)
    		System.out.println("\n!!!enter atleast one uppercase character");
    	if(lowCount<1)
    		System.out.println("\n!!!enter atleast one lowercase character");
    	if(specialCount<1)
    		System.out.println("\n!!!enter atleast one special character");
    	if(not>0)
    		System.out.println("\n!!!you entered "+not+" wrong characters not included in charcters,digitsand special charcters in condition");
    	
        System.out.println("\n Not a valid password Re-enter it! ");
        f=0;
    }
    }
    else {
    	System.out.println("\n Not a valid password Re-enter it! ");
    f=0;
    }
	}
}
public static String getpass() {
	return s;
}
public static boolean passwordlengthcheck(String password) {
	 if (password.length() < 8 || password.length()>20) {
	    	System.out.println("\n!!!your password size is less than 8 or greater 20");
	    	return false;
	    }
	 else
		 return true;
	
}

public static boolean is_Valid_Password(String password) {
	
    for (int i = 0; i < password.length(); i++) {

        char ch = password.charAt(i);

        if (is_Numeric(ch)) { 
        	numCount++;
        }
        else if (is_Letter(ch)) charCount++;
        else   if(ch == '$' || ch == '#' || ch == '?' || ch == '!' || ch == '_' || ch == '=' || ch == '%' || ch=='@'|| ch=='^'|| ch=='&'|| ch=='*'){
        	specialCount++;
        }
        else {
        	not++;
        }
    }
    


    return (numCount >= 3 && upCount>=1 && lowCount>=1 && specialCount>=1 && not==0);
}

public static boolean is_Letter(char ch) {
	if(ch>='a' && ch<='z') {
		lowCount++;
		return true;
	}
	else if (ch >= 'A' && ch <= 'Z') {
		upCount++;
		return true;
	}
	else
		return false;
}


public static boolean is_Numeric(char ch) {

    return (ch >= '0' && ch <= '9');
}
}
   