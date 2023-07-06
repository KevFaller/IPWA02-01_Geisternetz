package com.example.ipwa02netz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class netzArrayCreat {
    public String[] getGeisternetzArray() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> geisternetzList = new ArrayList<>();

        try {
            // Datenbankverbindung herstellen
            connection = ConnectionDB.getConnection();

            // SQL-Abfrage vorbereiten
            String sql = "SELECT Geolocation, GeschaetzteGroesse, Statusname FROM Geisternetz " +
                    "JOIN Status ON Geisternetz.Status_ID = Status.Status_ID";
            statement = connection.prepareStatement(sql);

            // SQL-Abfrage ausführen
            resultSet = statement.executeQuery();

            // Ergebnis verarbeiten und Daten in das Array speichern
            while (resultSet.next()) {
                String geolocation = resultSet.getString("Geolocation");
                String groesse = resultSet.getString("GeschaetzteGroesse");
                String status = resultSet.getString("Statusname");

                String data = "Geolocation: " + geolocation +
                        ", Größe: " + groesse +
                        ", Status: " + status;

                geisternetzList.add(data);
            }
        } catch (SQLException e) {
            MyLogger.logInfo(e.getMessage());
        } finally {
            // Ressourcen schließen
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    MyLogger.logInfo(e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    MyLogger.logInfo(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    MyLogger.logInfo(e.getMessage());
                }
            }
        }

        // Array aus der Liste erstellen und zurückgeben
        MyLogger.logInfo("Netzarray wurde erstellt");
        return geisternetzList.toArray(new String[0]);
    }
}
