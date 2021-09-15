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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.TimeZone;
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
    public ComboBox<String> Type;
    public ComboBox<String> TypeUpdate;
    public ComboBox<String> StartTime;
    public ComboBox<String> StartTimeUpdate;
    public ComboBox<String> EndTime;
    public ComboBox<String> EndTimeUpdate;
    public ComboBox<String> Contact;
    public ComboBox<String> ContactUpdate;
    public ComboBox<Customer> NameNew;
    public ComboBox<Customer> NameUpdate;
    public ComboBox<Customer> NameDelete;
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

    private ObservableList<String> types = FXCollections.observableArrayList("Introductions","Retirement Planning","Portfolio Analysis","Tax Planning");
    private ObservableList<String> times = FXCollections.observableArrayList("00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00");
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StartTime.setItems(times);
        EndTime.setItems(times);
        Contact.setItems(types);
        Type.setItems(types);
        NameNew.setItems(Customer.customers);
        AppointmentUpdate.setItems(Appointments.appointment);
        AppointmentDelete.setItems(Appointments.appointment);
        AppointmentUpdate.setPromptText("What to update");
        AppointmentDelete.setPromptText("What to delete");
        try {
        StartTimeUpdate.setItems(times);
        EndTimeUpdate.setItems(times);
        NameUpdate.setItems(Customer.customers);
        NameDelete.setItems(Customer.customers);
                }
        catch (NullPointerException e) {System.out.println(e);}
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

        public boolean overLap(String dStart, String tStart){       
        for(Appointments apt : Appointments.appointment){
            if(apt.getAptDStart().contains(dStart) && apt.getAptTStart().contains(tStart)){
                return true;
            }
            else {
                return false;
            }}
                return false;}

        public boolean businessHours(String tStart, String tEnd) throws ParseException{
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
            ZoneId zid = ZoneId.systemDefault();
            LocalTime lts = LocalTime.parse(tStart, tf);
            LocalDate lds = LocalDate.of(2021, 9, 15);
            ZonedDateTime tdStart = ZonedDateTime.of(lds, lts, zid);           
            LocalTime lte = LocalTime.parse(tEnd, tf);
            LocalDate lde = LocalDate.of(2021, 9, 15);   
            ZonedDateTime tdEnd = ZonedDateTime.of(lde, lte, zid);
            LocalDate easternD = LocalDate.of(2021, 9, 15);
            LocalTime easternT = LocalTime.of(11, 00);
            ZoneId easternId = ZoneId.of("America/New_York");
            ZonedDateTime easternZDT = ZonedDateTime.of(easternD, easternT, easternId);
            ZoneId localZone = ZoneId.of(TimeZone.getDefault().getID());
            LocalDateTime now = LocalDateTime.now();
            
            ZonedDateTime zdt = now.atZone(zid);
            
            Instant easternToGMT = easternZDT.toInstant();
            ZonedDateTime easternToLocal = easternZDT.withZoneSameInstant(localZone);
            ZonedDateTime gstToLocalZDT = easternToGMT.atZone(localZone);
            ZonedDateTime localToEastern = zdt.withZoneSameInstant(easternId);
            ZonedDateTime startToEastern = tdStart.withZoneSameInstant(easternId);
            ZonedDateTime endToEastern = tdEnd.withZoneSameInstant(easternId);
            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
            Date ten = parser.parse("22:00");
            Date eight = parser.parse("08:00");
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
            String formattedEnd = endToEastern.format(myFormatObj);
            String formattedStart = startToEastern.format(myFormatObj);
            Date endTime = parser.parse(formattedEnd);
            Date startTime = parser.parse(formattedStart);
            System.out.println(formattedStart);
            System.out.println(formattedEnd);
            if(startTime.after(ten) || startTime.before(eight)  ) {
                return true;
            }
            if(endTime.after(ten) || endTime.before(eight)  ) {
                return true;
            }
            
            
            
        return false;}
    
 @FXML
        public void handleNew(ActionEvent event) throws IOException, ParseException {
            StringBuilder sb = new StringBuilder(" ");
            String title = Title.getText();
            String description = Description.getText();
            String location = Location.getText();
            String aType = Type.getSelectionModel().getSelectedItem();
            Customer newName = NameNew.getSelectionModel().getSelectedItem();
            int custID = newName.getCustId();
            String contact = Contact.getSelectionModel().getSelectedItem();
            String dStart = startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String dEnd = endDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));            
            String tStart = StartTime.getSelectionModel().getSelectedItem();
            String tEnd = EndTime.getSelectionModel().getSelectedItem();
            
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
            if(businessHours(tStart, tEnd)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Issue adding an Appointment");
                alert.setHeaderText("Appointment outside busisness hours.");
                alert.setContentText("Please pick a different time.");
                alert.showAndWait(); 
            }
            else{
            if(overLap(dStart, tStart)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Issue adding an Appointment");
                alert.setHeaderText("You already have an appointment scheduled for this time.");
                alert.setContentText("Please pick a different time/date.");
                alert.showAndWait();    
            }
            else {                    
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
            }}
            
            
        }}
        
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
