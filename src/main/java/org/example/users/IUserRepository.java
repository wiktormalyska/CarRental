package org.example.users;

import java.io.FileNotFoundException;
import java.util.List;

public interface IUserRepository {
    List<User> getUsers() throws FileNotFoundException;
    User getUser(String username);
}
