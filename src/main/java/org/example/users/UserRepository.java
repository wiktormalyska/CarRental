package org.example.users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements IUserRepository{

    public List<User> getUsers() throws FileNotFoundException {
        File db = new File(User.class.getClassLoader().getResource("users.csv").getFile());
        Scanner scanner = new Scanner(db);
        List<User> users = new ArrayList<>();
        for(String readLine = scanner.nextLine(); readLine != null; readLine = scanner.nextLine()){
            String[] split = readLine.split(",");
            if(split[0].equals("admin")){
                users.add(new Admin(split[1], split[2].getBytes()));
            } else {
                users.add(new Client(split[1], split[2]));
            }
        }
        return users;
    }

    @Override
    public User getUser(String username) {
        return null;
    }
}
