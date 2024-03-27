package org.example.users;

import org.example.Car;
import org.example.Motorcycle;
import org.example.RepositoryManager;
import org.example.Vehicle;

import java.util.Scanner;

public class Menu {
    private static RepositoryManager repositoryManager;
    public Menu(RepositoryManager repositoryManager) {
        Menu.repositoryManager = repositoryManager;
    }
    public void showMenu(User user) {
        if (user instanceof Admin) {
            System.out.println("Admin menu");
            showAdminMenu();
            Admin admin = (Admin) user;
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    addVehicleMenu();
                    showMenu(user);
                    break;
                case 2:
                    repositoryManager.removeVehicle(scanner.nextInt());
                    showMenu(user);
                    break;
                case 3:
                    repositoryManager.printVehicles();
                    showMenu(user);
                    break;
                case 4:
                    repositoryManager.printUsers();
                    showMenu(user);
                    break;
                case 5:
                    break;
            }
        } else {
            System.out.println("Client menu");
            showClientMenu();
            Client client = (Client) user;
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    int id = scanner1.nextInt();
                    repositoryManager.rentCar(id, user);
                    showMenu(user);
                    break;
                case 2:
                    repositoryManager.returnCar(client.rentedVehicle.id, user);
                    showMenu(user);
                    break;
                case 3:
                    client.printRentedVehicle();
                    showMenu(user);
                    break;
                case 4:
                    client.printUser();
                    showMenu(user);
                    break;
                case 5:{
                    break;
                }
            }
        }
    }
    private static void showAdminMenu() {
        System.out.println("1. Add vehicle");
        System.out.println("2. Remove vehicle");
        System.out.println("3. Print vehicles");
        System.out.println("4. Print users");
        System.out.println("5. Exit");
    }
    private static void showClientMenu() {
        System.out.println("1. Rent vehicle");
        System.out.println("2. Return vehicle");
        System.out.println("3. Print rented vehicle");
        System.out.println("4. Print user");
        System.out.println("5. Exit");
    }

    private static void addVehicleMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vehicle type: 1 - Car, 2 - Motorcycle");
        int type = scanner.nextInt();
        System.out.println("Enter vehicle brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.println("Enter vehicle year: ");
        int year = scanner.nextInt();
        System.out.println("Enter vehicle price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter vehicle id: ");
        int id = scanner.nextInt();
        switch (type) {
            case 1:
                repositoryManager.addVehicle(new Car(brand, model, year, price, false, id));
                break;
            case 2:
                System.out.println("Enter motorcycle category: ");
                String category = scanner.nextLine();
                repositoryManager.addVehicle(new Motorcycle(brand, model, year, price, false, id, category));
                break;
        }

    }
}
