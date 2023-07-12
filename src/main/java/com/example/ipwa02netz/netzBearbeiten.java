package com.example.ipwa02netz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/netzBearbeiten")
public class netzBearbeiten extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Status aus dem Formular erhalten
        String status = request.getParameter("status");
        MyLogger.logInfo("doPost von netzBearbeiten wurde aufgerufen, und der status: "+status+" wurde uebergeben.");

        if (status != null && status.equals("melden")) {
            // GPS-Daten und Größe aus dem Formular erhalten
            String gpsData = request.getParameter("inputGPS");
            String groesse = request.getParameter("inputGroese");
            String gpsData2 = "POINT("+gpsData+")";
            // SQL-Statement zum Einfügen der Daten erstellen
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO Geisternetz (Geolocation, GeschaetzteGroesse, Status_ID) VALUES ")
                    .append("('").append(gpsData2).append("', '").append(groesse).append("', 1);");

            // Datenbankverbindung herstellen
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = ConnectionDB.getConnection();

                // PreparedStatement erstellen und das SQL-Statement setzen
                statement = connection.prepareStatement(sql.toString());

                // SQL-Statement ausführen
                statement.executeUpdate();

            } catch (SQLException e) {
                // Fehlerbehandlung bei SQL-Fehlern
                MyLogger.logInfo(e.getMessage());

            } finally {
                // Ressourcen schließen
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
        } else if (status != null && status.equals("bergen")) {
            login Login = new login();
            boolean logStatus = Login.checkLoginStatus(request);

            if(logStatus == true){
                // Netz aus dem Formular erhalten
                String selectedNetz = request.getParameter("netz");
                MyLogger.logInfo("selectedNetz= "+selectedNetz);
                Pattern pattern = Pattern.compile("Geolocation: POINT\\((.*?)\\),");
                Matcher matcher = pattern.matcher(selectedNetz);
                String gpsData = "";
                if (matcher.find()) {
                    gpsData = matcher.group(1);
                    gpsData = "POINT(" + gpsData + ")";
                }

                // SQL-Statement zum Löschen des Netzes erstellen
                String deleteSql = "DELETE FROM Geisternetz WHERE Geolocation = ?";
                // Datenbankverbindung herstellen
                Connection connection = null;
                PreparedStatement deleteStatement = null;

                try {
                    connection = ConnectionDB.getConnection();

                    // PreparedStatement erstellen und das SQL-Statement setzen
                    deleteStatement = connection.prepareStatement(deleteSql);
                    deleteStatement.setString(1, gpsData);
                    MyLogger.logInfo("Delete SQL Statement: " + deleteStatement.toString());

                    // SQL-Statement ausführen
                    deleteStatement.executeUpdate();

                } catch (SQLException e) {
                    // Fehlerbehandlung bei SQL-Fehlern
                    MyLogger.logInfo(e.getMessage());

                } finally {
                    // Ressourcen schließen
                    if (deleteStatement != null) {
                        try {
                            deleteStatement.close();
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

            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }


        } else if (status != null && status.equals("verschollen")) {

                // Aufgabe: Als beliebige Person soll man ein Netz als verschollen melde koennen daher kein Login ueberpruefung

            // Netz aus dem Formular erhalten
            String selectedNetz = request.getParameter("netz");
            MyLogger.logInfo("selectedNetz= " + selectedNetz);

// Extrahiere die Geolocation aus dem ausgewählten Netz
            Pattern pattern = Pattern.compile("Geolocation: POINT\\((.*?)\\),");
            Matcher matcher = pattern.matcher(selectedNetz);
            String gpsData = "";
            if (matcher.find()) {
                gpsData = matcher.group(1);
                gpsData = "POINT(" + gpsData + ")";
            }

// SQL-Statement zum Aktualisieren des Status auf "verschollen" erstellen
            String updateSql = "UPDATE Geisternetz SET Status_ID = (SELECT Status_ID FROM Status WHERE Statusname = 'Verschollen') WHERE Geolocation = ?";
// Datenbankverbindung herstellen
            Connection connection = null;
            PreparedStatement updateStatement = null;

            try {
                connection = ConnectionDB.getConnection();

                // PreparedStatement erstellen und das SQL-Statement setzen
                updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setString(1, gpsData);
                MyLogger.logInfo("Update SQL Statement: " + updateStatement.toString());

                // SQL-Statement ausführen
                updateStatement.executeUpdate();
                } catch (SQLException e) {
                    // Fehlerbehandlung bei SQL-Fehlern
                    MyLogger.logInfo(e.getMessage());

                } finally {
                    // Ressourcen schließen
                    if (updateStatement != null) {
                        try {
                            updateStatement.close();
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



        } else if (status != null && status.equals("Bergung bevorstehend")) {
            login Login = new login();
            boolean logStatus = Login.checkLoginStatus(request);

            if(logStatus == true){
                // Netz aus dem Formular erhalten
                String selectedNetz = request.getParameter("netz");
                MyLogger.logInfo("selectedNetz= " + selectedNetz);

                // Extrahiere die Geolocation aus dem ausgewählten Netz
                Pattern pattern = Pattern.compile("Geolocation: POINT\\((.*?)\\),");
                Matcher matcher = pattern.matcher(selectedNetz);
                String gpsData = "";
                if (matcher.find()) {
                    gpsData = matcher.group(1);
                    gpsData = "POINT(" + gpsData + ")";
                }

                // SQL-Statement zum Aktualisieren des Status auf "verschollen" erstellen
                String updateSql = "UPDATE Geisternetz SET Status_ID = (SELECT Status_ID FROM Status WHERE Statusname = 'Verschollen') WHERE Geolocation = ?";
                // Datenbankverbindung herstellen
                Connection connection = null;
                PreparedStatement updateStatement = null;

                try {
                    connection = ConnectionDB.getConnection();

                    // PreparedStatement erstellen und das SQL-Statement setzen
                    updateStatement = connection.prepareStatement(updateSql);
                    updateStatement.setString(1, gpsData);
                    MyLogger.logInfo("Update SQL Statement: " + updateStatement.toString());

                    // SQL-Statement ausführen
                    updateStatement.executeUpdate();

                } catch (SQLException e) {
                    // Fehlerbehandlung bei SQL-Fehlern
                    MyLogger.logInfo(e.getMessage());

                } finally {
                    // Ressourcen schließen
                    if (updateStatement != null) {
                        try {
                            updateStatement.close();
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

            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        }

        // Weiterleiten
        // Array mit Geisternetz-Daten abrufen
        netzArrayCreat netzArrayCreator = new netzArrayCreat();
        String[] geisternetzArray = netzArrayCreator.getGeisternetzArray();

        // Das Array als Attribut zum Request hinzufügen
        request.setAttribute("geisternetzArray", geisternetzArray);

        // Weiterleiten zu netz.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("netz.jsp");
        dispatcher.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Weiterleiten zu netzBearbeiten.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("netzBearbeiten.jsp");
        dispatcher.forward(request, response);
    }


}
