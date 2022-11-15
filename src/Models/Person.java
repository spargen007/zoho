package Models;

public  class Person {
    private String id;
    private String name;
    private String phonenumber;
    private String username;
    private String password;
   public Person(){}
    public Person(String id, String name, String phonenumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
