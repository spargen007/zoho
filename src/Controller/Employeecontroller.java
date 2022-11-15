package Controller;

import java.util.List;
import java.util.Random;

import Database.Employeedbcontroller;
import Models.Employee;

public class Employeecontroller {
    Employeedbcontroller employeedbcontroller=new Employeedbcontroller();
public String generatepassword(){
    String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String specialCharacters = "!@#$";
    String numbers = "1234567890";
    String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
    Random random = new Random();
    char[] password = new char[8];

    password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
    password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
    password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    password[3] = numbers.charAt(random.nextInt(numbers.length()));
 
    for(int i = 4; i< 8 ; i++) {
       password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
    }
    String passwordstring=new String(password);
    return passwordstring;
}

public int createemployee(Employee employee) throws Exception{
    return employeedbcontroller.createemployee(employee);
  }
  public String lastinsertedid(){
    return employeedbcontroller.lastinsertedid();
  }


    public List<Employee> viewemployee() throws Exception {
        return employeedbcontroller.viewemployee();
    }


    public Employee viewemployeebyid(int empChoice) throws Exception {
        return employeedbcontroller.viewemployeebyid(empChoice);
    }


    public int deleteemployeebyid(int empChoice) throws Exception {
        return employeedbcontroller.deleteemployeebyid(empChoice);
    }


    public boolean isemployeeusernamealreadyexit(String username) throws Exception {
        return employeedbcontroller.isemployeeusernamealreadyexit(username);
    }


    public boolean passwordcheck(String username, String password) throws Exception {
        return employeedbcontroller.passwordcheck(username, password);
    }


    public Employee searchemployeebyemployeeusername(String username) throws Exception {
        return employeedbcontroller.searchemployeebyusername(username);
    }
}

