package javabasics;
import java.util.*;
import java.io.*;
//method overloading-compile time polymorphism
class medium{
	void convert(int a) {
		System.out.println("solid is converted into liquid");
		
	}
	void convert(double d) {
		System.out.println("liquid is converted in to solid");
	}
}

public class polymorphism1 {
	public static void main(String args[]) {
		medium m=new medium();
		System.out.println("for solid to liquid conversion integer is passed.\nfor liquid to solid conversion double is passed. \nso either enter integer or double value!. ");
		Scanner s=new Scanner(System.in);
		if(s.hasNextInt()) {
			m.convert(1);
		}
		else if(s.hasNextDouble()) {
			m.convert(1.11);
		}
		else {
			System.out.println("invalid input");
		}
		
	}

}
