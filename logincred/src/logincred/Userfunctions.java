package logincred;
import java.util.*;
public class Userfunctions {
	static String name;
	static int age;
	static String gender;
	static long phone;
	static long aadhar;
	static String city;
    Userdetails user;
	static HashMap<String,Userdetails> details =new HashMap<String, Userdetails>();
	static Scanner s= new Scanner(System.in);
	public void function() {
		System.out.println("\n-----welcome to user function portal-----\n");
        System.out.println("    ** Enter 1 to enter details");
        System.out.println("    ** Enter 2 to display details ");
        System.out.println("    ** Enter 3 to edit details");
        System.out.println("    ** Enter 4 to print all users details");
        System.out.println("    ** Enter 5 to go to main page");
        System.out.print("Enter Choice : ");
        
        int n = s.nextInt();
        if (n == 1) {
            details();
            function();
        } else if (n == 2) {
            viewdetails();
            function();
        }  else if (n == 3) {
            update();
            function();
        }else if (n == 4) {
            allusers();
            function();
        }else if (n == 5) {
            new Main();
        } else {
            System.out.println("Invalid Choice !\nEnter correct option");
            function();
        }
		
	}
	 public void details() {
		System.out.println("\n---- Enter User Information ----");
      
        System.out.print("Name: ");
        s.nextLine();
        name = s.nextLine();

        System.out.print("Age: ");
        age = s.nextInt();

        System.out.print("Gender(Male/Female): ");
        s.nextLine();
        gender = s.nextLine();

        System.out.print("Phone number: ");
        phone = s.nextLong();

        System.out.print("Aadhar number: ");
        aadhar = s.nextLong();
        
        System.out.print("City Name: ");
        s.nextLine();
        city = s.nextLine();
        
        user = new Userdetails(name, age, gender, phone, aadhar,city);
        System.out.println("\n-----///----- details added!!! -----///-----");
        details.put(Loginscreen.loginuserid,user);
	}
     void viewdetails() {
		Userdetails v=details.get(Loginscreen.loginuserid);
		if(v==null) {
			System.out.println("\nfirst enter details correctly to display!");
			function();
		}
		else {
		v.showdetails();}
	}
     void update() {
    	 System.out.println("\n---- Edit user Information ----");
    	   System.out.println("    ** Enter 1 to edit name");
           System.out.println("    ** Enter 2 to edit age ");
           System.out.println("    ** Enter 3 to edit gender");
           System.out.println("    ** Enter 4 to edit phone number");
           System.out.println("    ** Enter 5 to edit aadhar number");
           System.out.println("    ** Enter 6 to edit city name");
           System.out.print("Enter Choice : ");
           int n = s.nextInt();
           Userdetails userdetails = new Userdetails();
           if (n == 1) {
               System.out.println("\nenter a name ");
               s.nextLine();
               String vi=s.nextLine();
			   user.setname(vi);
			   name=user.getname();
			   System.out.println("\nupdated sucessfully\n");
			   function();
           } else if (n == 2) {
        	   System.out.println("\nenter a age ");
               int vi=s.nextInt();
			   user.setage(vi);
			   age=user.getage();
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }  else if (n == 3) {
        	   System.out.println("\nenter a gender ");
        	   s.nextLine();
               String vi=s.nextLine();
			   user.setgender(vi);
			   gender=user.getgender();
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }else if (n == 4) {
        	   System.out.println("\nenter a phone number ");
               long vi=s.nextLong();
			   user.setphone(vi);
			   phone=user.getphone();
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }else if (n == 5) {
        	   System.out.println("\nenter a aadhar number ");
               long vi=s.nextLong();
			   user.setaadhar(vi);
			   aadhar=user.getaadhar();
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }  else if (n == 6) {
        	   System.out.println("\nenter a city name ");
        	   s.nextLine();
               String vi=s.nextLine();
			   user.setcity(vi);
			   city=user.getcity();
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }else {
               System.out.println("Invalid Choice !\nEnter correct option");
               update();
           }
           details.put(Loginscreen.loginuserid,user);
     }
     void allusers() {
         for (Map.Entry<String, Userdetails> individualuser : details.entrySet()) {
             System.out.print("userid"+"="+individualuser.getKey()+"\n");
             Userdetails usertemp=individualuser.getValue();
             usertemp.showdetails();
             }
         
     }
	public static void main(String args[]) {
		Userfunctions t =new Userfunctions();
		t.function();

	}

}
