//Zaneta Bensah
package ChatApp;


public class Login 
{
     private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        
        // Username must contain "_" and be no more than 5 characters
}
    public boolean checkUserName() {
    return username.contains("_") && username.length() <= 5;
}
public boolean checkPasswordComplexity() {
    if (password == null || password.length() < 8) {
        return false;
    }

    boolean hasUpperCase = false;
    boolean hasDigit = false;
    boolean hasSpecialChar = false;

    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) {
            hasUpperCase = true;
        } else if (Character.isDigit(c)) {
            hasDigit = true;
        } else if (!Character.isLetterOrDigit(c)) {
            hasSpecialChar = true;
        }
    }

    return hasUpperCase && hasDigit && hasSpecialChar;
}

//Cell phone validation using REGEX
    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber != null
                && cellPhoneNumber.matches("^\\+27\\d{9}$");
    }
    
public String registerUser() {

    if (!checkUserName()) {
        return "Username is not correctly formatted: please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted: please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    if (!checkCellPhoneNumber()) {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
}

public boolean loginUser(String enteredUsername, String enteredPassword) {
    return enteredUsername.equals(username) && enteredPassword.equals(password);
}

public String returnLoginStatus(boolean status) {
    if (status) {
        return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
}


}
