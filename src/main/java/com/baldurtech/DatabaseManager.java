package com.baldurtech;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseManager
{
    private Integer paramIndex = null;
    public static PreparedStatement pstmt = null;
    public static Connection conn = null;
    
    static final String jdbcUrl = "jdbc:mysql://localhost/test?" + "user=root" + "&password=";
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    
    private DatabaseManager() 
    {
        
    }
    static public DatabaseManager newInstance() throws SQLException
    {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.conn = databaseManager.createConnection();
        return databaseManager;
       
    }
    public Connection createConnection() throws SQLException
    {   
        try
        {
           // Class.forName("com.mysql.jdbc.Driver").newInstance();
           Class.forName(jdbcDriver).newInstance();
        }catch(Exception ex)
        {
            //ignore;
        }
        //return DriverManager.getConnection("jdbc:mysql://localhost/test?" 
          //                                                              + "user=root"
            //                                                            + "&password=");
         return DriverManager.getConnection(jdbcUrl);
    }
    public DatabaseManager prepare(String sql)throws SQLException
    {
        pstmt = conn.prepareStatement(sql);
        paramIndex = 1;
        return this;
    }
    public DatabaseManager setString(String param) throws SQLException
    {
        pstmt.setString(paramIndex,param);
        paramIndex++;
        return this;
    }
    public DatabaseManager setInt(int param) throws SQLException
    {
        pstmt.setInt(paramIndex,param);
        paramIndex++;
        return this;
    }
    public Boolean execute() throws SQLException
    {
        return pstmt.execute();
    }
    public ResultSet executeQuery() throws SQLException
    {
        return pstmt.executeQuery();
    }
}