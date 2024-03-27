package org.example.users;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.RepositoryManager;

import java.io.FileNotFoundException;
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
                String hashedPassword = hashPassword(readPassword);
                if (user.getUsername().equals(readUsername)) {
                    if (user.getPassword().equals(hashedPassword)) {
                        return user;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return repositoryManager.createUser(readUsername, readPassword);
    }

    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

}
