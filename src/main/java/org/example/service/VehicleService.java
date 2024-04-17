package org.example.service;

import org.example.dao.IVehicleRepository;
import org.example.dto.VehicleDto;
import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Vehicle;
import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class VehicleService {
    @Autowired
    private IVehicleRepository vehicleRepository;

    public Collection<VehicleDto> getVehicles(){
        Collection<VehicleDto> vehicleDtos = new ArrayList<>();
        Collection<Vehicle> vehicles = vehicleRepository.getVehicles();
        String vehicleType;
        String category=null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car)
                vehicleType = "CAR";
            else {
                vehicleType = "MOTORCYCLE";
                category = ((Motorcycle) vehicle).getCategory();
            }

            VehicleDto vehicleDto = new VehicleDto(vehicleType, vehicle, category);
            vehicleDtos.add(vehicleDto);
        }
        return vehicleDtos;
    }

    public VehicleDto getVehicle(String plate) {
        Vehicle vehicle = vehicleRepository.getVehicle(plate);
        String vehicleType;
        String category=null;
        if (vehicle instanceof Car)
            vehicleType = "CAR";
        else {
            vehicleType = "MOTORCYCLE";
            category = ((Motorcycle) vehicle).getCategory();
        }
        if (vehicle != null)
            return new VehicleDto(vehicleType, vehicle, category);
        else
            return null;
    }

    public String addVehicle(Vehicle vehicle) {
        if (vehicleRepository.getVehicle(vehicle.getPlate()) != null)
            return "vehicle already exists";
        vehicleRepository.addVehicle(vehicle);
        return "vehicle added successfully";
    }
    public String removeVehicle(String plate) {
        Vehicle vehicle = vehicleRepository.getVehicle(plate);
        if (vehicle == null)
            return "not found";
        else if (vehicle.getUser() != null)
            return "user is not null";
        else
            vehicleRepository.removeVehicle(plate);
        return "deleted";
    }
}
