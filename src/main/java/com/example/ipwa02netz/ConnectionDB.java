package com.example.ipwa02netz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            String userName = "postgres";
            String pw = "Bayern";
            String url = "jdbc:postgresql://localhost:5113/netzdb?serverTimezone=UTC";

            Connection connection = DriverManager.getConnection(url, userName, pw);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehlermeldung: " + e.getMessage());
        }
    }
}
