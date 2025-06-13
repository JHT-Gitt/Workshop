package org.example.DatabaseFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataManager {

    public static Connection connect() {
        String url = "jdbc:sqlserver://skills4it.database.windows.net:1433;" +
                "database=Courses;" +
                "user=user405@skills4it;" +
                "password=YearupSecure2025!;" +
                "encrypt=true;" +
                "trustServerCertificate=false;" +
                "loginTimeout=30;";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
