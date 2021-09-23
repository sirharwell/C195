/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.Contacts;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ian Harwell
 */
public class DBContacts {
    
        private static ObservableList<Contacts> contact = FXCollections.observableArrayList();
    
    /**
     * Gets all Contacts from DB
     *
     * 
     */
    public static ObservableList<Contacts> getAllContacts() {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "SELECT * FROM contacts";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {

            Contacts newContact = new Contacts();
            newContact.setContact_ID(rs.getInt("Contact_ID"));
            newContact.setContact_Name(rs.getString("Contact_Name"));
            newContact.setEmail(rs.getString("Email"));
            Contacts.addContacts(newContact);         

            }
            statement.close();
            return contact;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
}}
