/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.Appointments;
import Model.Contacts;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Customer;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.TimeZone;
/**
 *
 * @author Ian Harwell
 */
public class DBAppointments {
    private static ObservableList<Appointments> appointment = FXCollections.observableArrayList();
    
    /**
     * Gets all appointments from DB and converts time zones
     *
     * 
     */
    public static ObservableList<Appointments> getAllAppointments() {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "SELECT * FROM appointments";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {

            Appointments newAppointment = new Appointments();
            newAppointment.setAptId(rs.getInt("Appointment_ID"));
            newAppointment.setAptTitle(rs.getString("Title"));
            newAppointment.setAptDescription(rs.getString("Description"));
            newAppointment.setAptLocation(rs.getString("Location"));
            newAppointment.setAptType(rs.getString("Type"));
            String start = rs.getString("Start");
            String end = rs.getString("End");
            DateTimeFormatter tf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            ZoneId zid = ZoneId.of("Etc/UTC");
            LocalDateTime lts = LocalDateTime.parse(start, tf);
            ZonedDateTime tdStart = ZonedDateTime.of(lts, zid);           
            LocalDateTime lte = LocalDateTime.parse(end, tf);  
            ZonedDateTime tdEnd = ZonedDateTime.of(lte, zid);
            LocalDate easternD = LocalDate.of(2021, 9, 15);
            LocalTime easternT = LocalTime.of(11, 00);
            ZoneId easternId = ZoneId.of("America/New_York");
            ZonedDateTime easternZDT = ZonedDateTime.of(easternD, easternT, easternId);
            ZoneId localZone = ZoneId.of(TimeZone.getDefault().getID());
            LocalDateTime now = LocalDateTime.now();
            ZonedDateTime zdt = now.atZone(zid);
            Instant easternSToGMT = tdStart.toInstant();
            Instant easternEToGMT = tdEnd.toInstant();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            ZonedDateTime seasternToLocalS = easternSToGMT.atZone(localZone);
            ZonedDateTime eeasternToLocalE = easternEToGMT.atZone(localZone);
            String easternToLocalS = seasternToLocalS.format(myFormatObj);
            String easternToLocalE = eeasternToLocalE.format(myFormatObj);

            ZonedDateTime localToEastern = zdt.withZoneSameInstant(easternId);
            ZonedDateTime startToEastern = tdStart.withZoneSameInstant(easternId);
            ZonedDateTime endToEastern = tdEnd.withZoneSameInstant(easternId);
            String ssEnd = String.valueOf(easternToLocalE);
            String ssStart = String.valueOf(easternToLocalS);
            String[] sStart = ssStart.split(" ");
            String[] sEnd = ssEnd.split(" ");
            newAppointment.setAptDStart(sStart[0]);
            newAppointment.setAptTStart(sStart[1]);
            newAppointment.setAptDEnd(sEnd[0]);
            newAppointment.setAptTEnd(sEnd[1]);
            newAppointment.setAptType(rs.getString("Type"));
            newAppointment.setAptType(rs.getString("Type"));
            int s = rs.getInt("Customer_ID");
            for(Customer c : Customer.customers){
            if(c.getCustId() == s){
                newAppointment.setAptCustId(c);}
            }
            int con = rs.getInt("Contact_ID");
            for(Contacts c : Contacts.contact){
            if(c.getContact_ID() == s){
                newAppointment.setAptContact(c);}
            }

            Appointments.addAppointments(newAppointment);         

            }
            statement.close();
            return appointment;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
    }
   
    /**
     * Saves all appointments to DB
     *
     * 
     */
    public static boolean saveAppointments( int aptId, String aptTitle, String aptDescription, String aptLocation, String aptType, String aptStart, String aptEnd, Customer aptCustId, Contacts aptContact) {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "INSERT INTO appointments(Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID)" + 
                    "VALUES(" +
                    "'" + aptId + "'," +
                    "'" + aptTitle + "'," +
                    "'" + aptDescription + "'," + 
                    "'" + aptLocation + "'," +
                    "'" + aptType + "'," + 
                    "'" + aptStart + "'," +
                    "'" + aptEnd + "'," +
                    "'" + aptCustId.custId + "'," +
                    "'" + "1" + "'," + 
                    "'" + aptContact.contact_ID + "'" +
                    ")";
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
    
    
    
    /**
     * Deletes all appointments from DB
     *
     * 
     */
    public static boolean deleteAppointments() throws SQLException {
        try {
            Connection conn = DBConnection.getConnection();
            DBQuery.setStatement(conn);
            Statement statement = DBQuery.getStatement();
            String query = "DELETE FROM appointments";
            statement.execute(query);
            
        } catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return false;
    }
    
}
