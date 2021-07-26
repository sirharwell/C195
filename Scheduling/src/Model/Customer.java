/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 18018
 */
public class Customer {
     private final SimpleIntegerProperty custId = new SimpleIntegerProperty();
    private final SimpleStringProperty custName = new SimpleStringProperty();
    private final SimpleStringProperty custAddress = new SimpleStringProperty();
    private final SimpleStringProperty custZip = new SimpleStringProperty();
    private final SimpleStringProperty custPhone = new SimpleStringProperty();
    
    public Customer() {}
    
    public Customer(int id, String name, String address, String phone, String zip) {
        setCustId(id);
        setCustName(name);
        setCustAddress(address);
        setCustPhone(phone);
        setCustZip(zip);
    }
    
    public int getCustId() {
        return custId.get();
    }
    
    public String getCustName() {
        return custName.get();
    }
    
    public String getCustAddress() {
        return custAddress.get();
    }
    
    
    public String getCustPhone() {
        return custPhone.get();
    }
    
    public String getCustZip() {
        return custZip.get();
    }
    
    public void setCustId(int custId) {
        this.custId.set(custId);
    }
    
    public void setCustName(String custName) {
        this.custName.set(custName);
    }
    
    public void setCustAddress(String custAddress) {
        this.custAddress.set(custAddress);
    }
    
    public void setCustPhone(String custPhone) {
        this.custPhone.set(custPhone);
    }   
    
    public void setCustZip(String custZip) {
        this.custZip.set(custZip);
    }
}