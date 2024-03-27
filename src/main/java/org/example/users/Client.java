package org.example.users;

import org.example.Vehicle;

public class Client extends User{
    Vehicle rentedVehicle = null;
    @Override
    public String getUserType() {
        return "client";
    }
    public Client(String username, byte[] password) {
        super(username, password);
    }
    public void rentVehicle(Vehicle vehicle){
        if(rentedVehicle == null){
            rentedVehicle = vehicle;
        } else {
            System.out.println("You already have a vehicle rented");
        }
    }
    public void returnVehicle(){
        if(rentedVehicle != null){
            rentedVehicle = null;
        } else {
            System.out.println("You don't have a vehicle rented");
        }
    }

    public void printRentedVehicle(){
        if(rentedVehicle != null){
            System.out.println(rentedVehicle);
        } else {
            System.out.println("You don't have a vehicle rented");
        }
    }
    public void printUser(){
        System.out.printf("Type: %s, Username: %s", getUserType(), getUsername());
    }
}
