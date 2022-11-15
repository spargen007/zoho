package twoarray1;
import java.util.*;
public class Mincostarray {
	public static void main(String args[]){
		int x,y;
		Scanner s=new Scanner(System.in);
		System.out.println("enter no of rows and columns");
		x=s.nextInt();
		y=s.nextInt();
		int a[][]=new int[x][y];
		System.out.println("enter cost values for matrix\n");
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.println("for "+i+","+j+":");
				a[i][j]=s.nextInt();
			}	
		}
		int minn[][]=new int[x][y];
		minn[0][0]=a[0][0];
		for(int j=1;j<y;j++)
			minn[0][j]=minn[0][j-1]+a[0][j];
		for(int i=1;i<x;i++)
			minn[i][0]=minn[i-1][0]+a[i][0];
		for(int i=1;i<x;i++) {
			for(int j=1;j<y;j++) {// allowed directions is right,down and diagonal
				minn[i][j]=Math.min(Math.min(minn[i-1][j],minn[i][j-1]),minn[i-1][j-1])+a[i][j];
			}
		}
		System.out.println("minimum cost from(0,0) to "+"("+(x-1)+","+(y-1)+") "+"is"+" "+minn[x-1][y-1]);
		
		
		
	}

}
