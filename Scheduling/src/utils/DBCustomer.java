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
            String s = rs.getString("Division_ID");
            int i = Integer.parseInt(s); 
            if (i == 1) {
            newCustomer.setCustState("Alabama"); 
            }
            else if (i == 2) {
            newCustomer.setCustState("Arizona");
            }
            else if (i == 3) {
            newCustomer.setCustState("Arkansas");
            }
            else if (i == 4) {
            newCustomer.setCustState("California");
            }
            else if (i == 5) {
            newCustomer.setCustState("Colorado");
            }
            else if (i == 6) {
            newCustomer.setCustState("Connecticut");
            }
            else if (i == 7) {
            newCustomer.setCustState("Delaware");
            }
            else if (i == 8) {
            newCustomer.setCustState("District of Columbia");
            }
            else if (i == 9) {
            newCustomer.setCustState("Florida");
            }
            else if (i == 10) {
            newCustomer.setCustState("Georgia");
            }
            else if (i == 11) {
            newCustomer.setCustState("Idaho");
            }
            else if (i == 12) {
            newCustomer.setCustState("Illinois");
            }
            else if (i == 13) {
            newCustomer.setCustState("Indiana");
            }
            else if (i == 14) {
            newCustomer.setCustState("Iowa");
            }
            else if (i == 15) {
            newCustomer.setCustState("Kansas");
            }
            else if (i == 16) {
            newCustomer.setCustState("Kentucky");
            }
            else if (i == 17) {
            newCustomer.setCustState("Louisiana");
            }
            else if (i == 18) {
            newCustomer.setCustState("Maine");
            }
            else if (i == 19) {
            newCustomer.setCustState("Maryland");
            }
            else if (i == 20) {
            newCustomer.setCustState("Massachusetts");
            }
            else if (i == 21) {
            newCustomer.setCustState("Michigan");
            }
            else if (i == 22) {
            newCustomer.setCustState("Minnesota");
            }
            else if (i == 23) {
            newCustomer.setCustState("Mississippi");
            }
            else if (i == 24) {
            newCustomer.setCustState("Missouri");
            }
            else if (i == 25) {
            newCustomer.setCustState("Montana");
            }
            else if (i == 26) {
            newCustomer.setCustState("Nebraska");
            }
            else if (i == 27) {
            newCustomer.setCustState("Nevada");
            }
            else if (i == 28) {
            newCustomer.setCustState("New Hampshire");
            }
            else if (i == 29) {
            newCustomer.setCustState("New Jersey");
            }
            else if (i == 30) {
            newCustomer.setCustState("New Mexico");
            }
            else if (i == 31) {
            newCustomer.setCustState("New York");
            }
            else if (i == 32) {
            newCustomer.setCustState("North Carolina");
            }
            else if (i == 33) {
            newCustomer.setCustState("North Dakota");
            }
            else if (i == 34) {
            newCustomer.setCustState("Ohio");
            }
            else if (i == 35) {
            newCustomer.setCustState("Oklahoma");
            }
            else if (i == 36) {
            newCustomer.setCustState("Oregon");
            }
            else if (i == 37) {
            newCustomer.setCustState("Pennslyvania");
            }
            else if (i == 38) {
            newCustomer.setCustState("Rhode Island");
            }
            else if (i == 39) {
            newCustomer.setCustState("South Carolina");
            }
            else if (i ==  40) {
            newCustomer.setCustState("South Dakota");
            }
            else if (i == 41) {
            newCustomer.setCustState("Tennessee");
            }
            else if (i == 42) {
            newCustomer.setCustState("Texas");
            }
            else if (i == 43) {
            newCustomer.setCustState("Utah");
            }
            else if (i == 44) {
            newCustomer.setCustState("Vermont");
            }
            else if (i == 45) {
            newCustomer.setCustState("Virginia");
            }
            else if (i == 46) {
            newCustomer.setCustState("Washington");
            }
            else if (i == 47) {
            newCustomer.setCustState("West Virginia");
            }
            else if (i == 48) {
            newCustomer.setCustState("Wisconsin");
            }
            else if (i == 49) {
            newCustomer.setCustState("Wyoming");
            }
            else if (i == 52) {
            newCustomer.setCustState("Hawaii");
            }
            else if (i == 54) {
            newCustomer.setCustState("Alaska");
            }
            else if (i == 60) {
            newCustomer.setCustState("Northwest Territory");
            }
            else if (i == 61) {
            newCustomer.setCustState("Alberta");
            }
            else if (i == 62) {
            newCustomer.setCustState("British Columbia");
            }
            else if (i == 63) {
            newCustomer.setCustState("Manitoba");
            }
            else if (i == 64) {
            newCustomer.setCustState("New Brunswick");
            }
            else if (i == 65) {
            newCustomer.setCustState("Nova Scotia");
            }
            else if (i == 66) {
            newCustomer.setCustState("Prince Edward Island");
            }
            else if (i == 67) {
            newCustomer.setCustState("Ontario");
            }
            else if (i == 68) {
            newCustomer.setCustState("Quebec");
            }
            else if (i == 69) {
            newCustomer.setCustState("Saskatchewan");
            }
            else if (i == 70) {
            newCustomer.setCustState("Nunavut");
            }
            else if (i == 71) {
            newCustomer.setCustState("Yukon");
            }
            else if (i == 72) {
            newCustomer.setCustState("Newfoundland and Labrador");
            }
            else if (i == 101) {
            newCustomer.setCustState("England");
            }
            else if (i == 102) {
            newCustomer.setCustState("Wales");
            }
            else if (i == 103) {
            newCustomer.setCustState("Scotland");
            }
            else if (i == 104) {
            newCustomer.setCustState("Northern Ireland");
            };
         
            if(i < 60 ){
                newCustomer.setCustCountry("USA");
            }
                else if ( i > 59 && i < 100){
                    newCustomer.setCustCountry("Canada");
            }
                else if ( i > 99 ){
                    newCustomer.setCustCountry("UK");
                };
                                       
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
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + " " + stateChoice + " " + countryChoice + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "15" +
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
