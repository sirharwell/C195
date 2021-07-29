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
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import utils.DBCustomer;



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
        country.setItems(countries);
        country.getSelectionModel().getSelectedItem();
        nameUpdate.setItems(states);
        nameDelete.setItems(states);
        country.setPromptText("Country");
        state.setPromptText("State/Territory");
        nameUpdate.setPromptText("Select who to update");
        nameDelete.setPromptText("Select who to delete");
    }
    
    
    public void onPull(ActionEvent actionEvent){
        StringBuilder sb = new StringBuilder(" ");
        
        Object countryChoice = country.getSelectionModel().getSelectedItem();
        if(countryChoice == null){
            state.setItems(allStates);}
            else if(countryChoice == "USA"){
                    state.setItems(states);
                    }
            else if(countryChoice == "UK"){
                    state.setItems(ukstates);
                    }
                    else{
                    state.setItems(canadastates);
                    }
        }

            public boolean validateEverything(String customerName, String address, String postalCode, String phone, Object countryChoice, Object stateChoice) {
        if(customerName.isEmpty() || address.isEmpty() || postalCode.isEmpty() || phone.isEmpty() || Objects.isNull(countryChoice) || Objects.isNull(stateChoice) ) {
            return false;
        } else {
            return true;
        }
    }
    
 @FXML
        public void handleNew(ActionEvent event) throws IOException {
            StringBuilder sb = new StringBuilder(" ");
            String customerName = Customer_Name.getText();
            String address = Address.getText();
            String postalCode = Postal_Code.getText();
            String phone = Phone.getText();
            Object countryChoice = country.getSelectionModel().getSelectedItem();
            Object stateChoice = state.getSelectionModel().getSelectedItem();
                       
            
            if(validateEverything(customerName, address, postalCode, phone, countryChoice, stateChoice)){
                System.out.println("works");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Issue adding a customer");
                alert.setHeaderText("Please fill in all prompts");
                alert.setContentText("Including the drop downs");
                alert.showAndWait();
            }
            
            
        }
        

        
  @FXML
        public void handleUpdate(ActionEvent event) throws IOException {
            String customerName = Customer_Name.getText();
            String address = Address.getText();
            String postalCode = Postal_Code.getText();
            String phone = Phone.getText();

            
        }
  @FXML
        public void handleDelete(ActionEvent event) throws IOException {
            String customerName = Customer_Name.getText();
            String address = Address.getText();
            String postalCode = Postal_Code.getText();
            String phone = Phone.getText();
            
            
        }
}
