package org.example.users;

import org.example.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();

    public List<User> getUsers() throws FileNotFoundException {
        File db = new File(User.class.getClassLoader().getResource("users.csv").getFile());
        Scanner scanner = new Scanner(db);
        users.clear();
        while (scanner.hasNextLine()) {
            String readLine = scanner.nextLine();
            String[] split = readLine.split(",");
            if (split[0].equals("admin")) {
                users.add(new Admin(split[1], split[2].getBytes()));
            } else {
                users.add(new Client(split[1], split[2].getBytes()));
            }
        }
        return users;
    }

    @Override
    public User getUser(String username) {
        try {
            List<User> users = getUsers();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user){
        users.add(user);
        save();
    }

    @Override
    public void save() {
        File db = new File(Main.class.getClassLoader().getResource("users.csv").getFile());
        try {
            FileWriter fileWriter = new FileWriter(db, false);
            fileWriter.flush();
            StringBuilder stringBuilder = new StringBuilder();
            for (User user : users) {
                stringBuilder.append(user.toCSV()).append("\n");
            }
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printUsers() {
        try {
            users = getUsers();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (User user : users) {
            System.out.println(user);
        }
    }
}
