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
 * @author Ian Harwell
 */
public class Customer {
    public int custId;
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
    public static void removeCustomer(Customer editCustomer){
        customers.remove(editCustomer);
    }
        
    /**
     * getter 
     *
     * 
     */
    public int getCustId() {
        return custId;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getCustName() {
        return custName;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getCustAddress() {
        return custAddress;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getCustPhone() {
        return custPhone;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getCustZip() {
        return custZip;
    }
        
    /**
     * getter 
     *
     * 
     */
    public String getCustCountry() {
        return custCountry;
    }
           
    /**
     * getter 
     *
     * 
     */ 
    public String getCustState() {
        return custState;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }   
        
    /**
     * setter 
     *
     * 
     */
    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }
        
    /**
     * setter 
     *
     * 
     */
    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }
           
    /**
     * setter 
     *
     * 
     */ 
    public void setCustState(String custState) {
        this.custState =  custState;
    }
        
    /**
     * setter 
     *
     * 
     */
    public static int getCustomerCount(){
        return (customers.size() + 1);
    }
        
    /**
     * Fixes display name 
     *
     * 
     */
    @Override
    public String toString(){
        return(String.valueOf(custName));
                //+ " " + String.valueOf(custId) + " " + String.valueOf(custName) + " " + String.valueOf(custAddress) + " " + String.valueOf(custZip) + " " + String.valueOf(custCountry) + " " + String.valueOf(custState) );
    }
}
