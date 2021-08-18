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
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import utils.DBCustomer;
import static java.util.Objects.isNull;



/**
 *
 * @author 18018
 */
public class CustomerController implements Initializable {
    
    @FXML
    public ComboBox<String> country;
    public ComboBox<String> state;
    public ComboBox<Customer> nameUpdate;
    public ComboBox<Customer> nameDelete;
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
    public ComboBox<String> updateCountry;
    public ComboBox<String> updateState;
    public Button FinalUpdate;
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
    

   
        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        country.setItems(countries);
        updateCountry.setItems(countries);
        try {
        nameUpdate.setItems(Customer.customers);
        nameDelete.setItems(Customer.customers);}
        catch (NullPointerException e) {}
        country.setPromptText("Country");
        state.setPromptText("State/Territory");
        nameUpdate.setPromptText("Who to update");
        nameDelete.setPromptText("Who to delete");

    }
    
    
    public void onPull(ActionEvent actionEvent){
        StringBuilder sb = new StringBuilder(" ");
        
        String countryChoice = country.getSelectionModel().getSelectedItem();
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
    
        public void onUpdatePull(ActionEvent actionEvent){
        StringBuilder sb = new StringBuilder(" ");
        
        String newCountry = updateCountry.getSelectionModel().getSelectedItem();
        if(newCountry == null){
            updateState.setItems(allStates);}
            else if(newCountry == "USA"){
                    updateState.setItems(states);
                    }
            else if(newCountry == "UK"){
                    updateState.setItems(ukstates);
                    }
                    else{
                    updateState.setItems(canadastates);
                    }
        }
    

            public boolean validateEverything(String customerName, String address, String postalCode, String phone, String countryChoice, String stateChoice) {
        if(customerName.isEmpty() || address.isEmpty() || postalCode.isEmpty() || phone.isEmpty() || countryChoice == null || stateChoice == null ) {
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
            String countryChoice = country.getSelectionModel().getSelectedItem();
            String stateChoice = state.getSelectionModel().getSelectedItem();
            
            Customer newCustomer = new Customer();
            newCustomer.setCustName(customerName);
            newCustomer.setCustAddress(address);
            newCustomer.setCustPhone(phone);
            newCustomer.setCustZip(postalCode);
            newCustomer.setCustCountry(countryChoice);
            newCustomer.setCustState(stateChoice);
                                                    
            newCustomer.setCustId(Customer.getCustomerCount());
            
            
            if(validateEverything(customerName, address, postalCode, phone, countryChoice, stateChoice)){
                Customer.addCustomer(newCustomer);
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Customer Added");
                alert.setHeaderText("Customer saved successfully");
                alert.showAndWait();
                
                System.out.println(Customer.customers);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Issue adding a customer");
                alert.setHeaderText("Please fill in all prompts");
                alert.setContentText("Including the drop downs");
                alert.showAndWait();
            }
            
            
        }
        
 private Customer editCustomer;
        
  @FXML
        public void handleUpdate(ActionEvent event) throws IOException {
            
            editCustomer = nameUpdate.getSelectionModel().getSelectedItem();

                UpdateCID.setText(String.valueOf(editCustomer.getCustId()));
                UpdateCN.setText(editCustomer.getCustName());
                UpdateAdd.setText(editCustomer.getCustAddress());
                updateState.getSelectionModel().select(editCustomer.getCustState());
                updateCountry.getSelectionModel().select(editCustomer.getCustCountry());
                UpdatePC.setText(editCustomer.getCustZip());
                UpdatePh.setText(editCustomer.getCustPhone());
                
                System.out.println(editCustomer);
  

            
        }
        
        @FXML
        public void saveUpdate(ActionEvent event) throws IOException {
            StringBuilder sb = new StringBuilder(" ");
            String customerName = UpdateCN.getText();
            String address = UpdateAdd.getText();
            String postalCode = UpdatePC.getText();
            String phone = UpdatePh.getText();
            String countryChoice = updateCountry.getSelectionModel().getSelectedItem();
            String stateChoice = updateState.getSelectionModel().getSelectedItem();
            
            
            
            editCustomer.setCustName(customerName);
            editCustomer.setCustAddress(address);
            editCustomer.setCustPhone(phone);
            editCustomer.setCustZip(postalCode);
            editCustomer.setCustCountry(countryChoice);
            editCustomer.setCustState(stateChoice);
            
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Customer Updated");
                alert.setHeaderText("Customer saved successfully");
                alert.showAndWait();
            
        }
        
  @FXML
        public void handleDelete(ActionEvent event) throws IOException {
            editCustomer = nameDelete.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Customer Delete");
            alert.setHeaderText("Confirm deletion");
            alert.setContentText("Are you sure you want to delete " + editCustomer);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                Customer.removeCustomer(editCustomer);
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }
        }
}
