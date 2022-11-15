package filehandling2;
import java.io.*;

public class inputstream {
	public static void main(String args[]) {
		try {
			FileInputStream f =new FileInputStream("/Users/spargen-pt6214/Desktop/test.text");
            int i=0;    
            while((i=f.read())!=-1){    
             System.out.print((char)i);  
		}
	}
		catch(Exception e) {
			System.out.println("error occured");
		}

}
}