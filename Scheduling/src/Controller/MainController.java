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
import javafx.scene.control.cell.PropertyValueFactory;
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
    public Label noAppointments;
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
    public TableView<Appointments> tvMonth;
    public TableView<Appointments> tvWeek;
    public TableColumn<Appointments, String> waid;
    public TableColumn<Appointments, String> wt;
    public TableColumn<Appointments, String> wd;
    public TableColumn<Appointments, String> wl;
    public TableColumn<Appointments, String> wc;
    public TableColumn<Appointments, String> wty;
    public TableColumn<Appointments, String> wsdat;
    public TableColumn<Appointments, String> wedt;
    public TableColumn<Appointments, String> wcid;
    public TableColumn<Appointments, String> wuid;
    public TableColumn<Appointments, String> maid;
    public TableColumn<Appointments, String> mt;
    public TableColumn<Appointments, String> md;
    public TableColumn<Appointments, String> ml;
    public TableColumn<Appointments, String> mc;
    public TableColumn<Appointments, String> mty;
    public TableColumn<Appointments, String> msdat;
    public TableColumn<Appointments, String> medat;
    public TableColumn<Appointments, String> mcid;
    public TableColumn<Appointments, String> muid;
   
    
    
  
    public ObservableList<Appointments> getMonthlyAppointments(){
        ObservableList<Appointments> monthlyAppointments= FXCollections.observableArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.now().plusMonths(1);
        for(int i = 1; i <= Appointments.appointment.size(); i++){
        for(Appointments cs : Appointments.appointment){
            LocalDate start = LocalDate.parse(cs.aptDStart, formatter);
            if( start.isBefore(end)){
                monthlyAppointments.add(cs);
            }
        } 

        }
        return monthlyAppointments;
    }
    
    public ObservableList<Appointments> getWeeklyAppointments() {
        ObservableList<Appointments> weeklyAppointments= FXCollections.observableArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.now().plusWeeks(1);
        for(int i = 1; i <= Appointments.appointment.size(); i++){
            for(Appointments cs : Appointments.appointment){
                LocalDate start = LocalDate.parse(cs.aptDStart, formatter);
                if( start.isBefore(end)){
                    weeklyAppointments.add(cs);
            }
        } 
            
        }
        return weeklyAppointments;
    }
        
        public void appointmentIn15(){
            LocalTime endTime = LocalTime.now().plusMinutes(15);
            LocalDate endDate = LocalDate.now();
            DateTimeFormatter fr = DateTimeFormatter.ofPattern("HH:mm");
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
                    else{ noAppointments.setText("No appointments upcoming");}
        }}}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBCustomer.getAllCustomers();
        DBContacts.getAllContacts();
        DBAppointments.getAllAppointments();
        appointmentIn15();
        maid.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptIdP"));
        mt.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptTypeP"));
        md.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptDescriptionP"));
        ml.setCellValueFactory(new PropertyValueFactory<Appointments, String>("AptLocationP"));
        mc.setCellValueFactory(new PropertyValueFactory<Appointments, String>("AptContactP"));
        mty.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptTypeP"));
        msdat.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptDStartP" + " " + "aptTStartP"));
        medat.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptDEndP" + " " + "aptTEndP"));
        mcid.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptCustIdP"));
        muid.setCellValueFactory(new PropertyValueFactory<Appointments, String>("aptUserIdP"));
        
        try{
            System.out.println(getMonthlyAppointments());
            System.out.println(getMonthlyAppointments());
        tvMonth.setItems(getMonthlyAppointments());
        tvWeek.setItems(getWeeklyAppointments());
        }   catch(NullPointerException e){System.out.println(e);}
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
