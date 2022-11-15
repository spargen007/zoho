package dowhile;

public class dowhi {
	public static void main(String args[]) {
		int v=0;
		int t=5;
		do {
			
			System.out.println("you have "+(t-v)+" seconds to finish the race \n");
			v++;
			
		}while(v!=t);
		System.out.println("race is over \n you may leave now!");
	}

}
