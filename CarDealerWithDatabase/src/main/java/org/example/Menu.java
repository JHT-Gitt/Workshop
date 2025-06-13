package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {

        VehicleDAO vDao = new VehicleDAO();

        int choice;
        static Scanner scanner = new Scanner(System.in);

        public void display() {

            System.out.println("Car Dealership search engine 🔍🔍🔍🔍");
            System.out.println(" 1 - Search Vehicle by price range");
            System.out.println(" 2 - Search Vehicle by make/model ");
            System.out.println(" 3 - Search Vehicle by year range");
            System.out.println(" 4 - Search Vehicle by color");
            System.out.println(" 5 - Search Vehicle by mileage range");
            System.out.println(" 6 - Search Vehicle by type");
            System.out.println(" 7 - Add Vehicle");
            System.out.println(" 8 - Remove Vehicle");
            System.out.println(" 9 - Add Sales Contract");
            System.out.println(" 10 - Add Lease Contract");
            System.out.println(" 0 - Exit");

            while (true) {
                System.out.print("Enter your choice: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a number.");
                    scanner.next();
                    continue;
                }
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0 -> {
                        System.out.println("Goodbye and have a great day");
                        System.exit(0);
                    }
                    case 1 -> price();
                    case 2 -> makeModel();
                    case 3 -> yearSearch();
                    case 4 -> color();
                    case 5 -> mileage();
                    case 6 -> type();
                    case 7 -> addVehicle();
                    case 8 -> removeVehicle();
                    case 9 -> addSales();
                    case 10 -> addLease();
                    default -> {
                        System.out.println("Invalid input ! ");
                    }

                }


            }
        }

    private void addLease() {
    }

    private void addSales() {
    }

    private void removeVehicle() {
        System.out.print("\nEnter Vehicle VIN ID: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid VIN ID. Please enter a number.");
            scanner.next();
            return;
        }
        int vinID = scanner.nextInt();
        scanner.nextLine();

        boolean success = vDao.deleteVehicle(vinID);

        if (success) {
            System.out.println("Vehicle deleted successfully.");
            display();
        } else {
            System.out.println("\nVehicle not found or deletion failed.");
            removeVehicle();
        }
    }

    private void addVehicle() {
        int vinID = 0;
        boolean valid = false;

        while(!valid) {
            System.out.print("Vehicle VIN ID: ");
            vinID = scanner.nextInt();
            scanner.nextLine();

            if (vDao.vehicleExists(vinID)) {
                System.out.println("VIN ID already exist. Please use a different VIN ID.");
                addVehicle();
            }
            valid = true;
        }

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Is it sold? (yes/no): ");
        String isSold = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Type (SUV, Sedan, etc.): ");
        String type = scanner.nextLine();

        if(isSold.equals("yes") || isSold.equals("Yes") || isSold.equals("YES")){
            isSold = "1";
        }else if(isSold.equals("no") || isSold.equals("No") || isSold.equals("NO")){
            isSold = "0";
        }

        Vehicle newVehicle = new Vehicle(vinID, make, model, color, price, year, isSold, odometer, type);
        boolean success = vDao.addVehicle(newVehicle);

        if (success) {
            System.out.println("Vehicle added successfully.");
            display();
        } else {
            System.out.println("Failed to add vehicle.");
        }

    }

    private void type() {
    }

    private void mileage() {
    }

    private void color() {
    }

    private void yearSearch() {
    }

    private void makeModel() {
            String find;
        System.out.print("Enter Vehicle Make or Model: ");
        find = scanner.nextLine();

        List<Vehicle> vehicleList = vDao.getMakeModel(find);

        if(vehicleList.isEmpty()){
            System.out.println("\nNo Vehicles found in the inputted Make/Model\n");
        }else {
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-5s | %-10s | %-15s\n", "VIN ID", "Make", "Model", "Color", "Price", "Year", "Sold", "Odometer", "Type");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            for(Vehicle v : vehicleList){
                if(v.getIsSold().equals("1")){
                    v.setIsSold("Yes");
                }else if(v.getIsSold().equals("0")){
                    v.setIsSold("No");
                }
                System.out.printf("%-10d | %-10s | %-10s | %-10s | %-10.2f | %-10d | %-5s | %-10d | %-15s\n",
                        v.getVinID(),v.getMake(), v.getModel(),v.getColor(),v.getPrice(),
                        v.getYear(),v.getIsSold(),v.getOdometer(),v.getType());
                System.out.println("---------------------------------------------------------------------------------------------------------------");
            }
        }

    }

    private void price() {
        double min = 0, max = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter min price: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }
            min = scanner.nextDouble();

            System.out.print("Enter max price: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }
            max = scanner.nextDouble();

            if (min >= max) {
                System.out.println("Min price should be less than Max price. Try again.");
            } else {
                valid = true;
            }
        }

        List<Vehicle> vehicleList = vDao.getPriceRange(min,max);

        if(vehicleList.isEmpty()){
            System.out.println("\nNo Vehicles found in the inputted price range\n");
        }else {
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-5s | %-10s | %-15s\n", "VIN ID", "Make", "Model", "Color", "Price", "Year", "Sold", "Odometer", "Type");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            for(Vehicle v : vehicleList){
                if(v.getIsSold().equals("1")){
                    v.setIsSold("Yes");
                }else if(v.getIsSold().equals("0")){
                    v.setIsSold("No");
                }
                System.out.printf("%-10d | %-10s | %-10s | %-10s | %-10.2f | %-10d | %-5s | %-10d | %-15s\n",
                        v.getVinID(),v.getMake(), v.getModel(),v.getColor(),v.getPrice(),
                        v.getYear(),v.getIsSold(),v.getOdometer(),v.getType());
                System.out.println("---------------------------------------------------------------------------------------------------------------");
            }
        }


    }


}
