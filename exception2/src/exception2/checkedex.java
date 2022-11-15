package exception2;
import java.io.*;

public class checkedex {
	public static void main(String args[]) throws IOException{
		try {
		
	    FileInputStream fi = new FileInputStream("/Users/spargen-pt6214/Desktop/fit.text");
	       int i;
	       char c;
        while((i = fi.read())!=-1) {
        
           c = (char)i;
           
           System.out.print(c);
        }
	    
		}
	   catch(FileNotFoundException e) {
			System.out.println("pls create a file named as given in the program");
		}
		finally{
	    
	    System.out.println("\nHello");
	
		}
		
		}

}
