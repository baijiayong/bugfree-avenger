package com.baldurtech;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;


public class Order extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");
        
        if("List".equalsIgnoreCase(action))
        {
            list(req,resp);
        }else if("Show".equalsIgnoreCase(action))
        {
            show(req,resp);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getParameter("action");

        if("register".equalsIgnoreCase(action))
        {   
            register(req,resp);
        }
        else if("doRegister".equalsIgnoreCase(action))
        {
            doRegister(req,resp);
        }

    }
    public void forward(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException
    {
        String jsp = "/WEB-INF/order/" + page + ".jsp";
        getServletContext().getRequestDispatcher(jsp).forward(req,resp);
    }
    public void register(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        forward(req,resp,"register");
    }
    public void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Member member = new Member();
       
        String username = req.getParameter("user_name");
        String password = req.getParameter("pass_word");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String address = req.getParameter("address");
        
        MemberDao memberDao = new MemberDao();
        member.setUsername(username);
        member.setPassword(password);
        member.setSex(sex);
        member.setEmail(email);
        member.setTelephone(telephone);
        member.setAddress(address);
        memberDao.addMember(member);
    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
    {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        
        MemberDao memberDao = new MemberDao();
        req.setAttribute("memberList",memberDao.showMember());
        forward(req,resp,"list");
    }
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    
    }
}