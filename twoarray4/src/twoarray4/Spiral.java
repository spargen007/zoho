package twoarray4;
import java.util.*;
public class Spiral {
	static void spirall(int x,int y,int a[][]) {
		int i,u=0,v=0;
		while(u<x && v<y) {
			for(i=v;i<y;i++) {
				System.out.print(a[u][i]+" ");
			}
			u++;
			for(i=u;i<x;i++) {
				System.out.print(a[i][y-1]+" ");
			}
			y--;
			if(u<x) {
				for(i=y-1;i>=v;i--) {
					System.out.print(a[x-1][i]+" ");
				}
				x--;
			}
			if(v<y) {
				for(i=x-1;i>=u;i--) {
					System.out.print(a[i][v]+" ");
				}
				v++;
			}
			
		}
		
	}
	public static void main(String args[]) {
		int x,y;
		Scanner s=new Scanner(System.in);
		System.out.println("enter no of rows and columns");
		x=s.nextInt();
		y=s.nextInt();
		System.out.println("enter elements of matrix");
		int a[][]=new int[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.println("for "+i+","+j+":");
				a[i][j]=s.nextInt();
			}	
		}
		System.out.println("matrix form");
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("printing elements in spiral order");
		spirall(x,y,a);
	}

}
