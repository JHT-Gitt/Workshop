package org.example.Contracts;

import org.example.DatabaseFile.DataManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractsDao {

    public boolean addSalesContract(SalesContract sale){
        String sql = "INSERT INTO JT.sales_contracts (VIN, contract_signed_date, amount, remarks, is_active) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataManager.connect();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, sale.getVin());
            p.setDate(2, Date.valueOf(sale.getContractSignedDate()));
            p.setDouble(3, sale.getAmount());
            p.setString(4, sale.getRemarks());
            p.setString(5, sale.isActive());

            int rowsInserted = p.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addLeaseContract(LeaseContract lease) {
        String sql = "INSERT INTO JT.lease_contracts " +
                "(customer_id, vehicle_id, lease_start_date, lease_end_date, monthly_payment, contract_signed_date, remarks, is_active) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataManager.connect();
             PreparedStatement p = conn.prepareStatement(sql)) {

            p.setInt(1, lease.getCustomerId());
            p.setInt(2, lease.getVehicleId());
            p.setDate(3, Date.valueOf(lease.getLeaseStartDate()));
            p.setDate(4, Date.valueOf(lease.getLeaseEndDate()));
            p.setDouble(5, lease.getMonthlyPayment());
            p.setDate(6, Date.valueOf(lease.getContractSignedDate()));
            p.setString(7, lease.getRemarks());
            p.setString(8, lease.isActive());

            int rows = p.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
