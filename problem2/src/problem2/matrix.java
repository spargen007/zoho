package problem2;
import java.util.*;
class manip{
	public void matrix(int mat[][]) {
		int n=mat.length,jt=0;
		int t[]=new int[n*n];
		int p[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				t[jt++]=mat[i][j];
			}
		}
		Arrays.sort(t);
		int k=0;
		for(int i=0;i<n;i++) {
			if(i%2==0) {
		for(int j=0;j<n;j++) {
			p[i][j]=t[k];
			k++;
		}
			}
			else {
	    for(int j=n-1;j>=0;j--) {
	    	p[i][j]=t[k];
	    	k++;
	    }
			}
		}
		System.out.println("\nprinting modified matrix\n");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(p[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}

public class matrix {
	public static void main(String args[]) {
        int mat[][] = { { 5,8,9 }, { 1,4,6 },{ 7,2,3 } };
        System.out.println("before modification\n");
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
        
        manip y=new manip();
        y.matrix(mat);
        
        
	}

}
