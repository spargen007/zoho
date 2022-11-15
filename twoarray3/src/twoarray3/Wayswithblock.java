package twoarray3;
import java.util.*;
public class Wayswithblock {
	public static void main(String args[]){
		int x,y,p,u,v;
		Scanner s=new Scanner(System.in);
		System.out.println("enter no of rows and columns and blockage");
		x=s.nextInt();
		y=s.nextInt();
		p=s.nextInt();
		int no[][]=new int[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				no[i][j]=0;
			}
		}
		System.out.println("enter coordinates of blockage");
		for(int i=1;i<=p;i++) {
			System.out.println(i+" blockage: ");
			u=s.nextInt();
			v=s.nextInt();
			no[u][v]=-1;
		}
		if(no[0][0]==-1) {
			System.out.println("0 ways");
			return;
		}
		for(int j=1;j<y;j++) {
		if(	no[0][j]==0) {
			no[0][j]=1;
		}
			else
				break;
		}
		for(int i=1;i<x;i++) {
			if(	no[i][0]==0) {
				no[i][0]=1;
			}
				else
					break;
			}
		for(int i=1;i<x;i++) {
			for(int j=1;j<y;j++) {// allowed directions is right,down.
				if(no[i][j]==-1)
					continue;
				if(no[i-1][j]>0) {
					no[i][j]=no[i][j]+no[i-1][j];
				}
				if(no[i][j-1]>0) {
					no[i][j]=no[i][j]+no[i][j-1];
					}
			}
		}
		System.out.println("enter value of coordinate of end points wihtin "+"("+(x-1)+","+(y-1)+").");
		int k=s.nextInt();
		int l=s.nextInt();
		if(no[k][l]>=0) {
			
		System.out.println("no of ways from(0,0) to "+"("+k+","+l+") "+"is"+" "+no[k][l]);
		}
		else {
			System.out.println("0 ways");
		}
		
		
	}

}
