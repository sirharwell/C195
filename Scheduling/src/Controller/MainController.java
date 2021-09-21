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
import Model.Appointments;
import Model.Contacts;
import utils.DBAppointments;
import Model.Customer;
import Model.UserDB;
import java.sql.SQLException;
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
import java.util.Objects;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import utils.DBCustomer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utils.DBContacts;



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
    public TableColumn waid;
    public TableColumn wt;
    public TableColumn wd;
    public TableColumn wl;
    public TableColumn wc;
    public TableColumn wty;
    public TableColumn wsdat;
    public TableColumn wedt;
    public TableColumn wcid;
    public TableColumn wuid;
    public TableColumn maid;
    public TableColumn mt;
    public TableColumn md;
    public TableColumn ml;
    public TableColumn mc;
    public TableColumn mty;
    public TableColumn msdat;
    public TableColumn medat;
    public TableColumn mcid;
    public TableColumn muid;
   
    
    
  
    public ObservableList<Appointments> getMonthlyAppointments = FXCollections.observableArrayList();
    public ObservableList<Appointments> getWeeklyAppointments = FXCollections.observableArrayList();
    
    public void monthly(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.now().plusMonths(1);
        for(int i = 1; i <= Appointments.appointment.size(); i++){
            for(Appointments cs : Appointments.appointment){
                LocalDate start = LocalDate.parse(cs.aptDStart, formatter);
                if( start.isBefore(end)){
                    getMonthlyAppointments.add(cs);
                }
            } 
            
        }}
    
        public void weekly(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate end = LocalDate.now().plusWeeks(1);
            for(int i = 1; i <= Appointments.appointment.size(); i++){
                for(Appointments cs : Appointments.appointment){
                    LocalDate start = LocalDate.parse(cs.aptDStart, formatter);
                    if( start.isBefore(end)){
                        getWeeklyAppointments.add(cs);
                }
            } 
            
        }}
        
        public void appointmentIn15(){
            LocalTime endTime = LocalTime.now().plusMinutes(15);
            LocalDate endDate = LocalDate.now();
            DateTimeFormatter fr = DateTimeFormatter.ofPattern("hh:mm:ss");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (int i = 1; i <= Appointments.appointment.size(); i++){        
                for(Appointments cs : Appointments.appointment){
                    LocalTime time = LocalTime.parse(cs.aptTStart, fr);
                    LocalDate date = LocalDate.parse(cs.aptDStart, formatter);
                    if((time.isBefore(endTime)) && (endDate.isEqual(date))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Appointment Soon!");
                alert.setHeaderText("You have appointment " + cs.aptId + " at "  + cs.aptTStart + " on " + cs.aptDStart );
                alert.showAndWait();
            } 
        }}}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBCustomer.getAllCustomers();
        DBContacts.getAllContacts();
        DBAppointments.getAllAppointments();
        appointmentIn15();
        TableView<Appointments> weeks = new TableView<>();
        weeks.getItems().addAll(getWeeklyAppointments);
        weeks.getColumns().addAll(waid, getWeeklyAppointments.getAptId());
        maid.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptDescriptionProperty();
        });
        monthContact.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptContactProperty();
        });
        monthLocation.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptLocationProperty();
        });
        monthStart.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptStartProperty();
        });
        monthEnd.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptEndProperty();
        });
        weekDescription.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptDescriptionProperty();
        });
        weekContact.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptContactProperty();
        });
        weekLocation.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptLocationProperty();
        });
        weekStart.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptStartProperty();
        });
        weekEnd.setCellValueFactory(cellData -> {
            return cellData.getValue().getAptEndProperty();
        });
        StartTime.setItems(times);
        EndTime.setItems(times);
        Contact.setItems(Contacts.contact);
        ContactUpdate.setItems(Contacts.contact);
        typeUpdate.setItems(types);
        Type.setItems(types);
        NameNew.setItems(Customer.customers);
        AppointmentUpdate.setItems(Appointments.appointment);
        AppointmentDelete.setItems(Appointments.appointment);
        AppointmentUpdate.setPromptText("What to update");
        AppointmentDelete.setPromptText("What to delete");
        try {
        startTimeUpdate.setItems(times);
        endTimeUpdate.setItems(times);
        nameUpdate.setItems(Customer.customers);
        NameDelete.setItems(Customer.customers);

        }
    
        
    private Customer editCustomer;
    
    private void committedCustomer(){
        System.out.println("Hi");
        for (int i = 1; i <= Customer.customers.size(); i++){        
        for(Customer cs : Customer.customers){
            if(cs.getCustId() == i){
                Customer editCustomer = cs;
            }  
        int id = cs.getCustId();
        String customerName = cs.getCustName();
        String address = cs.getCustAddress();
        String stateChoice = cs.getCustState();
        String postalCode = cs.getCustZip();
        String phone = cs.getCustPhone();
        DBCustomer.saveCustomer(id, customerName, address, stateChoice, phone, postalCode);
        }
        };
       
    }
    
    private void committedAppointment() throws ParseException{{
        for (int i = 1; i <= Appointments.appointment.size(); i++){        
        for(Appointments cs : Appointments.appointment){
            if(cs.getAptId() == i){
                Appointments editAppointment = cs;
            } 
        int aptId = cs.getAptId();
        Customer aptCustId = cs.getAptCustId();
        String aptStartLocal = (cs.getAptDStart() + " " + cs.getAptTStart());
        String aptEndLocal = (cs.getAptDEnd() + " " + cs.getAptTEnd());
        String aptTitle = cs.getAptTitle();
        String aptDescription = cs.getAptDescription();
        String aptLocation = cs.getAptLocation();
        Contacts aptContact = cs.getAptContact();
        String aptType = cs.getAptType();    
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ZoneId zid = ZoneId.systemDefault();
            LocalTime lts = LocalTime.parse(cs.getAptTStart(), tf);
            LocalDate lds = LocalDate.parse(cs.getAptDEnd(), df);
            ZonedDateTime tdStart = ZonedDateTime.of(lds, lts, zid);           
            LocalTime lte = LocalTime.parse(cs.getAptTEnd(), tf);
            LocalDate lde = LocalDate.parse(cs.getAptDEnd(), df);   
            ZonedDateTime tdEnd = ZonedDateTime.of(lde, lte, zid);
            LocalDate easternD = LocalDate.of(2021, 9, 15);
            LocalTime easternT = LocalTime.of(11, 00);
            ZoneId USTID = ZoneId.of("Etc/GMT");
            ZonedDateTime easternZDT = ZonedDateTime.of(easternD, easternT, USTID);
            ZoneId localZone = ZoneId.of(TimeZone.getDefault().getID());
            LocalDateTime now = LocalDateTime.now();
            
            ZonedDateTime zdt = now.atZone(zid);
            
            Instant easternToGMT = easternZDT.toInstant();
            ZonedDateTime easternToLocal = easternZDT.withZoneSameInstant(localZone);
            ZonedDateTime gstToLocalZDT = easternToGMT.atZone(localZone);
            ZonedDateTime localToEastern = zdt.withZoneSameInstant(USTID);
            ZonedDateTime startToEastern = tdStart.withZoneSameInstant(USTID);
            ZonedDateTime endToEastern = tdEnd.withZoneSameInstant(USTID);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String aptEnd = endToEastern.format(myFormatObj);
            String aptStart = startToEastern.format(myFormatObj);
            
        DBAppointments.saveAppointments( aptId,  aptTitle,  aptDescription,  aptLocation,  aptType,  aptStart,  aptEnd, aptCustId, aptContact);
        }
        };
       
    }}
      
 @FXML
    public void handleNew(ActionEvent event) throws IOException {
            Parent loader = FXMLLoader.load(getClass().getResource("/view/Customer.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Customer");
            stage.show();   
    }
    
@FXML
    public void handleAppointments(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Appointments");
            stage.show();   
    }
        
         @FXML
    public void onCommit(ActionEvent event) throws IOException, ParseException {
        try {
            DBAppointments.deleteAppointments();
            DBCustomer.deleteCustomer();
        } catch (SQLException ex) {
            System.out.println("You done screwed up A-A-Ron" + ex.getMessage());
        }
        committedCustomer();
        committedAppointment();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Changes saved");
                alert.setHeaderText("All changes saved.");
                alert.showAndWait();
    }
        

        

}
