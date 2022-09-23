package whilecondition;

import java.util.Scanner;

public class condwhile {
	public static void main(String args[]) {
		int g,f=1;
		int ques=35;
		boolean ans=true;
		System.out.println("welcome to number guessing game\n");
		Scanner s=new Scanner(System.in);
		System.out.println("enter any one number from 1 to 50\n");
		while(ans) {
			g=s.nextInt();
			if(g>50) {
				System.out.println("invalid input pls enter any one number from 1 to 50\n");
				f++;
			}
			else {
			
			if(g>ques) {
				System.out.println("your guess is higher\ntenter again");
				f++;
			}
			else if(g<ques) {
				System.out.println("your guess is lower\nenter again");
				f++;
			}
			else {
				System.out.println("congrats you entered a right number "+ques+" in "+f+" guesses");
				ans=false;
			}
		}
			
		
		}
	}

}
