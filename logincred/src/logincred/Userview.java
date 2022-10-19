package logincred;

public class Userview {
    static void showdetails(Userdetails user) {
        System.out.println("\n-----//-----//-----\n");
        System.out.println("Name: " + user.getname());
        System.out.println("Age: " + user.getage());
        System.out.println("Gender: " + user.getgender());
        System.out.println("Phone number:  " + user.getphone());
        System.out.println("Aadhar number: " + user.getaadhar());
        System.out.println("cityname:"+user.getcity()+"\n");
    }
}
