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
 * @author 18018
 */
public class Appointments {
    private int aptId;
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
    
    public Appointments() {}
    
    public static final ObservableList<Appointments> appointment = FXCollections.observableArrayList();
    
    public static void addAppointments(Appointments newAppointment){
        appointment.add(newAppointment);
    }
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
    
    public int getAptId() {
        return aptId;
    }
    
    public Customer getAptCustId() {
        return aptCustId;
    }
    
    public String getAptTEnd() {
        return aptTEnd;
    }
    
    public String getAptTStart() {
        return aptTStart;
    }
    
    public String getAptDEnd() {
        return aptDEnd;
    }
    
    public String getAptDStart() {
        return aptDStart;
    }
    
    public String getAptTitle() {
        return aptTitle;
    }
    
    public String getAptDescription() {
        return aptDescription;
    }
    
    public String getAptLocation() {
        return aptLocation;
    }
    
    public Contacts getAptContact() {
        return aptContact;
    }
    
    public String getAptType() {
    return aptType;
    }
    
    public void setAptId(int aptId) {
        this.aptId = aptId;
    }
    
    public void setAptCustId(Customer aptCustId) {
        this.aptCustId = aptCustId;
    }
    
    public void setAptTEnd(String aptTEnd) {
        this.aptTEnd = aptTEnd;
    }
    
    public void setAptTStart(String aptTStart) {
        this.aptTStart = aptTStart;
    } 
    
    public void setAptDEnd(String aptDEnd) {
        this.aptDEnd = aptDEnd;
    }
    
    public void setAptDStart(String aptDStart) {
        this.aptDStart = aptDStart;
    } 
    
    public void setAptTitle(String aptTitle) {
        this.aptTitle = aptTitle;
    }
    
    public void setAptDescription(String aptDescription) {
        this.aptDescription = aptDescription;
    }
    
    public void setAptLocation(String aptLocation) {
        this.aptLocation = aptLocation;
    }
    
    public void setAptContact(Contacts aptContact) {
        this.aptContact = aptContact;
    }
    
    public void setAptType(String aptType) {
    this.aptType = aptType;
    }
   /*
    
    
    public String get15Time() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
 	LocalDateTime ldt = LocalDateTime.parse(this.aptStart.getValue(), df);
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("UTC"));
        ZoneId zid = ZoneId.systemDefault();
        ZonedDateTime utcDate = zdt.withZoneSameInstant(zid); 
        DateTimeFormatter tFormatter = DateTimeFormatter.ofPattern("kk:mm"); 
	LocalTime localTime = LocalTime.parse(utcDate.toString().substring(11,16), tFormatter);
        return localTime.toString();
    }*/
    
    public static int getAppointmentCount(){
        return (appointment.size() + 1); }   
    
        @Override
    public String toString(){
        return(String.valueOf(aptTitle));
    }
}