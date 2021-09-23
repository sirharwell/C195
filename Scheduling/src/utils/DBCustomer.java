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
 * @author Ian Harwell
 */
public class DBCustomer {
    
    private static ObservableList<Customer> customers = FXCollections.observableArrayList();

    /**
     * Gets all customers from DB
     *
     * 
     */
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
    static int s;
    
    /**
     * Saves all Customers to DB
     *
     * 
     */
    public static boolean saveCustomer( int id, String customerName, String address, String stateChoice, String phone, String postalCode) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String i = stateChoice; 
            if (i == "Alabama") {
            int s = 1;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Arizona") {
            int s = 2;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Arkansas") {
            int s = 3;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "California") {
            int s = 4;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Colorado") {
            int s = 5;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Connecticut") {
            int s = 6;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Delaware") {
            int s = 7;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "District of Columbia") {
            int s = 8;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Florida") {
            int s = 9;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Georgia") {
            int s = 10;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Idaho") {
            int s = 11;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Illinois") {
            int s = 12;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Indiana") {
            int s = 13;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Iowa") {
            int s = 14;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Kansas") {
            int s = 15;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Kentucky") {
            int s = 16;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Louisiana") {
            int s = 17;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Maine") {
            int s = 18;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Maryland") {
            int s = 19;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Massachusetts") {
            int s = 20;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Michigan") {
            int s = 21;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Minnesota") {
            int s = 22;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Mississippi") {
            int s = 23;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Missouri") {
            int s = 24;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Montana") {
            int s = 25;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Nebraska") {
            int s = 26;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Nevada") {
            int s = 27;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "New Hampshire") {
            int s = 28;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "New Jersey") {
            int s = 29;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "New Mexico") {
            int s = 30;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "New York") {
            int s = 31;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "North Carolina") {
            int s = 32;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "North Dakota") {
            int s = 33;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Ohio") {
            int s = 34;String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Oklahoma") {
            int s = 35;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Oregon") {
            int s = 36;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Pennslyvania") {
            int s = 37;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Rhode Island") {
            int s = 38;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "South Carolina") {
            int s = 39;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i ==  "South Dakota") {
            int s = 40;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Tennessee") {
            int s = 41;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Texas") {
            int s = 42;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Utah") {
            int s = 43;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Vermont") {
            int s = 44;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Virginia") {
            int s = 45;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Washington") {
            int s = 46;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "West Virginia") {
            int s = 47;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Wisconsin") {
            int s = 48;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Wyoming") {
            int s = 49;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Hawaii") {
            int s = 2;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Alaska") {
            int s = 54;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Northwest Territory") {
            int s = 60;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Alberta") {
            int s = 61;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "British Columbia") {
            int s = 62;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Manitoba") {
            int s = 63;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "New Brunswick") {
            int s = 64;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Nova Scotia") {
            int s = 65;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Prince Edward Island") {
            int s = 66;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Ontario") {
            int s = 67;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Quebec") {
            int s = 68;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Saskatchewan") {
            int s = 69;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Nunavut") {
            int s = 70;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Yukon") {
            int s = 71;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Newfoundland and Labrador") {
            int s = 72;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "England") {
            int s = 101;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Wales") {
            int s = 102;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Scotland") {
            int s = 103;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            }
            else if (i == "Northern Ireland") {
            int s = 104;
            String query = "INSERT INTO customers(Customer_ID, Customer_Name, Address, Phone, Postal_Code, Division_ID)" + 
                    "VALUES(" +
                    "'" + id + "'," +
                    "'" + customerName + "'," +
                    "'" + address + "'," +
                    "'" + phone + "'," + 
                    "'" + postalCode + "'," +
                    "'" + s + "'" +
                    ")";
            statement.execute(query);
            };
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            
        }
        return false;
    }
    
    /**
     * Deletes all customers from DB
     *
     * 
     */
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
