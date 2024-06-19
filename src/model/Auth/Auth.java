package model.Auth;

import model.User.User;

import java.util.ArrayList;

import Exceptions.UserNotFoundException;

public class Auth { // This class is used to manage the login, registration and logout of users
    // Attributes
    private ArrayList<User> users;

    // Constructor (gets an ArrayList of users from the Main class)
    public Auth(ArrayList<User> users) {
        this.users = users;
    }

    // Getters
    public ArrayList<User> getUsers() {
        return users;
    }

    // Methods
    public User login(String email, String password) throws UserNotFoundException {
        // This method receives an email and a password, and checks if there is a user with that email and password
        // If there is, it returns the user, if not, it throws an exception
        User aux = null;
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                aux = user;
            }
        } if (aux == null) {
            throw new UserNotFoundException();
        }
        return aux;
    }

    public void register(User user) {
        // This method receives a user and adds it to the ArrayList of users
        users.add(user);
    }

    public boolean checkEmail(String email) {
        // This method receives an email and checks if there is a user with that email
        boolean check = false;
        for (User user: users) {
            if (user.getEmail().equals(email)){
                check = true;
            }
        }
        return check;
    }
}