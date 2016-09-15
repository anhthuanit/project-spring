package com.faber.connectionDB;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//</editor-fold>

/**
 *
 * @author Ho Anh Thuan
 */
public class DBConnect {
    static String DRIVER = "com.mysql.jdbc.Driver";
    static String DB_PATH = "jdbc:mysql://172.30.4.132:3306/Test";
    static String userName = "mieruca";
    static String password = "faber@2016";
    Connection conn= null;
    
    //<editor-fold defaultstate="collapsed" desc="CONNECT DB">
    public static Connection connect() throws SQLException, Exception {
        Class.forName(DRIVER);
        System.out.println("Connecting...");
        return (Connection) DriverManager.getConnection(DB_PATH,userName,password);
        
    }
    //</editor-fold>
    
}

