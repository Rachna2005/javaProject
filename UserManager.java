import java.io.*;
import java.util.*;

public class UserManager {
    private static final String FILE_NAME = "userData.txt";

    // Save user data as plain text (append new users)
    public static void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) { // Append mode
            writer.write(user.name + " " + user.email + " " + user.phoneNumber + " " + user.password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load user data from plain text file
    public static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            User.User.clear();
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(" ");
                if (userData.length == 4) {
                    User user = new User(userData[0], userData[1], userData[2], userData[3]);
                    User.User.put(user.email, user);
                    System.out.println("Loaded user: " + user.email + ", password: " + user.password);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing user data found. Creating a new file.");
        }
    }
}
