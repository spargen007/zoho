package problem1;
import java.util.*;
class manipulation{
	public int sum(int n) {
		int sum=0;
		while(n!=0){
		sum=sum+n%10;
		n=n/10;
		}
		return sum;
	}
	public int reverse(int n) {
		int s=0;
		while(n!=0) {
			int b=n%10;
			s=s*10+b;
			n=n/10;
		}
		return s;
	}
	
}
public class numbers {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		manipulation mi=new manipulation();
		System.out.println("enter a value of m and n");
		int m,n;
		m=s.nextInt();
		n=s.nextInt();
		for(int i=m;i<=n;i++) {
		if(i!=0) {
		int sumres=mi.sum(i);
		int revres=mi.reverse(sumres);
		if(sumres*revres==i) {
			System.out.println(i);
		}
		
		
		}
	}
	}

}
