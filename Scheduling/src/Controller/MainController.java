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
    private TextField Customer_Name;
    private TextField Address;
    private TextField Postal_Code;
    private TextField Phone;
    
    private ObservableList<String> countries = FXCollections.observableArrayList(
    "USA", "UK", "Canada");
    
    private ObservableList<String> states = FXCollections.observableArrayList(
    "Alabama","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","District of Columbia","Florida","Georgia","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming","Hawaii","Alaska","Northwest Territories","Alberta","British Columbia","Manitoba","New Brunswick","Nova Scotia","Prince Edward Island","Ontario","Québec","Saskatchewan","Nunavut","Yukon","Newfoundland and Labrador","England","Wales","Scotland","Northern Ireland");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        country.setItems(countries);
        state.setItems(states);
        nameUpdate.setItems(states);
        nameDelete.setItems(states);
        country.setPromptText("Country");
        state.setPromptText("State/Territory");
        nameUpdate.setPromptText("Select who to update");
        nameDelete.setPromptText("Select who to delete");
    }

 @FXML
        private void handleNew(ActionEvent event) throws IOException {
            String customerName = Customer_Name.getText();
            String address = Address.getText();
            String postalCode = Postal_Code.getText();
            String phone = Phone.getText();
            
            
        }
        
  @FXML
        private void handleUpdate(ActionEvent event) throws IOException {
            String customerName = Customer_Name.getText();
            String address = Address.getText();
            String postalCode = Postal_Code.getText();
            String phone = Phone.getText();
            
            
        }
  @FXML
        private void handleDelete(ActionEvent event) throws IOException {
            String customerName = Customer_Name.getText();
            String address = Address.getText();
            String postalCode = Postal_Code.getText();
            String phone = Phone.getText();
            
            
        }
}
