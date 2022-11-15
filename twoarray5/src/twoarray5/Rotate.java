package twoarray5;
import java.util.*;
public class Rotate {
	static void print(int a[][],int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+" ");
			}	
			System.out.println();
		}
	}
	static void transpose(int a[][],int n) {
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp;
				temp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=temp;
			}
		}
	}
		static void rightrotate(int a[][],int n) {
			transpose(a,n);
			for(int i=0;i<n;i++) {
			int l=0;
			int h=n-1;
			while(l<h) {
				int temp=a[i][l];
				a[i][l]=a[i][h];
				a[i][h]=temp;
			l++;
			h--;
			}
			}
			print(a,n);
			return;
			
		}
		static void leftrotate(int a[][],int n) {
			transpose(a,n);
			for(int i=0;i<n;i++) {
			int l=0;
			int h=n-1;
			while(l<h) {
				int temp=a[l][i];
				a[l][i]=a[h][i];
				a[h][i]=temp;
			l++;
			h--;
			}
			}
			print(a,n);
		}

		
	public static void main(String args[]) {
		System.out.println("enter value of n");
		Scanner s=new Scanner (System.in);
		int n=s.nextInt();
		int a[][]=new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println("for "+i+","+j+":");
				a[i][j]=s.nextInt();
			}	
		}
		System.out.println("before rotation");
		print(a,n);
		System.out.println("after right rotation");
		rightrotate(a,n);
		System.out.println("after left rotation");
		leftrotate(a,n);
		
		
	}

}
