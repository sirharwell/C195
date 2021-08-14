/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 18018
 */
public class Customer {
    private int custId;
    private String custName;
    private String custAddress;
    private String custZip;
    private String custPhone;
    private String custCountry;
    private String custState;

    
    public Customer() {}
    
    public Customer(int id, String customerName, String address, String phone, String postalCode, String countryChoice, String stateChoice) {
        setCustId(id);
        setCustName(customerName);
        setCustAddress(address);
        setCustPhone(phone);
        setCustZip(postalCode);
        setCustCountry(countryChoice);
        setCustState(stateChoice);
    }
    
    public static final ObservableList<Customer> customers = FXCollections.observableArrayList();
    
    public static void addCustomer(Customer newCustomer){
        customers.add(newCustomer);
    }
    
    public int getCustId() {
        return custId;
    }
    
    public String getCustName() {
        return custName;
    }
    
    public String getCustAddress() {
        return custAddress;
    }
    
    
    public String getCustPhone() {
        return custPhone;
    }
    
    public String getCustZip() {
        return custZip;
    }
    
    public String getCustCountry() {
        return custCountry;
    }
        
    public String getCustState() {
        return custState;
    }
    
    public void setCustId(int custId) {
        this.custId = custId;
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }
    
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }   
    
    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }
    
    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }
        
    public void setCustState(String custState) {
        this.custState =  custState;
    }
    
    public static int getCustomerCount(){
        return customers.size();
    }
    
    @Override
    public String toString(){
        return(String.valueOf(custName));
                //+ " " + String.valueOf(custId) + " " + String.valueOf(custName) + " " + String.valueOf(custAddress) + " " + String.valueOf(custZip) + " " + String.valueOf(custCountry) + " " + String.valueOf(custState) );
    }
}
