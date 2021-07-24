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
import utils.DBQuery;
import utils.Logger;

/**
 *
 * @author 18018
 */
public class UserDB {
    
    private static User currentUser;
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    //try to login
    public static Boolean login(String username, String password) {
     try {  
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "SELECT * FROM users WHERE User_Name='" + username + "' AND Password='" + password + "'";
            ResultSet results = statement.executeQuery(query);
            if(results.next()) {
                currentUser = new User();
                currentUser.setUsername(results.getString("User_Name"));
                statement.close();
                Logger.log(username, true);
                return true;
            } else {
                Logger.log(username, false);
                return false;
            } 
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        } 
        //return null;
        }


    
}
