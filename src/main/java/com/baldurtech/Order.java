package com.baldurtech;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
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
        
        String username = req.getParameter("user_name");
        String password = req.getParameter("pass_word");
        String action = req.getParameter("action");
             
        if("register".equalsIgnoreCase(action))
        {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            forward(req,resp,"register");
        }
    }
    public void forward(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException
    {
        String jsp = "/WEB-INF/order/" + page + ".jsp";
        getServletContext().getRequestDispatcher(jsp).forward(req,resp);
    }
}