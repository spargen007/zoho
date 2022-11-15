package Validation;



public class Customer_Validation {
    public boolean validatename(String customerUsername) throws Exception {
        if (customerUsername.matches("^[A-Za-z][A-Za-z0-9 ]{3,20}$")) {
                return true;
        } else {
            throw new Exception("The name you entered is not valid. try again!");
        }
    }
    public boolean validcustomerusername(String customerUsername) throws Exception {
        if (customerUsername.matches("[a-z]\\w{6,30}")) {
                return true;
        } else {
            throw new Exception("The username you entered is not valid.\nYour username needs to:\n * include only lowercase characters.\n * be at least 5 characters long.");
        }
    }
    public boolean validcustomerpassword(String customerPassword) throws Exception {
        if (customerPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$")) {
            return true;
        }
        throw new Exception("The password you entered is not valid. \nYour password needs to:\n * include both lower and uppercase characters.\n * include at least one number or symbol.\n * be at least 8 characters long.");
    }
    public boolean validcustomerphonenumber(String customernumber) throws Exception {
        if (customernumber.matches("^(0/91)?[7-9][0-9]{9}$")) {
            return true;
        }
        throw new Exception("The phonenumber you entered is not valid.");
    }

    
}
