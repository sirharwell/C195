/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.Customer;
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
public class DBCustomer {
    
    private static ObservableList<Customer> customers = FXCollections.observableArrayList();
    
 
    
    // Returns all Customers in Database
    public static ObservableList<Customer> getAllCustomers() {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "SELECT * FROM customers";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {

            Customer newCustomer = new Customer();
            newCustomer.setCustName(rs.getString("Customer_Name"));
            newCustomer.setCustAddress(rs.getString("Address"));
            newCustomer.setCustPhone(rs.getString("Phone"));
            newCustomer.setCustZip(rs.getString("Postal_Code"));
            newCustomer.setCustCountry(rs.getString("Address"));
            newCustomer.setCustState(rs.getString("Address"));                                        
            newCustomer.setCustId(rs.getInt("Customer_ID"));
            Customer.addCustomer(newCustomer);         

            }
            statement.close();
            return customers;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
    }
    
    public static boolean saveCustomer( int id, String customerName, String address, String phone, String postalCode, String stateChoice, String countryChoice) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "INSERT INTO customers(Customer_Name, Address, Phone, Postal_Code, Customer_ID)" + 
                    "VALUES(" +
                    "'" + customerName + "'" +
                    "'" + address + " " + stateChoice + " " + countryChoice + "'" +
                    "'" + phone + "'" +
                    "'" + postalCode + "'" +
                    "'" + id + "'" + ")";
            
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
            String query = "DELETE * FROM customers";
            
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
}
