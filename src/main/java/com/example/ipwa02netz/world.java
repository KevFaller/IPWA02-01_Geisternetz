package com.example.ipwa02netz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/world")
public class world extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //weiterleiten zu login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("world.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //weiterleiten zu world.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("world.jsp");
        dispatcher.forward(request, response);
    }
}
