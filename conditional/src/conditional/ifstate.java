package conditional;
class cricket{
	String name;
	int batscore=0;
	int bowlspeed=0;
cricket(String name,int age){
	this.name=name;
}
void battingselection(int v) {
	batscore=v;
	if(v>60) {
		System.out.println("the candidate "+name+" is selected for batting.\n");
	}
	else {
		System.out.println("sorry "+name+" you are not selcted for batting\nbetter luck next time\n");
	}
}
void bowlingselection(int x) {
	bowlspeed=x;
	if(bowlspeed<35) {
		System.out.println("sorry "+name+" is not selcted for bowling \nbetter luck next time\n");
	}
	else
		System.out.println("the candidate "+name+" is selected for bowling.\n");
}
void designation() {
	if(batscore>60 && bowlspeed>=35)
		System.out.println("congrats "+name+ " you are allrounder\n");
	else if(batscore>60 && bowlspeed<35)
		System.out.println("congrats "+name+ " you are batsmen\n");
	else
		System.out.println("congrats "+name+ " you are bowler\n");
}
	
}

public class ifstate {
	public static void main(String args[]) {
		cricket c1 =new cricket("monoj",35);
		cricket c2 =new cricket("tom",37);
		cricket c3 =new cricket("sathya",29);
		c1.battingselection(89);
		c1.bowlingselection(20);
		c1.designation();
		c2.battingselection(90);
		c2.bowlingselection(37);
		c2.designation();
		c3.battingselection(10);
		c3.bowlingselection(70);
		c3.designation();
		
		
	}

}
