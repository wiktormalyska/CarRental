package org.example;

public class Car extends Vehicle{
    public Car(String brand, String model, int year, double price, boolean isRented, int id) {
        super("Car",brand, model, year, price, isRented, id);
    }
}
