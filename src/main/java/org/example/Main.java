package org.example;

import org.example.users.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            // Tworzenie nowego obiektu VehicleRepository
//            VehicleRepository vehicleRepository = new VehicleRepository();
//            vehicleRepository.printVehicles();
//            System.out.println("\n=====================================\n");
//
//            // Wypożyczenie kilku pojazdów
//            vehicleRepository.rentVehicle(1);
//            vehicleRepository.rentVehicle(2);
//            vehicleRepository.rentVehicle(3);
//
//            // Zwrócenie kilku pojazdów
//            vehicleRepository.returnVehicle(1);
//            vehicleRepository.returnVehicle(2);
//            //vehicleRepository.returnVehicle(3);
//
//            // Zapisanie zmian do pliku
//            vehicleRepository.save();
//
//            // Wyświetlanie listy pojazdów
//
//            vehicleRepository.printVehicles();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        RepositoryManager repositoryManager = new RepositoryManager();
        while (true){
            User user = Authentication.login(repositoryManager);
            Menu menu = new Menu(repositoryManager);
            menu.showMenu(user);
        }

    }
}