/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reg_feature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class REG_FEATURE {
// Declarations of the variables
    public String Username;
    public String Password;
    public String CellphoneNum;
    public String Firstname;
    public String Lastname;

    public static void main(String[] args) {
        REG_FEATURE reg = new REG_FEATURE(); 

        reg.Firstname = JOptionPane.showInputDialog("Please enter your first name");
        reg.Lastname = JOptionPane.showInputDialog("Please enter your last name");

        // Conditions to check the Username validation to check if it meets the requirements
        boolean validUsername = false;
        while (!validUsername) {
            reg.Username = JOptionPane.showInputDialog("Enter your username:");
            validUsername = reg.validateUsername();
            if (!validUsername) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted.\nPlease ensure that your username contains an underscore and is no more than 5 characters.");
            }
        }

        // Cellphone number validation
        boolean validCellphoneNumber = false;
        while (!validCellphoneNumber) {
            reg.CellphoneNum = JOptionPane.showInputDialog("Enter your cellphone number (with international code):");
            validCellphoneNumber = reg.validateCellphoneNumber();
            if (!validCellphoneNumber) {
                JOptionPane.showMessageDialog(null, "Cellphone number is incorrectly formatted or does not contain the international code.");
            }
        }

        // Password validation
        boolean validPassword = false;
        while (!validPassword) {
            reg.Password = JOptionPane.showInputDialog("Please enter your password:");
            validPassword = reg.validatePasswordComplexity();
            if (!validPassword) {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted.\nPlease ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        }

        JOptionPane.showMessageDialog(null, "Registration successful!\nWelcome " + reg.Firstname + " " + reg.Lastname + "!");
    }

    public boolean validateUsername() {
        String regex = "^[a-zA-Z0-9_]{1,5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Username);
        return matcher.matches() && Username.contains("_");
    }

    public boolean validatePasswordComplexity() {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Password);
        return matcher.matches();
    }

    public boolean validateCellphoneNumber() {
        String regex = "^\\+[0-9]{1,3}[0-9]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(CellphoneNum);
        return matcher.matches();
    }

   
}

    

   
       

    

    
    
         
        
        



        
     
    
    

