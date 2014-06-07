package com.baldurtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthLogin extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {   
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        session.getAttribute("memberId");
       
        if("logout".equalsIgnoreCase(action))
        {
            session = req.getSession();
            session.removeAttribute("memberId");
            resp.sendRedirect(req.getContextPath());
            return;
        }
        if(isNotLogin(req))
        {
            forward(req,resp,"login");
        }else
        {
            resp.sendRedirect(req.getContextPath());
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("user_name");
        String password = req.getParameter("pass_word");
              
        if("admin".equals(username) && "123".equals(password))
        {   
            HttpSession session = req.getSession();
            session.setAttribute("memberId",0L);
            forward(req,resp,"loginSuccess");
        }else 
        {
            forward(req,resp,"loginFailed");
        } 
    }
    public Boolean isNotLogin(HttpServletRequest req) throws ServletException, IOException
    {  
        Long memberId =(Long) req.getSession().getAttribute("memberId");
        return null == memberId;
    }
    public void forward(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException
    {
        String jsp = "/WEB-INF/order/" + page + ".jsp";
        getServletContext().getRequestDispatcher(jsp).forward(req,resp);
    }
    
}