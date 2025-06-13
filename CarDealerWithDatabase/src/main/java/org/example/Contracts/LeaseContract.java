package org.example.Contracts;

import java.time.LocalDate;

public class LeaseContract {
    private int customerId;
    private int vehicleId;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private double monthlyPayment;
    private LocalDate contractSignedDate;
    private String remarks;
    private String isActive;

    // Constructor
    public LeaseContract(int customerId, int vehicleId, LocalDate leaseStartDate, LocalDate leaseEndDate,
                         double monthlyPayment, LocalDate contractSignedDate, String remarks, String isActive) {
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.monthlyPayment = monthlyPayment;
        this.contractSignedDate = contractSignedDate;
        this.remarks = remarks;
        this.isActive = isActive;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    public LocalDate getLeaseEndDate() {
        return leaseEndDate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public LocalDate getContractSignedDate() {
        return contractSignedDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public String isActive() {
        return isActive;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setLeaseStartDate(LocalDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public void setLeaseEndDate(LocalDate leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setContractSignedDate(LocalDate contractSignedDate) {
        this.contractSignedDate = contractSignedDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setActive(String active) {
        isActive = active;
    }
}
