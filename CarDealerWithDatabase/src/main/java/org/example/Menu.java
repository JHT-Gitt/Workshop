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
                    default -> {
                        System.out.println("Invalid input ! ");
                    }

                }


            }
        }

    private void removeVehicle() {
    }

    private void addVehicle() {
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
            System.out.println("\nNo Vehicles found in the inputted price range");
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
