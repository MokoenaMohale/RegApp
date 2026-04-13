/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.reglogin.RegApp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lab_services_student
 */

    
   

public class LoginTest {

    private Login login;

   
    @Test
    void testCheckUserName_Valid() {
        // Must contain '_' and be <= 5 chars
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    void testCheckUserName_Invalid() {
        // Fails because length > 5 or no underscore
        assertFalse(login.checkUserName("kyle_test")); // Too long
        assertFalse(login.checkUserName("kyle1"));     // No underscore
    }

    @Test
    void testCheckPasswordComplexity_Valid() {
        // Meets all criteria: Capital, Number, Special, 8+ chars
        assertTrue(login.checkPasswordComplexity("Ch@tt3r!"));
    }

    @Test
    void testCheckPasswordComplexity_Invalid() {
        // Fails complexity rules
        assertFalse(login.checkPasswordComplexity("password")); // No capital/number/special
        assertFalse(login.checkPasswordComplexity("Short1!"));  // Too short
    }

    @Test
    void testCheckPhone_Valid() {
        // Starts with +27 or 27
        assertTrue(login.checkPhone("+27123456789"));
        assertTrue(login.checkPhone("27821234567"));
    }

    @Test
    void testCheckPhone_Invalid() {
        // Fails format or country code
        assertFalse(login.checkPhone("0821234567")); // Wrong code
        assertFalse(login.checkPhone("12345"));      // Too short
    }

    @Test
    void testLoginUser_Success() {
        // First register a user
        login.registerUser("ky_l1", "Ch@tt3r!", "+27123456789");
        
        // Test login with correct credentials
        assertTrue(login.loginUser("ky_l1", "Ch@tt3r!"));
    }

    @Test
    void testLoginUser_Failure() {
        // First register a user
        login.registerUser("ky_l1", "Ch@tt3r!", "+27123456789");
        
        // Test login with wrong password
        assertFalse(login.loginUser("ky_l1", "WrongPass123!"));
    }
}
    

