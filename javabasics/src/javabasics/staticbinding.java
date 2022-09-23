package javabasics;
class devices{
	void start() {
		System.out.println("ordinary device\n");
	}
}
class mobile extends devices{
	void start() {
		System.out.println("iphone device!.\n");
	}
}


public class staticbinding {
	public static void main(String args[]) {
		devices s=new devices();
		s.start();
		devices v=new mobile();
		v.start();
	}

}
