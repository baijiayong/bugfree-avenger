package com.baldurtech;

import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Member> showMember()
    {
        DatabaseManager databaseManager = null;
        List<Member> memberList = new ArrayList<Member>();
       
        
        try
        {
            databaseManager = DatabaseManager.newInstance();

            databaseManager.prepare("SELECT * FROM member_info");
            ResultSet rs = databaseManager.executeQuery();
         
            while(rs.next())
            {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setUsername(rs.getString("user_name"));
                member.setPassword(rs.getString("password"));
                member.setSex(rs.getString("sex"));
                member.setEmail(rs.getString("email"));
                member.setTelephone(rs.getString("telephone"));
                member.setAddress(rs.getString("address"));
                memberList.add(member);
            }
        }catch(SQLException ex)
        {
            System.out.println("SQLExcepiton: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Vendor: " + ex.getErrorCode());
            System.out.println("ERROR");
        }finally
        {
            databaseManager.close();
        }
        return memberList;
    }
    public Member show(Member member)
    {
        DatabaseManager databaseManager = null;
        
        try
        {
            databaseManager = DatabaseManager.newInstance();
            databaseManager.prepare("SELECT * FROM member_info WHERE id=" + member.getId());
            ResultSet rs = databaseManager.executeQuery();
            while(rs.next())
            {
                member.setUsername(rs.getString("user_name"));
                member.setAddress(rs.getString("address"));
                member.setTelephone(rs.getString("telephone"));
                member.setSex(rs.getString("sex"));
            }
        }catch(SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Vendor: " + ex.getErrorCode());
            System.out.println("Error");
        }finally
        {
            databaseManager.close();
        }
        return member;
    }
    public Member delete(Member member)
    {
        DatabaseManager databaseManager = null;
        
        try
        {
            databaseManager = DatabaseManager.newInstance();
            databaseManager.prepare("DELETE FROM member_info WHERE id=" + member.getId());
            databaseManager.execute();
        }catch(SQLException ex)
        {
            System.out.println("SQLException:" + ex.getMessage());
            System.out.println("SQLState:" + ex.getSQLState());
            System.out.println("Vendor:" + ex.getErrorCode());
            System.out.println("Error");
        }finally
        {
            databaseManager.close();
        }
        return member;
    }
    public void update(Member member)
    {
        DatabaseManager databaseManager = null;
        
        try
        {
            databaseManager = DatabaseManager.newInstance();
            databaseManager.prepare("UPDATE member_info SET user_name = ?,sex = ?,email = ?,telephone = ?,address = ? WHERE id =" + member.getId());
            databaseManager.setString(member.getUsername());
            databaseManager.setString(member.getSex());
            databaseManager.setString(member.getEmail());
            databaseManager.setString(member.getTelephone());
            databaseManager.setString(member.getAddress());
            databaseManager.execute();
        }catch(SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Vendor: " + ex.getErrorCode());
            System.out.println("Error");
        }finally
        {
            databaseManager.close();
        }
    }
       
}