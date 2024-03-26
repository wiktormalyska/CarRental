package org.example;

import org.example.users.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RepositoryManager {
    public VehicleRepository vehicleRepository;
    public UserRepository userRepository;
    public RepositoryManager() throws FileNotFoundException {
        vehicleRepository = new VehicleRepository();
        userRepository = new UserRepository();
    }
    public void rentCar(int id, User user) throws FileNotFoundException {
        if (user instanceof Admin) return;
        vehicleRepository.rentVehicle(id);
        Client client = (Client) user;
        Vehicle vehicle = vehicleRepository.getVehicles().get(id);
        client.rentVehicle(vehicle);
        vehicleRepository.save();
    }
    public void returnCar(int id, User user) throws FileNotFoundException {
        if (user instanceof Admin) return;
        vehicleRepository.returnVehicle(id);
        Client client = (Client) user;
        client.returnVehicle();
        vehicleRepository.save();
    }
    public void createUser(String username, String password) throws FileNotFoundException {
        String hashedPassword = Arrays.toString(Authentication.hashPassword(password));
        User user = new Client(username, hashedPassword);
        userRepository.addUser(user);
    }

}
