/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author RC_Student_lab
 */
import javax.swing.JOptionPane;

public class Login {
    public String Firstname;
    public String Lastname;
    public String Username;
    public String Password;
// thedetails 
    public void loginUser(String registeredUsername, String registeredPassword) {     
        Username = JOptionPane.showInputDialog("Enter your Username");
        Password = JOptionPane.showInputDialog("Enter your Password");

        if (Username.equals(registeredUsername) && Password.equals(registeredPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome " + Firstname + " " + Lastname + ", it's great to see you again!");
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
        }
    }
}
