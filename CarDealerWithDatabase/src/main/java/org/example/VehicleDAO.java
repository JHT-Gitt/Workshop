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

    public List<Vehicle> getMakeModel(String find){
        List<Vehicle> vehicles = new ArrayList<>();

        String query = "SELECT * FROM JT.Vehicles " +
                "WHERE make LIKE ? " +
                "OR model LIKE ? ";
        try(Connection c = DataManager.connect();
            PreparedStatement p = c.prepareStatement(query)){

            p.setString(1, "%" +  find + "%");
            p.setString(2, "%" +  find + "%");

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
    public boolean vehicleExists(int vinID) {
        String sql = "SELECT 1 FROM JT.vehicles WHERE vin_id = ?";

        try (Connection c = DataManager.connect();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, vinID);
            ResultSet rs = p.executeQuery();

            return rs.next(); // returns true if any row is found

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean addVehicle(Vehicle v) {
        String sql = "INSERT INTO JT.vehicles (vin_id, make, model, color, price, year, sold, odometer, type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = DataManager.connect();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, v.getVinID());
            p.setString(2, v.getMake());
            p.setString(3, v.getModel());
            p.setString(4, v.getColor());
            p.setDouble(5, v.getPrice());
            p.setInt(6, v.getYear());
            p.setString(7, v.getIsSold());
            p.setInt(8, v.getOdometer());
            p.setString(9, v.getType());

            int r = p.executeUpdate();
            return r > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteVehicle(int vinID) {
        String sql = "DELETE FROM JT.vehicles WHERE vin_id = ?";

        try (Connection c = DataManager.connect();
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setInt(1, vinID);

            int rowsAffected = p.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
