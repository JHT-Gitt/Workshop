package org.example.VehicleFiles;

public class Vehicle {
    int vinID;
    String make;
    String model;
    String color;
    double price;
    int year;
    String isSold;
    int odometer;
    String type;

    public Vehicle(int vinID, String make, String model, String color, double price, int year, String isSold, int odometer, String type) {
        this.vinID = vinID;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
        this.isSold = isSold;
        this.odometer = odometer;
        this.type = type;
    }

    public int getVinID() {
        return vinID;
    }

    public void setVinID(int vinID) {
        this.vinID = vinID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public void setIsSold(String isSold) {
        this.isSold = isSold;
    }

    public String getIsSold() {
        return isSold;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
