package javabasics;
abstract class employee{
	employee(){
		System.out.println("new employee found\n");
	}
	void worktype() {}
	
}
class soft extends employee{
	void worktype() {
		System.out.println("i am software engineer working for software development\n");
	}
}
class elect extends employee{
	void worktype() {
		System.out.println("i am electrical engineer working for electrical department\n");
	}
}
class teach extends employee{
	void worktype() {
		System.out.println("i am teacher\n");
	}
}
public class abstractclass {
	public static void main(String args[]) {
		employee s=new soft();
		s.worktype();
		employee e=new elect();
		e.worktype();
		employee t=new teach();
		t.worktype();
		
	}

}
