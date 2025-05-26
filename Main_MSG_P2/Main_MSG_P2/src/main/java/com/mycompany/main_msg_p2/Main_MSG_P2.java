/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main_msg_p2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */

public class Main_MSG_P2 {

    public static void main(String[] args) {
        String username = "";
        String password = "";

        JOptionPane.showMessageDialog(null, "WELCOME TO Quickchat!");
       // This is checks if the user's username meets the right conditons if not it lets the  user try again
        boolean validUsername = false;
        while (!validUsername) {
            username = JOptionPane.showInputDialog("Enter your username:");
            validUsername = validateUsername(username);
            if (!validUsername) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. It must contain an underscore and be no longer than 5 characters.");
            }
        }
        //this checks  whether the password is correct and meets the conditions if not it lets the user try again
        boolean validPassword = false;
        while (!validPassword) {
            password = JOptionPane.showInputDialog("Please enter your password:");
            validPassword = validatePasswordComplexity(password);
            if (!validPassword) {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted.");
            }
        }
        // this measure the amount of messages the user wants to send and makes sure they don't exceed it
        int maxMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
        Message[] messages = new Message[maxMessages];
        int sentCount = 0;

        int option;
        do {
            String[] options = {"Send Message", "Show Recently Sent Messages", "Quit"};
            option = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (option) {
                case 0: 
                    if (sentCount >= maxMessages) {
                        JOptionPane.showMessageDialog(null, "Message limit reached.");
                        break;
                    }

                    String recipient = "";
                    boolean validCell = false;
                    while (!validCell) {
                        recipient = JOptionPane.showInputDialog("Enter recipient's number");
                        validCell = validateCellphoneNumber(recipient);
                        if (!validCell) {
                            JOptionPane.showMessageDialog(null, "Invalid cellphone number format.");
                        }
                    }
                     // this limits the user on how many characters they should use
                    String msg = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
                    if (msg.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Message too long. Please limit to 250 characters.");
                        break;
                    }

                    Message m = new Message(recipient, msg, sentCount);
                    if (!m.checkRecipientCell()) {
                        JOptionPane.showMessageDialog(null, "Invalid recipient number.");
                        break;
                    }
                    // these are the options that the user can choose from
                    m.sentMessage();
                    String[] sendOptions = {"Send", "Discard", "Save to File"};
                    int sendChoice = JOptionPane.showOptionDialog(
                            null,
                            "What would you like to do with this message?",
                            "Send Options",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            sendOptions,
                            sendOptions[0]
                    );

                    if (sendChoice == 0) {
                        messages[sentCount++] = m;
                        JOptionPane.showMessageDialog(null, "Message sent:\n" + m.getMessageDetails());
                    } else if (sendChoice == 1) {
                        JOptionPane.showMessageDialog(null, "Message discarded.");
                    } else if (sendChoice == 2) {
                        storeMessageToJson(m);
                        JOptionPane.showMessageDialog(null, "Message saved to file.");
                    }
                    break;

                case 1: // Show Recently Sent Messages
                    if (sentCount == 0) {
                        JOptionPane.showMessageDialog(null, "No messages sent yet.");
                    } else {
                        StringBuilder allMessages = new StringBuilder();
                        for (int i = 0; i < sentCount; i++) {
                            allMessages.append(messages[i].getMessageDetails()).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, allMessages.toString());
                    }
                    break;

                case 2: // Quit
                    JOptionPane.showMessageDialog(null, "Thank you for using QuickChat!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        } while (option != 2);

        JOptionPane.showMessageDialog(null, "Total messages sent: " + sentCount);
    }

    public static boolean validateUsername(String username) {
        String regex = "^[a-zA-Z0-9_]{1,5}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches() && username.contains("_");
    }

    public static boolean validatePasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateCellphoneNumber(String number) {
        return number.matches("^\\+\\d{10,15}$");
    }

    public static void storeMessageToJson(Message msg) {
        String json = "{\n" +
                "  \"MessageID\": \"" + msg.messageId + "\",\n" +
                "  \"Hash\": \"" + msg.messageHash + "\",\n" +
                "  \"Recipient\": \"" + msg.recipient + "\",\n" +
                "  \"Message\": \"" + msg.message + "\"\n" +
                "}";
        try {
            FileWriter writer = new FileWriter("stored_messages.json", true);
            writer.write(json + ",\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred storing the message.");
        }
    }
}

    

