package filehandling3;
import java.io.*;
public class filewriter {
	public static void main(String args[])throws Exception{
		String s="the journey of thousand miles begins with one step";
		try {
		FileWriter f=new FileWriter("/Users/spargen-pt6214/Desktop/chartest.text");
		f.write(s);
		f.close();
		System.out.println("file is created sucessfully");
		}
		catch(Exception e) {
			System.out.println("error occured");
		}
		}

}
