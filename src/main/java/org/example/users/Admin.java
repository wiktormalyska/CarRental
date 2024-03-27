package org.example.users;

import org.example.RepositoryManager;
import org.example.Vehicle;
import org.example.VehicleRepository;

import java.io.FileNotFoundException;
import java.util.List;

public class Admin extends User{
    public Admin(String username, String password) {
        super(username, password);
    }
    private List<User> getUsers(UserRepository repository) throws FileNotFoundException {
        return repository.getUsers();
    }
    @Override
    public String getUserType() {
        return "admin";
    }
}
