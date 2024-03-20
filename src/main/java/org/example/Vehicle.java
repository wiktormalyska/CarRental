package org.example;

public abstract class Vehicle{
    public String type;
    public String brand;
    public String model;
    public int year;
    public double price;
    public boolean isRented;
    public int id;
    public Vehicle(String type, String brand, String model, int year, double price, boolean isRented, int id) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isRented = isRented;
        this.id = id;
        this.type = type;
    }
    public String toCSV() {
        return type+","+brand + "," + model + "," + year + "," + price + "," + isRented + "," + id;
    }
    @Override
    public String toString() {
        return type + " - \t Brand: " + brand + "\t Model: " + model + "\t Year: " + year + "\t Price: " + price + "\t Rented: " + isRented + "\t ID: " + id;
    }
}
