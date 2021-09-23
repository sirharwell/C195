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
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
    public Label weeklyNumber;
    public Label noAppointments;
    public Label monthlyNumber;
    public Label totalNumber;
    public Label Introductions;
    public Label DeBriefing;
    public Label PlanningSession;
    public Label PortfolioAnalysis;
    public Button New;
    public Button Update;
    public Button Delete;
    public Button Refresh;
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;
    public TextField Customer_Name;
    public TextField Address;
    public TextField Postal_Code;
    public TextField Phone;
    public TableView<Appointments> tvMonth;
    public TableView<Appointments> tvWeek;
    public TableView<Appointments> anCost;
    public TableView<Appointments> danGarc;
    public TableView<Appointments> liLee;
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
    public TableColumn<Appointments, String> aaid;
    public TableColumn<Appointments, String> at;
    public TableColumn<Appointments, String> ad;
    public TableColumn<Appointments, String> aty;
    public TableColumn<Appointments, String> asdat;
    public TableColumn<Appointments, String> aedat;
    public TableColumn<Appointments, String> acid;
    public TableColumn<Appointments, String> daid;
    public TableColumn<Appointments, String> dt;
    public TableColumn<Appointments, String> dd;
    public TableColumn<Appointments, String> dty;
    public TableColumn<Appointments, String> dsdat;
    public TableColumn<Appointments, String> dedat;
    public TableColumn<Appointments, String> dcid;
    public TableColumn<Appointments, String> laid;
    public TableColumn<Appointments, String> lt;
    public TableColumn<Appointments, String> ld;
    public TableColumn<Appointments, String> lty;
    public TableColumn<Appointments, String> lsdat;
    public TableColumn<Appointments, String> ledat;
    public TableColumn<Appointments, String> lcid;
    
    
  
   
        public ObservableList<Appointments> monthlyAppointments= FXCollections.observableArrayList();
        
        @FXML
        void getMonthly() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.now().plusMonths(1);
        
        for(Appointments cs : Appointments.appointment){
            LocalDate start = LocalDate.parse(cs.aptDStart, formatter);
            if( start.isBefore(end)){
                monthlyAppointments.add(cs);
            }
        } 
    }
    
    
        public ObservableList<Appointments> weeklyAppointments= FXCollections.observableArrayList();
        
        @FXML
        void getWeekly() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate end = LocalDate.now().plusWeeks(1);
        
            for(Appointments cs : Appointments.appointment){
                LocalDate start = LocalDate.parse(cs.aptDStart, formatter);
                if( start.isBefore(end)){
                    weeklyAppointments.add(cs);
            }
        } 
    }
        public ObservableList<Appointments> anCosta= FXCollections.observableArrayList();
        
        @FXML
        void getAnika() {
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptContact().getContact_Name().contains("ika")){
                    anCosta.add(cs);
            }
        } 
    }
        
        public ObservableList<Appointments> danGarcia= FXCollections.observableArrayList();
        
        @FXML
        void getDaniel() {
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptContact().getContact_Name().contains("nie")){
                    danGarcia.add(cs);
            }
        } 
    }
        public ObservableList<Appointments> li= FXCollections.observableArrayList();
        
        @FXML
        void getLi() {
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptContact().getContact_Name().contains("Li")){
                    li.add(cs);
            }
        } 
    }
        
        public ObservableList<Appointments> introductions= FXCollections.observableArrayList();
        
        @FXML
        void getIntro() {
            introductions.clear();
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptType().contains("rodu")){
                    introductions.add(cs);
            }
        } 
    }
        
        public ObservableList<Appointments> portfolioAnalysis= FXCollections.observableArrayList();
        
        @FXML
        void getPA() {
            portfolioAnalysis.clear();
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptType().contains("naly")){
                    portfolioAnalysis.add(cs);
            }
        } 
    }
        
        public ObservableList<Appointments> planningSession= FXCollections.observableArrayList();
        
        @FXML
        void getPlan() {
            planningSession.clear();
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptType().contains("ess")){
                    planningSession.add(cs);
            }
        } 
    }

        public ObservableList<Appointments> deBriefing= FXCollections.observableArrayList();
        
        @FXML
        void getDebrief() {
            deBriefing.clear();
            for(Appointments cs : Appointments.appointment){
                if( cs.getAptType().contains("ief")){
                    deBriefing.add(cs);
            }
        } 
    }    
        public void appointmentIn15(){
            LocalTime endTime = LocalTime.now().plusMinutes(15);
            LocalDate endDate = LocalDate.now();
            DateTimeFormatter fr = DateTimeFormatter.ofPattern("HH:mm");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    
                for(Appointments cs : Appointments.appointment){
                    LocalTime time = LocalTime.parse(cs.aptTStart, fr);
                    LocalDate date = LocalDate.parse(cs.aptDStart, formatter);
                    if((time.isBefore(endTime)) && (endDate.isEqual(date))){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Appointment Soon!");
                alert.setHeaderText("You have appointment " + cs.aptId + " at "  + cs.aptTStart + " on " + cs.aptDStart );
                alert.showAndWait();
                noAppointments.setText("Appointments upcoming");
            }
                    else{ noAppointments.setText("No appointments upcoming");}
        }
        }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBCustomer.getAllCustomers();
        DBContacts.getAllContacts();
        DBAppointments.getAllAppointments();
        appointmentIn15();
        maid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        mt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        md.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        ml.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptLocationP()));
        mc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptContactP()));
        mty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        msdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        medat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        mcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        muid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUserIdP()));
        waid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        wt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        wd.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        wl.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptLocationP()));
        wc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptContactP()));
        wty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        wsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        wedt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        wcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        wuid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUserIdP()));
        aaid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        at.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        ad.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        aty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        asdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        aedat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        dcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        daid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        dt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        dd.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        dty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        dsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        dedat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        dcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP())); 
        laid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        lt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        ld.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        lty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        lsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        ledat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        lcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));     
        getMonthly();
        getWeekly();
        getDaniel();
        getLi();
        getAnika();
        getIntro();
        getPA();
        getPlan();
        getDebrief();
        weeklyNumber.setText("Weekly Appointments: " + weeklyAppointments.size());
        monthlyNumber.setText("Monthly Appointments: " + monthlyAppointments.size());
        totalNumber.setText("Total Appointments: " + Appointments.appointment.size());
        Introductions.setText("Introductions: " + introductions.size());
        PlanningSession.setText("Planning Session: " + planningSession.size());
        PortfolioAnalysis.setText("Portfolio Analysis " + portfolioAnalysis.size());
        DeBriefing.setText("De-Briefing: " + deBriefing.size());
        try{

        tvMonth.setItems(monthlyAppointments);    
        tvWeek.setItems(weeklyAppointments);
        liLee.setItems(li);
        danGarc.setItems(danGarcia);
        anCost.setItems(anCosta);
        
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
        
@FXML
    public void onRefresh(ActionEvent event) throws IOException {
        
        appointmentIn15();
        tvMonth.getItems().clear();    
        tvWeek.getItems().clear();
        liLee.getItems().clear();
        danGarc.getItems().clear();
        anCost.getItems().clear();
        maid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        mt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        md.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        ml.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptLocationP()));
        mc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptContactP()));
        mty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        msdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        medat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        mcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        muid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUserIdP()));
        waid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        wt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        wd.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        wl.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptLocationP()));
        wc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptContactP()));
        wty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        wsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        wedt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        wcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        wuid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUserIdP()));
        maid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        mt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        md.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        ml.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptLocationP()));
        mc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptContactP()));
        mty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        msdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        medat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        mcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        muid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUserIdP()));
        waid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        wt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        wd.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        wl.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptLocationP()));
        wc.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptContactP()));
        wty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        wsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        wedt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        wcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        wuid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUserIdP()));
        aaid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        at.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        ad.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        aty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        asdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        aedat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        dcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));
        daid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        dt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        dd.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        dty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        dsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        dedat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        dcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP())); 
        laid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptIdP()));
        lt.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTitleP()));
        ld.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptDescriptionP()));
        lty.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptTypeP()));
        lsdat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptStart()));
        ledat.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptEnd()));
        lcid.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAptCustIdP()));  
        getMonthly();
        getWeekly();
        getDaniel();
        getLi();
        getAnika();
        getIntro();
        getPA();
        getPlan();
        getDebrief();
        weeklyNumber.setText("Weekly Appointments: " + weeklyAppointments.size());
        monthlyNumber.setText("Monthly Appointments: " + monthlyAppointments.size());
        totalNumber.setText("Total Appointments: " + Appointments.appointment.size());
        Introductions.setText("Introductions: " + introductions.size());
        PlanningSession.setText("Planning Session: " + planningSession.size());
        PortfolioAnalysis.setText("Portfolio Analysis " + portfolioAnalysis.size());
        DeBriefing.setText("De-Briefing: " + deBriefing.size());
        
        try{

        tvMonth.setItems(monthlyAppointments);    
        tvWeek.setItems(weeklyAppointments);
        liLee.setItems(li);
        danGarc.setItems(danGarcia);
        anCost.setItems(anCosta);
        }   catch(NullPointerException e){System.out.println(e);}
               
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Refreshed");
                alert.setHeaderText("All up to date.");
                alert.showAndWait();
    }
        

}
