package org.example.controller;

import org.example.dto.VehicleDto;
import org.example.model.Car;
import org.example.model.Motorcycle;
import org.example.model.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/all")
    public ResponseEntity<Collection<VehicleDto>> getVehicles() {
        Collection<VehicleDto> vehicles = vehicleService.getVehicles();
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping("{plate}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable String plate) {
        VehicleDto vehicleDto = vehicleService.getVehicle(plate);
        if (vehicleDto != null)
            return ResponseEntity.ok(vehicleDto);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle=null;
        switch (vehicleDto.getVehicleType()){
            case "CAR" -> {
                vehicle = new Car(
                    vehicleDto.getVehicle().getBrand(),
                    vehicleDto.getVehicle().getModel(),
                    vehicleDto.getVehicle().getYear(),
                    vehicleDto.getVehicle().getPrice(),
                    vehicleDto.getVehicle().getPlate()
            );
            }
            case "MOTORCYCLE" -> {
                vehicle = new Motorcycle(
                        vehicleDto.getVehicle().getBrand(),
                        vehicleDto.getVehicle().getModel(),
                        vehicleDto.getVehicle().getYear(),
                        vehicleDto.getVehicle().getPrice(),
                        vehicleDto.getVehicle().getPlate(),
                        vehicleDto.getCategory()
                );
            }
            default -> {
                return ResponseEntity.badRequest().body("Invalid vehicle type");
            }
        }

        switch (vehicleService.addVehicle(vehicle)){
            case "vehicle already exists"-> {
                return ResponseEntity.badRequest().body("Vehicle already exists");
            }
            case "vehicle added successfully"-> {
                return ResponseEntity.ok("Vehicle added successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}
