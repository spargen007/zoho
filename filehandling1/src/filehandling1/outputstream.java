package filehandling1;
import java.io.*;
import java.util.*;

public class outputstream {
	public static void main(String args[])throws Exception{
		String s="welcome to zoho \n you are now member technical staff of appx team!";
		try {
		FileOutputStream f= new FileOutputStream("/Users/spargen-pt6214/Desktop/test.text");
		byte byt[]=s.getBytes();
		f.write(byt);
		f.close();
		System.out.println("sucessfully executed");
		}
		catch(Exception e) {
			System.out.println("error occured");
		}
	}

}
