package customexception;
import java.util.*;
import java.io.*;
class underageException extends Exception {
	   private int age;
	   
	   public underageException(int a ) {
	      age = a;
	   }
	   
	   public int getage() {
	      return age;
	   }
	}
class voterchecking{
	public void checkage(int v) throws underageException {
		if(v>=18) {
			System.out.println("congrats you are eligible to vote.!");
		}
		else {
			throw new underageException(v);
		}
	}
}

public class userdef {
	public static void main(String args[]) {
		voterchecking c=new voterchecking();
		Scanner s=new Scanner(System.in);
		try {
			System.out.println("welcome to eligibility test of voting\nenter your age");
			int t=s.nextInt();
			c.checkage(t);
		} catch (underageException e) {
			System.out.println("sorry candidate you are not eligible to vote because you are only aged "+e.getage());
		}
		
	}

}
