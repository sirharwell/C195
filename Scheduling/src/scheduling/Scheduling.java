/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduling;

import DBAccess.DBCountries;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DBConnection;
import utils.DBQuery;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author 18018
 */
public class Scheduling extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException  {
        
        
        DBConnection.startConnection();
        Connection conn = DBConnection.getConnection();
        DBQuery.setStatement(conn);
        Statement statement = DBQuery.getStatement();
        
        //Raw SQL insert
        String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy) VALUES('US', '2020-02-22 00:00:00', 'admin', 'admin')";
        
        //Execute SQL Statement
        
        statement.execute(insertStatement);
        if(statement.getUpdateCount() > 0)
            System.out.println(statement.getUpdateCount() + " rows affected");
        else
            System.out.println("No Change!?");
        
        DBCountries.checkDateConversion();
        launch(args); 
        DBConnection.closeConnetion();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/SchedulingJFX.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Scheduler");
        stage.show();
    }
    
}
