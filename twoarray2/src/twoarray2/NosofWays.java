package twoarray2;
import java.util.*;
public class NosofWays {
	public static void main(String args[]){
		int x,y;
		Scanner s=new Scanner(System.in);
		System.out.println("enter no of rows and columns");
		x=s.nextInt();
		y=s.nextInt();
		int no[][]=new int[x][y];
		no[0][0]=1;
		for(int j=1;j<y;j++)
			no[0][j]=1;
		for(int i=1;i<x;i++)
			no[i][0]=1;
		for(int i=1;i<x;i++) {
			for(int j=1;j<y;j++) {// allowed directions is right,down.
				no[i][j]=no[i-1][j]+no[i][j-1];
			}
		}
		System.out.println("enter value of coordinate of end points wihtin "+"("+(x-1)+","+(y-1)+").");
		int u=s.nextInt();
		int v=s.nextInt();
		System.out.println("no of ways from(0,0) to "+"("+(u)+","+(v)+") "+"is"+" "+no[u][v]);
		
		
		
	}

}
