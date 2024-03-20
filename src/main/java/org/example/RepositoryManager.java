package org.example;

import org.example.users.Admin;
import org.example.users.Client;
import org.example.users.User;
import org.example.users.UserRepository;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class RepositoryManager {
    VehicleRepository vehicleRepository;
    UserRepository userRepository;
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

}
