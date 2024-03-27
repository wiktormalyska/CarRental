package org.example.users;

import org.example.RepositoryManager;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    public static User login(RepositoryManager repositoryManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String readUsername = scanner.nextLine();
        System.out.println("Enter your password: ");
        String readPassword = scanner.nextLine();
        try {
            List<User> users = repositoryManager.userRepository.getUsers();
            for (User user : users) {
                byte[] hashedPassword = hashPassword(readPassword);
                if (user.getUsername().equals(readUsername)) {
                    if (MessageDigest.isEqual(hashedPassword, user.getPassword())) {
                        return user;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return repositoryManager.createUser(readUsername, readPassword);
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
