package com.example.ipwa02netz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
            String sql = "SELECT G.Geolocation, G.GeschaetzteGroesse, S.Statusname, P1.Vorname AS GemeldetVonVorname, P1.Nachname AS GemeldetVonNachname, P2.Vorname AS BergungZugewiesenVorname, P2.Nachname AS BergungZugewiesenNachname " +
                    "FROM Geisternetz G " +
                    "JOIN Status S ON G.Status_ID = S.Status_ID " +
                    "LEFT JOIN Person P1 ON G.GemeldetVon = P1.Person_ID " +
                    "LEFT JOIN Person P2 ON G.BergungZugewiesen = P2.Person_ID";



            MyLogger.logInfo(sql);

            statement = connection.prepareStatement(sql);

            // SQL-Abfrage ausführen
            resultSet = statement.executeQuery();

            // Ergebnis verarbeiten und Daten in das Array speichern
            while (resultSet.next()) {
                String geolocation = resultSet.getString("Geolocation");
                String groesse = resultSet.getString("GeschaetzteGroesse");
                String status = resultSet.getString("Statusname");
                String gemeldetVonVorname = resultSet.getString("GemeldetVonVorname");
                String gemeldetVonNachname = resultSet.getString("GemeldetVonNachname");
                String bergungZugewiesenVorname = resultSet.getString("BergungZugewiesenVorname");
                String bergungZugewiesenNachname = resultSet.getString("BergungZugewiesenNachname");

                if (bergungZugewiesenVorname == null && bergungZugewiesenNachname == null) {
                    bergungZugewiesenVorname = "Noch nicht";
                    bergungZugewiesenNachname = "zugewiesen";
                }

                String data = "Geolocation: " + geolocation +
                        ", Größe: " + groesse +
                        ", Status: " + status +
                        ", Gemeldet von: " + gemeldetVonVorname + " " + gemeldetVonNachname +
                        ", Bergung zugewiesen: " + bergungZugewiesenVorname + " " + bergungZugewiesenNachname;

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

//        // Array aus der Liste erstellen und zurückgeben
//        String[] geisternetzArray = geisternetzList.toArray(new String[0]);
//        MyLogger.logInfo("Netzarray wurde erstellt: " + Arrays.toString(geisternetzArray));
//        return geisternetzArray;

    }
}
