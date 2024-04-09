package org.example;

import org.example.authenticate.Authenticator;

import java.util.Scanner;

public class GenHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println(Authenticator.hashPassword(password));
    }
}
