package org.example;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository implements IVehicleRepository {
    public VehicleRepository() throws FileNotFoundException {
        vehicles = new ArrayList<>();
        vehicles = getVehicles();
    }

    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() throws FileNotFoundException {
        vehicles = new ArrayList<>();
        File file = new File(Main.class.getClassLoader().getResource("vehicles.csv").getFile());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            if (line[0].equals("Car")) {
                vehicles.add(new Car(line[1], line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), Boolean.parseBoolean(line[5]), Integer.parseInt(line[6])));
            } else if (line[0].equals("Motorcycle")) {
                vehicles.add(new Motorcycle(line[1], line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), Boolean.parseBoolean(line[5]), Integer.parseInt(line[6]), line[7]));
            }
        }
        scanner.close();

        return vehicles;
    }

    public void printVehicles() throws FileNotFoundException {
        vehicles = getVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toCSV());
        }
    }

    @Override
    public void rentVehicle(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.id == id) {
                vehicle.isRented = true;
            }
        }
    }

    @Override
    public void returnVehicle(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.id == id) {
                vehicle.isRented = false;
            }
        }
    }

    @Override
    public void save() {
        File file = new File(Main.class.getClassLoader().getResource("vehicles.csv").getFile());
        //System.out.println(file);
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.flush();
            //
            StringBuilder sb = new StringBuilder();
            sb.append("Type,Brand,Model,Year,Price,IsRented,ID,Category\n");
            for (Vehicle vehicle : vehicles) {
                sb.append(vehicle.toCSV()).append("\n");
            }
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
