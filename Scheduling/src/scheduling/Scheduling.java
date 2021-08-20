/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduling;

import utils.DBCountries;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


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
    
  
    public void logout(Stage stage){	
		
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK){
                System.out.println("You successfully logged out");
                stage.close();
        } 
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
        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login_French.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Planificateur");
            stage.show();        
    }
        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);	
        });
    }
}
