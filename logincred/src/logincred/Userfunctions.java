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
            Main.real();
        } else {
            System.out.println("Invalid Choice !\nEnter correct option");
            function();
        }
		
	}
	 public void details() {
		 boolean t=false;
		System.out.println("\n---- Enter User Information ----\n");
		s.nextLine();
   while(true) {
        System.out.print("Name: ");
        name = s.nextLine();
        if(Exceptionhandling.stringcheck(name))
        	break;
   }
   while(true) {
        System.out.print("Age: ");
        String a = s.nextLine();
        if(Exceptionhandling.integercheck(a)) {
        	age=Integer.parseInt(a);
        	break;
        }
   }
   
        System.out.print("Gender(Male/Female): ");
        gender = s.nextLine();
        
        while(true) {
        	 System.out.print("Phone number: ");
             String a = s.nextLine();
            if(Exceptionhandling.integercheck(a)) {
            	phone=Long.parseLong(a);
            	break;
            }
       }
       
        while(true) {
        	System.out.print("Aadhar number: ");
            String a = s.nextLine();
           if(Exceptionhandling.integercheck(a)) {
           	aadhar=Long.parseLong(a);
           	break;
           }
      }
        
        while(true) {
            System.out.print("City Name: ");
            city = s.nextLine();
            if(Exceptionhandling.stringcheck(city))
            	break;
       }
        
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
		Userview.showdetails(v);}
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
           if (n == 1) {
               System.out.println("\nenter a name ");
               s.nextLine();
               String vi=s.nextLine();
               while(Exceptionhandling.stringcheck(vi)==false) {
               System.out.println("enter again\n");
               vi=s.nextLine();
               }
			   user.setname(vi);
			   System.out.println("\nupdated sucessfully\n");
			   function();
           } else if (n == 2) {
        	   System.out.println("\nenter a age ");
               int vi=s.nextInt();
			   user.setage(vi);
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }  else if (n == 3) {
        	   System.out.println("\nenter a gender ");
        	   s.nextLine();
               String vi=s.nextLine();
			   user.setgender(vi);
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }else if (n == 4) {
        	   System.out.println("\nenter a phone number ");
               long vi=s.nextLong();
			   user.setphone(vi);
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }else if (n == 5) {
        	   System.out.println("\nenter a aadhar number ");
               long vi=s.nextLong();
			   user.setaadhar(vi);
			   System.out.println("\nupdated sucessfully\n");
			   function();
           }  else if (n == 6) {
        	   System.out.println("\nenter a city name ");
        	   s.nextLine();
               String vi=s.nextLine();
               while(Exceptionhandling.stringcheck(vi)==false) {
                   System.out.println("enter again\n");
                   vi=s.nextLine();
                   }
			   user.setcity(vi);
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
             Userview.showdetails(usertemp);
             }
         
     }

}
