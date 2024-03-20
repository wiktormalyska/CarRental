package org.example.users;

import org.example.RepositoryManager;
import org.example.Vehicle;
import org.example.VehicleRepository;

import java.io.FileNotFoundException;
import java.util.List;

public class Admin extends User{
    public Admin(String username, byte[] password) {
        super(username, password);
    }
    private List<User> getUsers(UserRepository repository) throws FileNotFoundException {
        return repository.getUsers();
    }
    @Override
    public String getUserType() {
        return "admin";
    }
    public void printUsers(UserRepository repository) throws FileNotFoundException {
        List<User> users = getUsers(repository);
        for(User user : users){
            System.out.printf("Type: %s, Username: %s, Password: %s%n", user.getUserType(), user.getUsername(), user.getPassword());
        }
    }
    public void printVehicles(VehicleRepository repository) throws FileNotFoundException {
        List<Vehicle> vehicles = repository.getVehicles();
        for(Vehicle vehicle : vehicles){
            System.out.printf(vehicle.toString());
        }
    }
    public void addVehicle(VehicleRepository repository, Vehicle vehicle) throws FileNotFoundException {
        repository.addVehicle(vehicle);
    }
    public void removeVehicle(VehicleRepository repository, int id) throws FileNotFoundException {
        repository.removeVehicle(id);
    }
}
