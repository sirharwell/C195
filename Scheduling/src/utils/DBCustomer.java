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
    
    // Saves new Customer to Database
    public static boolean saveCustomer(String customerName, String address, String postalCode, String phone) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String queryOne = "INSERT INTO address SET address='" + address + "', phone='" + phone + "', Postal_Code='" + postalCode;
            int updateOne = statement.executeUpdate(queryOne);
            if(updateOne == 1) {
                int addressId = customers.size() + 1;
                String queryTwo = "INSERT INTO customer SET customerName='" + customerName + "', addressId=" + addressId;
                int updateTwo = statement.executeUpdate(queryTwo);
                if(updateTwo == 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
    // Update existing Customer in Database
    public static boolean updateCustomer(int id, String name, String address, String zip, String phone) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String queryOne = "UPDATE address SET address='" + address + ", postalCode='" + zip + "', phone='" + phone + "' "
                + "WHERE addressId=" + id;
            int updateOne = statement.executeUpdate(queryOne);
            if(updateOne == 1) {
                String queryTwo = "UPDATE customer SET customerName='" + name + "', addressId=" + id + " WHERE customerId=" + id;
                int updateTwo = statement.executeUpdate(queryTwo);
                if(updateTwo == 1) {
                    return true;
                }
            }
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
    // Delete Customer from Database
    public static boolean deleteCustomer(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String queryOne = "DELETE FROM address WHERE addressId=" + id;
            int updateOne = statement.executeUpdate(queryOne);
            if(updateOne == 1) {
                String queryTwo = "DELETE FROM customer WHERE customerId=" + id;
                int updateTwo = statement.executeUpdate(queryTwo);
                if(updateTwo == 1) {
                    return true;
                }
            }
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
}
