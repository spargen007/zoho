package Models;

public class Employee extends Person {
    private boolean employeeloginSession = false;
    public Employee(String id,String name,String phonenumber,String username,String password){
        super(id, name, phonenumber, username, password);
    }
    public Employee(){
        
    }
    public boolean isEmployeeloginSession() {
        return employeeloginSession;
    }
    public void setEmployeeloginSession(boolean employeeloginSession) {
        this.employeeloginSession = employeeloginSession;
    }

    
}
