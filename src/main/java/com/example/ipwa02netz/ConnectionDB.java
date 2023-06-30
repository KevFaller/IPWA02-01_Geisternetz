package com.example.ipwa02netz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String DB_URL = "jdbc:postgresql://database:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Bayern";

    public static Connection getConnection() {
        return createConnection();
    }

    private static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            MyLogger.logInfo("Connectionfehler 1: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            MyLogger.logInfo("Connectionfehler 2: " + e.getMessage());
        }
        return connection;
    }
}
