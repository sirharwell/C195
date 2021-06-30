/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import utils.DBConnection;
import Model.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 *
 * @author 18018
 */
public class DBCountries {


    public static ObservableList<Countries> getAllCountries(){
    
    ObservableList<Countries> clist = FXCollections.observableArrayList();
    try{
        String sql = "SELECT * from countries";
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            int countryId = rs.getInt("Country_ID");
            String countryName = rs.getString("Country");
            Countries C = new Countries(countryId, countryName);
            clist.add(C);
        }
        
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    
    return clist;
    }
    
    public static void checkDateConversion(){
        System.out.println("CREATE DATE TEST");
        String sql = "select Create_Date from countries";
        try{
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Timestamp ts = rs.getTimestamp("Create_Date");
            System.out.println("CD: " + ts.toLocalDateTime().toString());
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
}
