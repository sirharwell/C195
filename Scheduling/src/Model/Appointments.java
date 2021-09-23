package Model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ian Harwell
 */
public class Appointments {
    public int aptId;
    private Customer aptCustId;
    public String aptDStart;
    private String aptDEnd;
    public String aptTStart;
    private String aptTEnd;
    private String aptTitle;
    private String aptDescription;
    private String aptLocation;
    private Contacts aptContact;
    private String aptType;
    private String aptUserId;
    private final SimpleStringProperty aptIdP = new SimpleStringProperty();
    private final SimpleStringProperty aptCustIdP = new SimpleStringProperty();
    private final SimpleStringProperty aptDStartP = new SimpleStringProperty();
    private final SimpleStringProperty aptDEndP = new SimpleStringProperty();
    private final SimpleStringProperty aptTStartP = new SimpleStringProperty();
    private final SimpleStringProperty aptTEndP = new SimpleStringProperty();
    private final SimpleStringProperty aptTitleP = new SimpleStringProperty();
    private final SimpleStringProperty aptDescriptionP = new SimpleStringProperty();
    private final SimpleStringProperty aptLocationP = new SimpleStringProperty();
    private final SimpleStringProperty aptContactP = new SimpleStringProperty();
    private final SimpleStringProperty aptTypeP = new SimpleStringProperty();
    private final SimpleStringProperty aptUserIdP = new SimpleStringProperty();
    
    public Appointments() {}
    
    
    public static final ObservableList<Appointments> appointment = FXCollections.observableArrayList();
        
    /**
     * Adds appointments to the list 
     *
     * 
     */  
    public static void addAppointments(Appointments newAppointment){
        appointment.add(newAppointment);
    }    
    /**
     * Removes appointments from the list 
     *
     * 
     */
    public static void removeAppointments(Appointments removeAppointment){
        appointment.remove(removeAppointment);
    }
    
    public Appointments(int id, Customer custId, String dStart, String dEnd, String tStart, String tEnd, String title, String description, String location, Contacts contact, String type) {
        setAptId(id);
        setAptCustId(custId);
        setAptDStart(dStart);
        setAptDEnd(dEnd);
        setAptTStart(tStart);
        setAptTEnd(tEnd);
        setAptTitle(title);
        setAptDescription(description);
        setAptLocation(location);
        setAptContact(contact);
        setAptType(type);
    }
        
    /**
     * getter 
     *
     * 
     */
    public int getAptId() {
        return aptId;
    }
        
    /**
     * getter 
     *
     * 
     */
    public Customer getAptCustId() {
        return aptCustId;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptTEnd() {
        return aptTEnd;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptTStart() {
        return aptTStart;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptDEnd() {
        return aptDEnd;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptDStart() {
        return aptDStart;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptTitle() {
        return aptTitle;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptDescription() {
        return aptDescription;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptLocation() {
        return aptLocation;
    }
        
    /**
     * getter 
     *
     * 
     */
    public Contacts getAptContact() {
        return aptContact;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getAptType() {
    return aptType;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptId(int aptId) {
        this.aptId = aptId;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptCustId(Customer aptCustId) {
        this.aptCustId = aptCustId;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptTEnd(String aptTEnd) {
        this.aptTEnd = aptTEnd;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptTStart(String aptTStart) {
        this.aptTStart = aptTStart;
    } 
        
    /**
     * setter 
     *
     * 
     */
    public void setAptDEnd(String aptDEnd) {
        this.aptDEnd = aptDEnd;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptDStart(String aptDStart) {
        this.aptDStart = aptDStart;
    } 
        
    /**
     * setter 
     *
     * 
     */
    public void setAptTitle(String aptTitle) {
        this.aptTitle = aptTitle;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptDescription(String aptDescription) {
        this.aptDescription = aptDescription;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptLocation(String aptLocation) {
        this.aptLocation = aptLocation;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptContact(Contacts aptContact) {
        this.aptContact = aptContact;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setAptType(String aptType) {
    this.aptType = aptType;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setUserId(String userId) {
    this.aptUserId = "1";
    }
        
    /**
     * getter 
     *
     * 
     */
    public static int getAppointmentCount(){
        return (appointment.size() + 1); }   
    
    /**
     * getter 
     *
     * 
     */
    public String getAptIdP() {
        return String.valueOf(aptId);
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptCustIdP() {
        return String.valueOf(aptCustId);
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptDStartP() {
        return aptDStart;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptDEndP() {
        return aptDEnd;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptTStartP() {
        return aptTStart;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptTEndP() {
        return aptTEnd;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptTitleP() {
        return aptTitle;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptDescriptionP() {
        return aptDescription;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptLocationP() {
        return aptLocation;
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptContactP() {
        return String.valueOf(aptContact);
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptTypeP() {
        return aptType;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getUserIdP() {
        return "1";
    }
    
    /**
     * getter 
     *
     * 
     */
    public String getAptStart() {
            return (aptDStart + " " + aptTStart);
        }    
     
    /**
     * getter 
     *
     * 
     */
    public String getAptEnd() {
        return (aptDEnd + " " + aptTEnd);
    }   
        
    /**
     * Fixes displayed name 
     *
     * 
     */
        @Override
    public String toString(){
        return(String.valueOf(aptTitle));
    }
}