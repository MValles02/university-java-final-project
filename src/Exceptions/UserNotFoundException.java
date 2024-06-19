package Exceptions;

public class UserNotFoundException extends Exception {
    // Attributes
    private String messagge;

    // Getters
    public String getMessagge() {
        return messagge;
    }

    // Methods
    public UserNotFoundException() {
        messagge = "Invalid credentials. Please try again";
    }
}