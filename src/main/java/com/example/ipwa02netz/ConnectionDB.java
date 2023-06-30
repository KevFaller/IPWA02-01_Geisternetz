package com.example.ipwa02netz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            String userName = "postgres";
            String pw = "Bayern";
            String url = "jdbc:postgresql://database:5432/postgres";

            connection = DriverManager.getConnection(url, userName, pw);
            System.out.println("****  DB-Connection = true ****");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehlermeldung: " + e.getMessage());
        }
    }
}
