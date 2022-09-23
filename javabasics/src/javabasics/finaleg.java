package javabasics;
final class finex{
	final int n=60;
	final void timex() {
		System.out.println("since method is final it can't support ovveride");
	}
}

public class finaleg {
	public static void main(String args[]) {
		finex f =new finex();
		System.out.println("can't able to change final variable "+f.n);
		f.timex();
		System.out.println("can't able to extend final class");
		
	}

}
