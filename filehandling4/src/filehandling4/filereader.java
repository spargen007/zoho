package filehandling4;
import java.io.*;
public class filereader {
	public static void main(String args[])throws Exception{
		try {
		FileReader f=new FileReader("/Users/spargen-pt6214/Desktop/chartest.text");
        int i=0;    
        while((i=f.read())!=-1){    
         System.out.print((char)i);  
	}
        f.close();
		}
		catch(Exception e) {
			System.out.println("error occured");
		}
		}

}