/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reglogin;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner; // Required as per your last request
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegApp {
    

public class Login {
    private String username;
    private String password;

    // 1. Username Validation
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Password Complexity Validation
    public boolean checkPasswordComplexity(String password) {
        // Must contain: Capital, Number, Special Char, and be at least 8 chars
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    // 3. Cell Phone Validation (South African International Code)
    public boolean checkPhone(String phone) {
        // Regex to ensure it starts with +27 or 27
        String phoneRegex = "^(\\+27|27)[0-9]{7,9}$"; 
        return Pattern.compile(phoneRegex).matcher(phone).matches();
    }

    // Registration Orchestrator
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

    // Login Verification
    public boolean loginUser(String user, String pass) {
        return user.equals(this.username) && pass.equals(this.password);
    }

    // Authentication Status Message
    public String returnLoginStatus(boolean loggedIn, String fName, String lName) {
        if (loggedIn) {
            return "Welcome " + fName + ", " + lName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
}
