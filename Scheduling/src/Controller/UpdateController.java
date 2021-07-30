/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author 18018
 */
public class UpdateController {
        
    @FXML
    public ComboBox updateCountry;
    public ComboBox updateState;
    public ComboBox nameUpdate;
    public ComboBox nameDelete;
    public Button FinalUpdate;
    public Button CancelUpdate;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;
    public TextField UpdateCID;
    public TextField UpdateCN;
    public TextField UpdateAdd;
    public TextField UpdatePC;
    public TextField UpdatePh;
                                    
    
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
   
        
    
    

    public void initialize(URL url, ResourceBundle rb) {
        updateCountry.setItems(countries);
        updateCountry.setPromptText("Country");
        updateState.setPromptText("State/Territory");
        UpdateCID.setText(String.valueOf(Customer.customers));

    }
        
    public void onUpdatePull(ActionEvent actionEvent){
        StringBuilder sb = new StringBuilder(" ");
        
        Object updateCountryChoice = updateCountry.getSelectionModel().getSelectedItem();
        if(updateCountryChoice == null){
            updateState.setItems(allStates);}
            else if(updateCountryChoice == "USA"){
                    updateState.setItems(states);
                    }
            else if(updateCountryChoice == "UK"){
                    updateState.setItems(ukstates);
                    }
                    else{
                    updateState.setItems(canadastates);
                    }
        }
            
            public boolean validateUpdate(String UpdateCN, String UpdateAdd, String UpdatePC, String UpdatePh, Object updateCountryChoice, Object updateStateChoice) {
                if(UpdateCN.isEmpty() || UpdateAdd.isEmpty() || UpdatePC.isEmpty() || UpdatePh.isEmpty() || Objects.isNull(updateCountryChoice) || Objects.isNull(updateStateChoice) ) {
                return false;
            } else {
                return true;
            }
    }
    
 
  @FXML
        public void handleUpdate(ActionEvent event) throws IOException {
            
            Object editCustomer = nameUpdate.getSelectionModel().getSelectedItem();
            if(editCustomer == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Issue editing a customer");
                alert.setHeaderText("Please make a selection");
                alert.setContentText("I can't help you if you don't know what you want.");
                alert.showAndWait();
        }
            else{

                
                System.out.println(editCustomer);
                    }

            
        }

}
