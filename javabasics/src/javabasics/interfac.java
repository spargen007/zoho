package javabasics;
interface watches{
	void type();
	void costtype();
	void life();
	
}
class ord implements watches{
	ord(){
		System.out.println("it is an ordinary watch\n");
	}
public void type(){
	System.out.println("type of material is leather");
	}
public void costtype(){
		System.out.println("lower cost ");
		}
public void life(){
		System.out.println("longer life");
		}
}
class iw implements watches{
	iw(){
		System.out.println("it is an smart watch\n");
	}
public void type(){
	System.out.println("type of material is plastic");
	}
public void costtype(){
		System.out.println("higher cost ");
		}
public void life(){
		System.out.println("lower life");
		}
}
public class interfac {
	public static void main(String args[]) {
		watches o=new ord();
		o.type();
		o.costtype();
		o.life();
		System.out.println();
		watches i=new iw();
		i.type();
		i.costtype();
		i.life();
		
		
	}

}
