package com.baldurtech;

import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.Connection;

public class MemberDao
{
    
    public void addMember(Member member)
    {
        DatabaseManager databaseManager  = null;
        try
        {
            databaseManager = DatabaseManager.newInstance();
            databaseManager.prepare("INSERT INTO member_info(user_name,password,sex,email,telephone,address) VALUES (?,?,?,?,?,?)");
            databaseManager.setString(member.getUsername());
            databaseManager.setString(member.getPassword());
            databaseManager.setString(member.getSex());
            databaseManager.setString(member.getEmail());
            databaseManager.setString(member.getTelephone());
            databaseManager.setString(member.getAddress());
            databaseManager.execute();
        }
        catch(SQLException ex) 
        {
            System.out.println("SQLExcepiton: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Vendor: " + ex.getErrorCode());
            System.out.println("Error");
        }finally
        {
            databaseManager.close();
        }
    }
    public void showMember(Member member)
    {
     
    }
}