/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import utils.DBConnection;


/**
 *
 * @author 18018
 */
public class UserDB {
    
    private static User currentUser;
    private static User getCurrentUser() {
        return currentUser;    }
    private static Statement statement;
     // Create Statement Object
    public static void setStatement(Connection conn)throws SQLException {
        statement = conn.createStatement();
    }
    
    //Return Statement object
    public static Statement getStatement() {
        return statement;
    }
    //try to login
    public static Boolean login(String username, String password) {
     try {
            Statement statement = DBConnection.getConnection().createStatement();
            String query = "SELECT * FROM user WHERE userName='" + username + "' AND password='" + password + "'";
            ResultSet results = statement.executeQuery(query);
            /*if(results.next()) {
                currentUser = new User();
                currentUser.setUsername(results.getString("userName"));
                statement.close();
                Logger.log(username, true);
                return true;
            } else {
                Logger.log(username, false);
                return false;
            } */
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        } 
        }


    
}
