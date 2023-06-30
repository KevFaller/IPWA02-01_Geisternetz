package com.example.ipwa02netz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/register")
public class register extends HttpServlet {

    public register(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Daten aus dem Request-Objekt abrufen
        String vorname = request.getParameter("rVorname");
        String nachname = request.getParameter("rNachname");
        String password = request.getParameter("rPassword");
        String mailadresse = request.getParameter("rMail");
        String telefonnummer = request.getParameter("rTelefon");

        // Daten in die Datenbank einfügen
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Verbindung zur Datenbank herstellen
            connection = ConnectionDB.getConnection();
            
            // SQL-INSERT-Anweisung vorbereiten
            String sql = "INSERT INTO Person (Vorname, Nachname, Mailadresse, Password, Telefonnummer) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            // Parameter in die SQL-Anweisung einsetzen
            statement.setString(1, vorname);
            statement.setString(2, nachname);
            statement.setString(3, mailadresse);
            statement.setString(4, password);
            statement.setString(5, telefonnummer);

            // SQL-INSERT-Anweisung ausführen
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                // Erfolgreich eingefügt, weiterleiten zur Login-Seite
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
                MyLogger.logInfo("Registrierung von " + vorname + " " + nachname + " war erfolgreich");
            } else {
                // Fehler beim Einfügen, Fehlerseite anzeigen o.ä.
                MyLogger.logInfo("Registrierung von " + vorname + " " + nachname + " FEHLGESCHLAGEN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Verbindung und Ressourcen schließen
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        //weiterleiten zu login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //weiterleiten zu register.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);

    }
    public void destroy() {
    }
}
