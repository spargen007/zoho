package javabasics;
class primitive{
	int a=45;
	short b=32767;
	float c=6.65f;
	long d=1234567;
	float e=1.22f;
	double f=8.90276;
	char g='w';
	void shorttoint() {
		int a1=b;
		System.out.println("short to integer "+a1);
		
	}
	void inttoshort() {
		short a2=(short)a;
		System.out.println("integer to short "+a2);
	}
	void inttolong() {
		long a3=a;
		System.out.println("int to long "+a3);
	}
	void longtoint() {
		int a4=(int)d;
		System.out.println("long to int "+a4);
		}
	void inttochar() {
		char a5=(char)a;
		System.out.println("int to character "+a5);
	}
	void chartoint() {
		int a6=g;
		System.out.println("char to int "+a6);
	}
	void inttofloat() {
		float a7=a;
		System.out.println("int to float "+a7);
	}
	void floattoint() {
		int a8=(int)e;
		System.out.println("float to int "+a8);
		
	}
}
class nonprimitive{
	String s="zoho";
	String v=null;
	void non() {
		System.out.println("non primitve data type is String example : "+s);
	}
	
	
}

public class datatypes {
	public static void main(String args[]) {
		primitive p= new primitive();
		nonprimitive n=new nonprimitive();
		p.shorttoint();
		p.inttoshort();
		p.inttolong();
		p.longtoint();
		p.inttochar();
		p.chartoint();
		p.inttofloat();
		p.floattoint();
		n.non();
		
		
	}

}
