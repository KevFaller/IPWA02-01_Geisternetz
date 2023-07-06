package com.example.ipwa02netz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/netzBearbeiten")
public class netzBearbeiten extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Weiterleiten zu netz.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("netzBearbeiten.jsp");
        dispatcher.forward(request, response);

    }
}
