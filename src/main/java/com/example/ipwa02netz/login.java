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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            //weiterleiten zu login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);


        //PrintWriter writer = response.getWriter();

       // writer.println("<!DOCTYPE html>");
        //writer.println("<html>");
       // writer.println("<body>");
        //writer.println("<h1> FC Bayern Munchen </h1>");
       //writer.println("</body>");
       // writer.println("</html>");
    }
    public void destroy() {
    }
}