package org.example.users;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    public static User login(UserRepository userRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String readUsername = scanner.nextLine();
        System.out.println("Enter your password: ");
        String readPassword = scanner.nextLine();
        try {
            List<User> users = userRepository.getUsers();
            for (User user : users) {
                if (user.getUsername().equals(readUsername)) {
                    user.getPassword();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
