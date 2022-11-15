package javabasics;


class vehicle{
	String engine;
	String wheels;
	int maxspeed;
	vehicle(){
		engine="petrol engine";
		wheels="2 wheeler";
		maxspeed=100;
	}
}
class bike extends vehicle{
	void run() {
		System.out.println("bike is running");
	}
}
class scooty extends bike{
	void run() {
		System.out.println("scooty is running");
	}
	void stopp(){
		System.out.println("end");
	}
}
public class inheritance {
public static void main(String args[]) {
	bike b=new bike();
	scooty s=new scooty();
	System.out.println("type of bike engine is "+b.engine);
	System.out.println("wheels in bike is "+b.wheels);
	System.out.println("maximum speed of bike is "+b.maxspeed);
	b.run();
	System.out.println();
	System.out.println("type of scooty engine is "+s.engine);
	System.out.println("wheels in scooty is "+s.wheels);
	System.out.println("maximum speed of scooty is "+s.maxspeed);
	s.run();
	s.stopp();
	
	
	
	
}

}
