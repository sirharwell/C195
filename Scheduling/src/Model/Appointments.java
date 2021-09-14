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
    private int aptCustId;
    private String aptDStart;
    private String aptDEnd;
    private String aptTStart;
    private String aptTEnd;
    private String aptTitle;
    private String aptDescription;
    private String aptLocation;
    private String aptContact;
    
    public Appointments() {}
    
    public static final ObservableList<Appointments> appointment = FXCollections.observableArrayList();
    
    public static void addAppointments(Appointments newAppointment){
        appointment.add(newAppointment);
    }
    public static void removeAppointments(Appointments removeAppointment){
        appointment.remove(removeAppointment);
    }
    
    public Appointments(int id, int custId, String dStart, String dEnd, String tStart, String tEnd, String title, String description, String location, String contact) {
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
    }
    
    public int getAptId() {
        return aptId;
    }
    
    public int getAptCustId() {
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
    
    public String getAptContact() {
        return aptContact;
    }
    
    public void setAptId(int aptId) {
        this.aptId = aptId;
    }
    
    public void setAptCustId(int aptCustId) {
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
    
    public void setAptContact(String aptContact) {
        this.aptContact = aptContact;
    }
    
    /*  public StringProperty getAptEndProperty() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
 	LocalDateTime ldt = LocalDateTime.parse(this.aptEnd.getValue(), df);
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("UTC"));
        ZoneId zid = ZoneId.systemDefault();
        ZonedDateTime utcDate = zdt.withZoneSameInstant(zid); 
        StringProperty date = new SimpleStringProperty(utcDate.toLocalDateTime().toString());
        return date;
    }
    
    public StringProperty getAptStartProperty() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"); 
 	LocalDateTime ldt = LocalDateTime.parse(this.aptStart.getValue(), df);
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("UTC"));
        ZoneId zid = ZoneId.systemDefault();
        ZonedDateTime utcDate = zdt.withZoneSameInstant(zid); 
        StringProperty date = new SimpleStringProperty(utcDate.toLocalDateTime().toString());
        return date;
    }
    
    public StringProperty getAptTitleProperty() {
        return this.aptTitle;
    }
    
    public StringProperty getAptDescriptionProperty() {
        return this.aptDescription;
    }
    
    public StringProperty getAptLocationProperty() {
        return this.aptLocation;
    }
    
    public StringProperty getAptContactProperty() {
        return this.aptContact;
    }
    
    public LocalDate getDateOnly() {
        Timestamp ts = Timestamp.valueOf(this.aptStart.get());
        ZonedDateTime zdt;
        ZoneId zid;
        LocalDate ld;
        if(this.aptLocation.get().equals("New York")) {
            zid = ZoneId.of("America/New_York");
        } else if(this.aptLocation.get().equals("Phoenix")) {
            zid = ZoneId.of("America/Phoenix");
        } else {
            zid = ZoneId.of("Europe/London");
        }
        zdt = ts.toLocalDateTime().atZone(zid);
        ld = zdt.toLocalDate();
        return ld;
    }
    
    public String getTimeOnly() {
        Timestamp ts = Timestamp.valueOf(this.aptStart.get());
        ZonedDateTime zdt;
        ZoneId zid;
        LocalTime lt;
        if(this.aptLocation.get().equals("New York")) {
            zid = ZoneId.of("America/New_York");
            zdt = ts.toLocalDateTime().atZone(zid);
            lt = zdt.toLocalTime().minusHours(4);
        } else if(this.aptLocation.get().equals("Phoenix")) {
            zid = ZoneId.of("America/Phoenix");
            zdt = ts.toLocalDateTime().atZone(zid);
            lt = zdt.toLocalTime().minusHours(7);
        } else {
            zid = ZoneId.of("Europe/London");
            zdt = ts.toLocalDateTime().atZone(zid);
            lt = zdt.toLocalTime().plusHours(1);
        }
        int rawH = Integer.parseInt(lt.toString().split(":")[0]);
        if(rawH > 12) {
            rawH -= 12;
        }
        String ampm;
        if(rawH < 9 || rawH == 12) {
            ampm = "PM";
        } else {
            ampm = "AM";
        }
        String time = rawH + ":00 " + ampm;
        return time;
    }
    
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