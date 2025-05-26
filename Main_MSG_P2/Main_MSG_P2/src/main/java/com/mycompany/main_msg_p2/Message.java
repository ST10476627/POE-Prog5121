/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main_msg_p2;
public class Message {
    public String recipient;
    public String message;
    public int messageId;
    public String messageHash;

    public Message(String recipient, String message, int messageId) {
        this.recipient = recipient;
        this.message = message;
        this.messageId = messageId;
        this.messageHash = generateMessageHash();
    }

    private String generateMessageHash() {
        String idStr = String.format("%02d", messageId); // Ensure two digits
        String[] words = message.trim().split("\\s+");

        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;

        return (idStr + ":" + messageId + ":" + firstWord + lastWord).toUpperCase();
    }

    public boolean checkRecipientCell() {
        return recipient.matches("^\\+\\d{10,15}$");
    }

    public void sentMessage() {
        // Any additional logic here
    }

    public String getMessageDetails() {
        return "To: " + recipient +
                "\nMessage: " + message +
                "\nMessage ID: " + messageId +
                "\nHash: " + messageHash;
    }
}


               
    

