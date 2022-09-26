package exception2;
import java.io.*;

public class checkedex {
	public static void main(String args[]) throws FileNotFoundException {
		
		File f=new File("s.txt");
		try {
		
	    FileInputStream fi = new FileInputStream(f);
		}
		catch(FileNotFoundException e) {
			System.out.println("pls create a file named as given in the program");
		}
		finally{
	    
	    System.out.println("\nHello");
	
		}
		
		}

}
