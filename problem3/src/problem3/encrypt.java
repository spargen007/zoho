package problem3;
import java.util.*;
public class encrypt{
	public static void main(String args[]) {
		String s;
		String r="";
		int z=0;
		String k;
		Scanner v=new Scanner(System.in);
		System.out.println("enter a text:");
		s=v.nextLine();
		System.out.println("enter a key:");
		k=v.nextLine();
		int temp[]=new int[k.length()];
		int l=0;
		for(int i=0;i<k.length();i++) {
			int u=k.charAt(i);
				temp[l]=u-96;
				l++;
		}
		char c;
		for(int i=0;i<s.length();i++){
			int q=s.charAt(i);
			if(q!=32) {
			int g =(q+temp[z]);
			if((g>90 && g<97)||(g>122)) {
				c=(char)(g-26);
				r=r+c;
			}
			else {
			r=r+(char)g;
			}
			}
			else {
				r=r+" ";
			}
			z++;
			if(z==k.length() || q==32) {
				z=0;
			}
		}
		System.out.println(r);

}
}