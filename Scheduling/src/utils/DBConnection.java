/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Ian Harwell
 */
public class DBConnection {
    //JDBC URL Parts
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//wgudb.ucertify.com:3306/";
    private static final String dbName = "WJ06LeB";
    //JDBC URL
    private static final String jdbcURL = protocol + vendorName + ipAddress + dbName + "?connectionTimeZone=SERVER";
    // driver interface reference
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    
    private static final String username = "U06LeB"; //Username
    private static final String password = "53688796364"; //password
    
    /**
     * Connects to DB
     *
     * 
     */
    public static Connection startConnection() {
       try{
           Class.forName(MYSQLJDBCDriver);
           conn = (Connection)DriverManager.getConnection(jdbcURL, username, password);
           System.out.println("Connection Successfull");
    }
    catch(ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        }
    catch(SQLException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
        }
       
       
    return conn;
}
    
    public static Connection getConnection(){
        return conn;
    
}
    public static void closeConnetion(){
        
        
        try {
            conn.close();
            System.out.println("connection Closed");
        } catch (Exception e) {
            //do nothing
        }
         
    
    }
    
            
    
}
