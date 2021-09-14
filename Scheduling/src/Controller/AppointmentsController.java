/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointments;
import static Model.Appointments.getAppointmentCount;
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
    public ComboBox<Appointments> AppointmentDelete;
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
        nameUpdate.setItems(Customer.customers);
        nameDelete.setItems(Customer.customers);
        nameNew.setItems(Customer.customers);
        Contact.setItems(types);
        AppointmentUpdate.setItems(Appointments.appointment);
        AppointmentDelete.setItems(Appointments.appointment);
        }
        catch (NullPointerException e) {}
        AppointmentUpdate.setPromptText("What to update");
        AppointmentDelete.setPromptText("What to delete");

    }
    
    
    public void onPull(ActionEvent actionEvent){
        
        }
    
        public void onUpdatePull(ActionEvent actionEvent){
        
        }
    
            public boolean validateEverything(int aptCustId, String aptDStart, String aptDEnd, String aptTStart, String aptTEnd, String aptTitle, String aptDescription, String aptLocation, String aptContact ) {
        if(aptCustId == 0 || aptDStart.isEmpty() || aptDEnd.isEmpty() || aptTStart.isEmpty() || aptTEnd.isEmpty() || aptTitle.isEmpty() || aptDescription.isEmpty() || aptLocation.isEmpty() || aptContact.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    
 @FXML
        public void handleNew(ActionEvent event) throws IOException {
            StringBuilder sb = new StringBuilder(" ");
            String title = Title.getText();
            String description = Description.getText();
            String location = Location.getText();
            String aType = type.getSelectionModel().getSelectedItem();
            Customer newName = nameNew.getSelectionModel().getSelectedItem();
            int custID = newName.getCustId();
            String contact = Contact.getSelectionModel().getSelectedItem();
            String dStart = String.valueOf(startDate);
            String dEnd = String.valueOf(endDate);
            String tStart = startTime.getSelectionModel().getSelectedItem();
            String tEnd = endTime.getSelectionModel().getSelectedItem();
            
            Appointments newAppointment = new Appointments();
            newAppointment.setAptTitle(title);
            newAppointment.setAptDescription(description);
            newAppointment.setAptLocation(location);
            newAppointment.setAptDStart(dStart);
            newAppointment.setAptDEnd(dEnd);
            newAppointment.setAptTStart(tStart);
            newAppointment.setAptTEnd(tEnd);
            newAppointment.setAptContact(contact);
            newAppointment.setAptId(getAppointmentCount());
            newAppointment.setAptCustId(custID);

            if(validateEverything(custID, dStart, dEnd, tStart, tEnd, title, description, location, contact)){
                Appointments.addAppointments(newAppointment);
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Appointment Added");
                alert.setHeaderText("Appointment saved successfully");
                alert.showAndWait();
                
                System.out.println(Appointments.appointment);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Issue adding an Appointment");
                alert.setHeaderText("Please fill in all prompts");
                alert.setContentText("Including the drop downs");
                alert.showAndWait();
            }
            
            
        }
        
 private Appointments editAppointment;
        
 /* @FXML
        public void handleAppointmentUpdate(ActionEvent event) throws IOException {
            
            editAppointment = AppointmentUpdate.getSelectionModel().getSelectedItem();

                UpdateCID.setText(String.valueOf(editCustomer.getCustId()));
                UpdateCN.setText(editCustomer.getCustName());
                UpdateAdd.setText(editCustomer.getCustAddress());
                updateState.getSelectionModel().select(editCustomer.getCustState());
                updateCountry.getSelectionModel().select(editCustomer.getCustCountry());
                UpdatePC.setText(editCustomer.getCustZip());
                UpdatePh.setText(editCustomer.getCustPhone());

 

            
        } */
        
        @FXML
        public void saveUpdate(ActionEvent event) throws IOException {
            /*
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
            */
        }
        
  @FXML
        public void handleDelete(ActionEvent event) throws IOException {
            /*
            editCustomer = nameDelete.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Customer Delete");
            alert.setHeaderText("Confirm deletion");
            alert.setContentText("Are you sure you want to delete " + editCustomer);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                Customer.removeCustomer(editCustomer);
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }*/
        }
        
        @FXML
        public void handleBack(ActionEvent event)throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
        }
    
}
