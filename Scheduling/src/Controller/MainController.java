/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
//import Model.Appointment;
import utils.DBAppointments;
import Model.Customer;
import Model.UserDB;
import java.sql.SQLException;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import utils.DBCustomer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



/**
 *
 * @author 18018
 */
public class MainController implements Initializable {
    
    @FXML
    public ComboBox country;
    public ComboBox state;
    public ComboBox nameUpdate;
    public ComboBox nameDelete;
    public Button New;
    public Button Update;
    public Button Delete;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;
    public TextField Customer_Name;
    public TextField Address;
    public TextField Postal_Code;
    public TextField Phone;

                                    
    
    private ObservableList<String> countries = FXCollections.observableArrayList(
    "USA", "UK", "Canada");
    
     private ObservableList<String> allStates = FXCollections.observableArrayList(
    "Alabama","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","District of Columbia","Florida","Georgia","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming","Hawaii","Alaska","Northwest Territories","Alberta","British Columbia","Manitoba","New Brunswick","Nova Scotia","Prince Edward Island","Ontario","Québec","Saskatchewan","Nunavut","Yukon","Newfoundland and Labrador","England","Wales","Scotland","Northern Ireland");
    
    
    private ObservableList<String> states = FXCollections.observableArrayList(
    "Alabama","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","District of Columbia","Florida","Georgia","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming","Hawaii","Alaska");
    
    private ObservableList<String> canadastates = FXCollections.observableArrayList(
    "Northwest Territories","Alberta","British Columbia","Manitoba","New Brunswick","Nova Scotia","Prince Edward Island","Ontario","Québec","Saskatchewan","Nunavut","Yukon","Newfoundland and Labrador");
    
    private ObservableList<String> ukstates = FXCollections.observableArrayList(
    "England","Wales","Scotland","Northern Ireland");
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBCustomer.getAllCustomers();
        

        }
    
        
    private Customer editCustomer;
    
    private void committedCustomer(){
        for (int i = 1; i < Customer.customers.size(); i++){        
        for(Customer cs : Customer.customers){
            if(cs.getCustId() == i){
                Customer editCustomer = cs;
            }  
        int id = cs.getCustId();
        String customerName = cs.getCustName();
        String address = cs.getCustAddress();
        String stateChoice = cs.getCustState();
        String countryChoice = cs.getCustCountry();
        String postalCode = cs.getCustZip();
        String phone = cs.getCustPhone();
        DBCustomer.saveCustomer(id, customerName, address, phone, postalCode, stateChoice, countryChoice);
        }
        };
       
    }
      
 @FXML
    public void handleNew(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Customer.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Customer");
            stage.show();   
    }
        
         @FXML
    public void onCommit(ActionEvent event) throws IOException {
        //DBCustomer.deleteCustomer();
        committedCustomer();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Changes saved");
                alert.setHeaderText("All changes saved.");
                alert.showAndWait();
    }
        

        

}
