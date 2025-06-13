package org.example.Contracts;

import java.time.LocalDate;

public class SalesContract {

    private int vin;
    private LocalDate contractSignedDate;
    private double amount;
    private String remarks;
    private String isActive;

    // Constructor
    public SalesContract(int vin, LocalDate contractSignedDate, double amount, String remarks, String isActive) {
        this.vin = vin;
        this.contractSignedDate = contractSignedDate;
        this.amount = amount;
        this.remarks = remarks;
        this.isActive = isActive;
    }

    // Getters
    public int getVin() {
        return vin;
    }

    public LocalDate getContractSignedDate() {
        return contractSignedDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public String isActive() {
        return isActive;
    }

    // Setters
    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setContractSignedDate(LocalDate contractSignedDate) {
        this.contractSignedDate = contractSignedDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setActive(String active) {
        isActive = active;
    }
}
