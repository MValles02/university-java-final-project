package model.User;

import java.io.Serializable;

public abstract class User implements Serializable {
    // Attributes
    private String email;
    private String password;

    // Constructor
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Email: ").append(email);
        return sb.toString();
    }
}