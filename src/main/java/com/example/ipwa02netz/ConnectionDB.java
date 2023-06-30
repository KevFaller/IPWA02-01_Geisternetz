package com.example.ipwa02netz;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static void createConnection() {


        try {
            Class.forName("org.postgresql.Driver");

            String userName = "postgres";
            String pw = "Bayern";
            String url = "jdbc:postgresql://database:5432/postgres";

            Connection connection = DriverManager.getConnection(url, userName, pw);
            System.out.println("****  DB-Connection = true ****");
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehlermeldung: " + e.getMessage());
        }
    }
}
