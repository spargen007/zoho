package javabasics;
class books{
	 String name;
	 String author;
	 int id;
	 books(){
		name=null;
		author=null;
		id=0;
		
	 }
	 books(String name,String author,int id){
		 this.name=name;
		 this.author=author;
		 this.id=id;
	 }
}
class books2{
	 static String name1;
	 static String author1;
	 static int id1;
	 books2(){
		name1=null;
		author1=null;
		id1=0;
		
	 }
	 books2(String name,String author,int id){
		 name1=name;
		 author1=author;
		 id1=id;
	 }
}

public class staticandclass {
	public static void main(String args[]) {
		books b1=new books("wings","abdhul",1);
		books2 b2=new books2("things","mark",2);
		books b11=new books();
		books2 b22=new books2();
		System.out.println("before replacing name :");
		System.out.println();
		System.out.println("name = "+b1.name+" auhtor = "+b1.author+" "+"id = "+b1.id);
		System.out.println("name = "+b2.name1+" auhtor = "+b2.author1+" "+"id = "+b2.id1+"\n");
		b11.name="tom";
		b22.name1="harry";
		System.out.println("after replacing name: the effect of using static keyword");
		System.out.println();
		System.out.println("name = "+b1.name+" auhtor = "+b1.author+" "+"id = "+b1.id);
		System.out.println("name = "+b2.name1+" auhtor = "+b2.author1+" "+"id = "+b2.id1);
		
	}

}
