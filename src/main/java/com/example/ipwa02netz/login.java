package com.example.ipwa02netz;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Hier wird der POST-Request verarbeitet
        // Hier können Sie Benutzerdaten überprüfen und Authentifizierung durchführen

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Beispielüberprüfung des Benutzernamens und Passworts
        if (username.equals("admin") && password.equals("pass123")) {
            // Authentifizierung erfolgreich
            response.getWriter().println("Login erfolgreich!");
        } else {
            // Authentifizierung fehlgeschlagen
            response.getWriter().println("Login fehlgeschlagen!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Hier wird der GET-Request verarbeitet
        response.getWriter().println("GET-Methode ist nicht unterstützt. Verwenden Sie die POST-Methode für den Login.");
    }
    public void destroy() {
    }
}