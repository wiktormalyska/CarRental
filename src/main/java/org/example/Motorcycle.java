package org.example;

public class Motorcycle extends Vehicle{
    String category;
    public Motorcycle(String brand, String model, int year, double price, boolean isRented, int id, String category) {
        super("Motorcycle",brand, model, year, price, isRented, id);
        this.category = category;
    }
    @Override
    public String toCSV() {
        return type+","+brand + "," + model + "," + year + "," + price + "," + isRented + "," + id + "," + category;
    }

    @Override
    public String toString() {
        return type + " - \t Brand: " + brand + "\t Model: " + model + "\t Year: " + year + "\t Price: " + price + "\t Rented: " + isRented + "\t ID: " + id + "\t Category: " + category;
    }
}
