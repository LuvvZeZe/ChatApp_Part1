//Zaneta Bensah
package ChatApp;

import java.util.Scanner;


public class ChatApplication {


    public static void main(String[] args) {
        System.out.println("Chat Application - Part 1");
        
       
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell number (+27): ");
        String cell = input.nextLine();

        Login user = new Login(username, password, cell, firstName, lastName);

        System.out.println(user.registerUser());
        
        System.out.println("\nLogin Section");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean status = user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(status));
    }
    
}
