/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ian Harwell
 */
public class Contacts {
    
    public int contact_ID;
    private String contact_Name;
    private String email;
    
    public Contacts() {}
    
    public static final ObservableList<Contacts> contact = FXCollections.observableArrayList();
   
    public static void addContacts(Contacts newContact){
        contact.add(newContact);
    }
    
    public Contacts(int contact_ID, String contact_name, String email) {
        setContact_ID(contact_ID);
        setContact_Name(contact_Name);
        setEmail(email);
        }
        
    /**
     * getter 
     *
     * 
     */
    public int getContact_ID() {
        return contact_ID;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getContact_Name() {
        return contact_Name;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getEmail() {
        return email;
    }
        
    /**
     * getter 
     *
     * 
     */
    public void setContact_ID(int contact_ID) {
        this.contact_ID = contact_ID;
    }
        
    /**
     * getter 
     *
     * 
     */
    public void setContact_Name(String contact_Name) {
        this.contact_Name = contact_Name;
    }
        
    /**
     * getter 
     *
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }
        
    /**
     * Fixed display
     *
     * 
     */
            @Override
    public String toString(){
        return(String.valueOf(contact_Name));
    }
}
