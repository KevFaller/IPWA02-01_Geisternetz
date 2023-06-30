package com.example.ipwa02netz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.Statement;

@WebListener
public class DatabaseInitializationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Connection-Instanz aus ConnectionDB-Klasse abrufen
            Connection connection = ConnectionDB.getConnection();
            Statement statement = connection.createStatement();

            // SQL-Skript ausführen
            String sqlScript = "CREATE TABLE ..."; // Hier dein SQL-Skript einfügen
            statement.executeUpdate(sqlScript);

            // Verbindung schließen
            statement.close();
            connection.close();

            System.out.println("SQL-Skript erfolgreich ausgeführt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Aufräumarbeiten, wenn die Webanwendung beendet wird
    }
}
