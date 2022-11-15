package Models;

public class Customer extends Person {
  
    
    private boolean customerloginSession = false;

    private boolean premiummembership=false;
    private String address;
public Customer(String id,String name,String phonenumber,String username,String password,String address,boolean premiummembership){
        super(id, name, phonenumber, username, password);
        this.premiummembership=premiummembership;
        this.address=address;
    }
    public Customer() {
}
    public boolean isPremiummembership() {
        return premiummembership;
    }
    public void setPremiummembership(boolean premiummembership) {
        this.premiummembership = premiummembership;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isCustomerloginSession() {
        return customerloginSession;
    }
    public void setCustomerloginSession(boolean customerloginSession) {
        this.customerloginSession = customerloginSession;
    }
    
}
