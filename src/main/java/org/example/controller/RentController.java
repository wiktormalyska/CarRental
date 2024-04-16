package org.example.controller;

import org.example.dto.RentCarDto;
import org.example.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    //todo: dodac zwracanie pojazdu
    //todo: zamienic wstrzykiwanie na wstrzykiwanie przez konstruktor

    @Autowired
    private RentService rentService;

    @PostMapping("/rent")
    public ResponseEntity<String> rentVehicle(@RequestBody RentCarDto request) {
        boolean success = rentService.rentVehicle(request.getPlate(),request.getLogin());
        if (success) {
            return ResponseEntity.ok("Vehicle rented");
        } else {
            return ResponseEntity.badRequest().body("Failed");
        }
    }
}