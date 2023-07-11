package com.example.ipwa02netz;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {

        public login(){
            super();
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MyLogger.logInfo("doPost von login.java wurde aufgerufen");
        // Benutzername oder E-Mail-Adresse und Passwort aus dem Request-Objekt abrufen
        String usernameOrEmail = request.getParameter("username");
        String password = request.getParameter("password");
        MyLogger.logInfo("Benutzername oder E-Mail: " + usernameOrEmail);

        // Verbindung zur Datenbank herstellen
        Connection connection = null;
        try {
            connection = ConnectionDB.getConnection();

            // Überprüfen, ob der Benutzer in der Datenbank existiert
            String query = "SELECT * FROM Person WHERE (Vorname = ? OR Mailadresse = ?) AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usernameOrEmail);
            statement.setString(2, usernameOrEmail);
            statement.setString(3, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Benutzer existiert und Passwort ist korrekt
                String username = resultSet.getString("Vorname");

                // Sitzungsvariable erstellen und setzen
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                MyLogger.logInfo("Sitzungsvariable wurde gesetzt");

                // Weitere Verarbeitung oder Weiterleitung zur Index-Seite
                request.setAttribute("Hallo", username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                // Benutzer existiert nicht oder Passwort ist falsch
                response.sendRedirect("register");
                MyLogger.logInfo("Username="+ usernameOrEmail +" oder Password "+ password+" sind falsch eingegeben worden");
            }
        } catch (SQLException e) {
            MyLogger.logInfo(e.getMessage());
            // Fehlerbehandlung
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    MyLogger.logInfo(e.getMessage());
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //weiterleiten zu login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp"); //ligin.jsp
        dispatcher.forward(request, response);


    }
    public void destroy() {
    }

    //abfrage ob sich eingeloggt wurde
    public boolean checkLoginStatus(HttpServletRequest request) {
        // Sitzung abrufen
        HttpSession session = request.getSession();

        // Überprüfen, ob die Sitzungsvariable vorhanden ist
        if (session.getAttribute("username") != null) {
            // Der Benutzer ist eingeloggt
            String username = (String) session.getAttribute("username");
            MyLogger.logInfo("Der Benutzer " + username + " ist eingeloggt.");
            return true;
        } else {
            // Der Benutzer ist nicht eingeloggt
            MyLogger.logInfo("Der Benutzer ist nicht eingeloggt.");
            return false;
        }
    }
}