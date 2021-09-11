/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointments;
import Model.Customer;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 18018
 */
public class AppointmentsController implements Initializable {

        @FXML
    public ComboBox<String> type;
    public ComboBox<String> typeUpdate;
    public ComboBox<String> startTime;
    public ComboBox<String> startTimeUpdate;
    public ComboBox<String> endTime;
    public ComboBox<String> endTimeUpdate;
    public ComboBox<String> Contact;
    public ComboBox<String> ContactUpdate;
    public ComboBox<Customer> nameNew;
    public ComboBox<Customer> nameUpdate;
    public ComboBox<Customer> nameDelete;
    public ComboBox<Appointments> AppointmentUpdate;
    public DatePicker endDate;
    public DatePicker endDateUpdate;
    public DatePicker startDate;
    public DatePicker startDateUpdate;
    public Button New;
    public Button Update;
    public Button Delete;
    public Button Back;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;
    public TextField Title;
    public TextField Description;
    public TextField Location;
    public Button FinalUpdate;
    public TextField UpdateAID;
    public TextField UpdateTitle;
    public TextField UpdateDescription;
    public TextField UpdateLocation;

    private final ObservableList<String> types = FXCollections.observableArrayList("Introductions","Retirement Planning","Portfolio Analysis","Tax Planning");
    private final ObservableList<String> times = FXCollections.observableArrayList("9:00 AM","10:00 AM","11:00 AM","12:00 PM","1:00 PM","2:00 PM","3:00 PM","4:00 PM");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startTime.setItems(times);
        startTimeUpdate.setItems(times);
        endTime.setItems(times);
        endTimeUpdate.setItems(times);
        try {
        nameUpdate.setItems(Appointments.appointment);
        nameDelete.setItems(Appointments.appointment);}
        catch (NullPointerException e) {}
        nameUpdate.setPromptText("Who to update");
        nameDelete.setPromptText("Who to delete");

    }
    
    
    public void onPull(ActionEvent actionEvent){
        
        }
    
        public void onUpdatePull(ActionEvent actionEvent){
        
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
        
        @FXML
        public void handleBack(ActionEvent event)throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
        }
    
}
