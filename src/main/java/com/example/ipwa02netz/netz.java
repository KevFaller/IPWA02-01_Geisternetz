package com.example.ipwa02netz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/netz")
public class netz extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Array mit Geisternetz-Daten abrufen
        netzArrayCreat netzArrayCreator = new netzArrayCreat();
        String[] geisternetzArray = netzArrayCreator.getGeisternetzArray();

        // Das Array als Attribut zum Request hinzufügen
        request.setAttribute("geisternetzArray", geisternetzArray);

        // Weiterleiten zu netz.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("netz.jsp");
        dispatcher.forward(request, response);

    }
}
