package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URI = "jdbc:postgresql://localhost:5432/exo2_JDBC";
    private static final String USER = "postgres";
    private static final String PASSWORD = "....";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}
