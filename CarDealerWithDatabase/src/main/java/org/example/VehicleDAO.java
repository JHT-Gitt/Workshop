package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    public List<Vehicle> getPriceRange(double min, double max){

        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM JT.vehicles " +
                "WHERE price BETWEEN ? AND ?";
        try(Connection c = DataManager.connect();
        PreparedStatement p = c.prepareStatement(query)){

            p.setDouble(1, min);
            p.setDouble(2, max);

            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Vehicle v = new Vehicle(
                        rs.getInt("vin_id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getString("color"),
                        rs.getDouble("price"),
                        rs.getInt("year"),
                        rs.getString("sold"),
                        rs.getInt("odometer"),
                        rs.getString("type")

                );
                vehicles.add(v);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    return vehicles;
    }

}
