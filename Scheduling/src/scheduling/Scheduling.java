/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduling;

import DBAccess.DBCountries;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.DBConnection;
import utils.DBQuery;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


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
        launch(args); 
        DBConnection.closeConnetion();
    }
    
  
    @Override
    public void start(Stage stage) throws Exception {
        Locale locale = Locale.getDefault();
        String locales = locale.toString();
        if(locales.contains("en")){
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Scheduler");
        stage.show();
        System.out.println("peepee");
        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login_French.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Planificateur");
            stage.show();        
    }
    }
}
