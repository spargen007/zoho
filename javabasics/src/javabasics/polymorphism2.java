package javabasics;
import java.util.*;
// method over riding- run time polymorphism
class character{
	static StringBuilder s;
	character(){
		s=new StringBuilder("tom");
	}
	character(String t){
		s=new StringBuilder(t);
	}
}
class office extends character{
	void run() {
		System.out.println(s+" is a employee in office\n");
	}
}
class house extends character {
	void run() {
		System.out.println(s+" is a parent in house\n");
	}
}
class games extends character{
	void run() {
		System.out.println(s+" is a player in game\n");
	}
}
public class polymorphism2 {
	public static void main(String args[]) {
		office f=new office();
		house h=new house();
		games g=new games();
		f.run();
		h.run();
		g.run();
		character c=new character("mark");
		f.run();
		h.run();
	}

}
