package org.example;

import java.io.FileNotFoundException;
import java.util.List;

public interface IVehicleRepository {
    void rentVehicle(int id);
    void returnVehicle(int id);
    List<Vehicle> getVehicles() throws FileNotFoundException;
    void save();
}
