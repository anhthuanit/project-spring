/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faber.connectionDB;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class DBConnect {
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String DB_PATH = "jdbc:mysql://172.30.4.132:3306/Test";
   
    String userName = "mieruca";
    String password = "faber@2016";
    Connection conn= null;
    Statement stmt = null;
    
    public void connect() throws SQLException, Exception {
        Class.forName(DRIVER);
        System.out.println("Connecting...");
        conn = (Connection) DriverManager.getConnection(DB_PATH,userName,password);
        stmt = (Statement) conn.createStatement();
        
    }
    public void closeConnection() throws SQLException, Exception {
        conn.close();
        stmt.close();
    }
        
    
    public Statement getStatement(){
        return stmt;
    }
    
    public Connection getConnection(){
        return conn;
    }
}

