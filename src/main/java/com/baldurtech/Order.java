package com.baldurtech;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Order extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
       resp.getWriter().println("This is my first order_food system.");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    
    }
}