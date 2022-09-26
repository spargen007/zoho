package exception1;

public class uncheckedex {
	public static void main(String args[]) {
		try {
			int a=4;
			int v=0;
			System.out.println(a/v);
		}
		catch(ArithmeticException e) {
			System.out.println("invalid coz number can't be divided by zero");
		}
		try {
			int a[]=new int[4];
			System.out.println(a[6]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("\nout of index in array");
			}
		try {
			String s=null;
			System.out.println(s.length());
		}
		catch(NullPointerException e)
		{
			System.out.println("\ninvalid length for null pointer");
			}
		
		}

}
