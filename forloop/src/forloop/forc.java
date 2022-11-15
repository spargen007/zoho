package forloop;
import java.util.*;

public class forc {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		System.out.println("dispaly even numbers upto n");
		System.out.println("enter a value of n");
		int x;
		x=s.nextInt();
		for(int i=0;i<x;i++) {
			if(i%2==0)
				System.out.print(i+" ");
			
		}
	}

}
