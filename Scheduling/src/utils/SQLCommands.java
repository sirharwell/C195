/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author 18018
 */
public class SQLCommands {
   /* String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy) VALUES(?, ?, ?, ?)";
        DBQuery.setPreparedStatement(conn, insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();

        String countryName;
        String createDate = "2020-03-28 00:00:000";
        String createdBy = "admin";
        String lastUpdateBy = "admin";
        
        Scanner keyboard = new Scanner(System.in);
        countryName = keyboard.nextLine();
        
        //key value mapping. 
        ps.setString(1, countryName);
        ps.setString(2, createDate);
        ps.setString(3, createdBy);
        ps.setString(4, lastUpdateBy);
        
        ps.execute();
        
            
        
        DBConnection.startConnection();
        Connection conn = DBConnection.getConnection();
        DBQuery.setStatement(conn);
        Statement statement = DBQuery.getStatement();
        
        //Raw SQL insert
        //String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy) VALUES('US', '2020-02-22 00:00:00', 'admin', 'admin')";
        /*
        String countryName = "Canada";
        String createDate = "2021-7-9 15:17:00";
        String createdBy = "admin";
        String lastUpdateBy = "admin";
        
        String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy)" + 
                "VALUES(" +
                "'" + countryName + "'," +
                "'" + createDate + "'," +
                "'" + createdBy + "'," +
                "'" + lastUpdateBy + "'," +
                ")"; */
        
        //update statement
        //String updateStatement = "UPDATE country SET country = 'Japan' WHERE country = 'Canada'";
        
        //delete statement
        //String deleteStatement = "DELETE FROM country where country = 'Japan'"                    

        //retrieve
        //String selectStatement = "SELECT * FORM country";
        //statement.execute(selectStatement);
        //ResultSet rs = statement.getResultSet();
        
        //Forward Scroll ResultSet
        /*while(rs.next()){
            int countryId = rs.getInt("countryId");
            String countryName = rs.getString("country");
            LocalDate date = rs.getDate("createDate").toLocalDate();
            LocalTime time = rs.getTime("createDate").toLocalTime();
            String createdBy = rs.getString("createdby");
            LocalDateTime lastUpdate = rs.getTimestamp("lastUpdate").toLocalDateTime();
            
            //Display record
            System.out.println(countryId + " | " + countryName + " | " + date + " " + time + " | " + createdBy + " | " + lastUpdate);
        }
            )
        
        //Execute SQL Statement
        
       // statement.execute(insertStatement);
        //if(statement.getUpdateCount() > 0)
        //    System.out.println(statement.getUpdateCount() + " rows affected");
        //else
        //    System.out.println("No Change!?");
        
        //DBCountries.checkDateConversion();*/
}
