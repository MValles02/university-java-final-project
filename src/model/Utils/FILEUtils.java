package model.Utils;

import model.User.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FILEUtils {
    // This class is used to read and write objects to and from files
    public static ArrayList<User> readUsers(String filePath) {
        // Read users from file
        // If file does not exist, return an empty list
        // If file exists, return the list of users
        // If there is an error, print the stack trace and return an empty list
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            users = (ArrayList<User>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeUsers(String filePath, ArrayList<User> users) {
        // Write users to file
        // If the file does not exist, create the file
        // If the file exists, overwrite the file
        // If there is an error, print the stack trace
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}