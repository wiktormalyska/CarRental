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
    public void rentCar(int id, User user){
        if (user instanceof Admin) return;
        vehicleRepository.rentVehicle(id);
        Client client = (Client) user;
        Vehicle vehicle = null;
        try {
            vehicle = vehicleRepository.getVehicles().get(id);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        client.rentVehicle(vehicle);
        vehicleRepository.save();
    }
    public void returnCar(int id, User user) {
        if (user instanceof Admin) return;
        vehicleRepository.returnVehicle(id);
        Client client = (Client) user;
        client.returnVehicle();
        vehicleRepository.save();
    }
    public User createUser(String username, String password) {
        String hashedPassword = Authentication.hashPassword(password);
        Client user = new Client(username, hashedPassword);
        userRepository.addUser(user);
        return user;
    }
    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.addVehicle(vehicle);
    }
    public void removeVehicle(int id) {
        vehicleRepository.removeVehicle(id);
    }
    public void printVehicles(){
        vehicleRepository.printVehicles();
    }
    public void printUsers(){
        userRepository.printUsers();
    }

}
