package com.example.ipwa02netz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInitialization {

    public static void initializeDatabase() {
        try {
            // Connection-Instanz aus ConnectionDB-Klasse abrufen
            Connection connection = ConnectionDB.getConnection();
            MyLogger.logInfo("** INFO**  Connection initializeDatabase wurde erzeugt");
            Statement statement = connection.createStatement();

            // Prüfen, ob die Datenbank leer ist
            //boolean isDatabaseEmpty = checkIfDatabaseIsEmpty(statement);
            boolean isDatabaseEmpty = true;
            // Wenn die Datenbank leer ist, SQL-Skript ausführen
            if (isDatabaseEmpty) {
                String sqlScript = sqlScriptCreat.getSQLScript();
                statement.executeUpdate(sqlScript);
                MyLogger.logInfo("** INFO**  SQL-Skript erfolgreich ausgeführt");
            } else {
                MyLogger.logInfo("** INFO**  Die Datenbank enthält bereits Daten. Das SQL-Skript wird nicht ausgeführt.");
            }

            // Verbindung schließen
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Methode zum Überprüfen, ob die Datenbank leer ist
    private static boolean checkIfDatabaseIsEmpty(Statement statement) {
        try {
            MyLogger.logInfo("** INFO**  Es wird geprüft, ob die Datenbank leer ist");
            // Beispielabfrage für eine Tabelle (hier: Geisternetz)
            String query = "SELECT 1 FROM Geisternetz LIMIT 1";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 0; // Wenn die Anzahl der Datensätze 0 ist, ist die Datenbank leer
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fehlerbehandlung: Annahme, dass die Datenbank nicht leer ist
        return false;
    }
}
