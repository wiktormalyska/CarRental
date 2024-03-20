package org.example;

import org.example.users.Client;

import java.io.FileNotFoundException;
import java.util.List;

public interface IVehicleRepository {
    void rentVehicle(int id);
    void returnVehicle(int id);
    List<Vehicle> getVehicles() throws FileNotFoundException;
    void save();
    void addVehicle(Vehicle vehicle);
    void removeVehicle(int id);
}
