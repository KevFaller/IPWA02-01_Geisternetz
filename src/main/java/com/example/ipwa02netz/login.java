package com.example.ipwa02netz;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;


@WebServlet("/login")
public class login extends HttpServlet {

        public login(){
            super();
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //bekommt es von der login.jsp
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //Testzweck nur fuer Implementierung
        String user = "Kevin";
        String pw = "admin";

        if(user.equals(username) && pw.equals(password)){
            // Begruesung des Users dann auf der index.jsp
            request.setAttribute("Hallo",user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //weiterleiten zu login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);

        //conn Test
        ConnectionDB.createConnection();

    }
    public void destroy() {
    }
}