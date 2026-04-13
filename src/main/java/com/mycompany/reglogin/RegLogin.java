/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reglogin;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;
import java.util.regex.Pattern;
public class RegLogin {
 

      
// Main Application Class (Filename must match this: RegistrationApp.java)

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login authSystem = new Login();

        // 1. Registration Phase
        System.out.println("--- Register Account ---");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        System.out.print("Enter Username: ");
        String user = input.nextLine();
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        System.out.print("Enter SA Phone Number (e.g., +27...): ");
        String phone = input.nextLine();

        // Register the user and get the result message
        String regMessage = authSystem.registerUser(user, pass, phone);
        System.out.println("\n" + regMessage);

        // 2. Login Phase - Only proceeds if registration worked
        if (regMessage.contains("successfully captured")) {
            System.out.println("\n--- Login ---");
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            boolean isSuccess = authSystem.loginUser(loginUser, loginPass);
            System.out.println(authSystem.returnLoginStatus(isSuccess, fName, lName));
        }
        
        input.close();
    }
}

// Logic Class (Removed 'public' so it can live in the same file as RegistrationApp)
class Login {
    private String username;
    private String password;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // Must contain: Capital, Number, Special Char, and be at least 8 chars
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    public boolean checkPhone(String phone) {
        // Regex to ensure it starts with +27 or 27
        String phoneRegex = "^(\\+27|27)[0-9]{7,9}$"; 
        return Pattern.compile(phoneRegex).matcher(phone).matches();
    }

    public String registerUser(String user, String pass, String phone) {
        if (!checkUserName(user)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (!checkPhone(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        } else {
            this.username = user;
            this.password = pass;
            return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
        }
    }

    public boolean loginUser(String user, String pass) {
        // Checks if the entered credentials match the registered ones
        return user.equals(this.username) && pass.equals(this.password);
    }

    public String returnLoginStatus(boolean loggedIn, String fName, String lName) {
        if (loggedIn) {
            return "Welcome " + fName + ", " + lName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
    

