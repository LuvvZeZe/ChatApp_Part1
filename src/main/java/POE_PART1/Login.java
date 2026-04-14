//Zaneta Bensah
package POE_PART1;


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
public boolean checkCellPhoneNumber() {
    if (cellPhoneNumber == null) {
        return false;
    }

    if (!cellPhoneNumber.startsWith("+27")) {
        return false;
    }

    String digits = cellPhoneNumber.substring(3);

    if (digits.length() != 9) {
        return false;
    }

    for (char c : digits.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }

    return true;
}
}
