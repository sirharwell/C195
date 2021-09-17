/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.Appointments;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Customer;
/**
 *
 * @author 18018
 */
public class DBAppointments {
    private static ObservableList<Appointments> appointment = FXCollections.observableArrayList();
    
 
    
    // Returns all Customers in Database
    public static ObservableList<Appointments> getAllAppointments() {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "SELECT * FROM appointments";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {

            Appointments newAppointment = new Appointments();
            newAppointment.setAptTitle(rs.getString("Title"));
            newAppointment.setAptDescription(rs.getString("Description"));
            newAppointment.setAptLocation(rs.getString("Location"));
            newAppointment.setAptType(rs.getString("Type"));
            newAppointment.setAptContact(rs.getString("Contact_ID"));
            String start = rs.getString("Start");
            String end = rs.getString("End");
            String[] sStart = start.split(" ");
            String[] sEnd = end.split(" ");
            newAppointment.setAptDStart(sStart[0]);
            newAppointment.setAptTStart(sStart[1]);
            newAppointment.setAptDEnd(sEnd[0]);
            newAppointment.setAptTEnd(sEnd[1]);
            newAppointment.setAptType(rs.getString("Type"));
            newAppointment.setAptType(rs.getString("Type"));
            int s = rs.getInt("Customer_ID");
            for(Customer c : Customer.customers){
            if(c.getCustId() == s){
                newAppointment.setAptCustId(c);}
            }

            Appointments.addAppointments(newAppointment);         

            }
            statement.close();
            return appointment;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
    }
    static int s;
    public static boolean saveCustomer( int id, String customerName, String address, String phone, String postalCode, String stateChoice, String countryChoice) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String i = stateChoice; 

            
            
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    s +
                    ")";
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
    
    
    // Delete Customer from Database
    public static boolean deleteCustomer() throws SQLException {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "DELETE FROM customers";
            statement.execute(query);
            
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
}
