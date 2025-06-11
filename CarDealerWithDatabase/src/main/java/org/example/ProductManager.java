package org.example;

import java.sql.*;

public class ProductManager {

    // You would get this connection from a connection pool in a real app
    private final Connection connection;

    public ProductManager(Connection connection) {
        this.connection = connection;
    }

    /**
     * CREATE: Inserts a new product into the database.
     */
    public void createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.executeUpdate();
        }
    }
}
