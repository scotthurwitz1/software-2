/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * data holding class with object lists
 * @author scott
 */
public class Database {
    
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    private static ObservableList<Contact> allContacts = FXCollections.observableArrayList();
    
    /**
     * add customer to main list
     * @param newCust
     */
    public static void addCustomer(Customer newCust) {

    allCustomers.add(newCust);
    
    }
    
    /**
     * get all customers
     * @return
     */
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    /**
     * clear customers list
     * @return
     */
    public static ObservableList<Customer> clearCustomers() {
        allCustomers.clear();
        return allCustomers;
    }
    
    /**
     * add appointment to main list
     * @param newApp
     */
    public static void addAppointment(Appointment newApp) {

        allAppointments.add(newApp);
    
    }
    
    /**
     * get all appts
     * @return
     */
    public static ObservableList<Appointment> getAllAppointments() {
        return allAppointments;
    }
    
    /**
     * clear appt list
     * @return
     */
    public static ObservableList<Appointment> clearAppointments() {
        allAppointments.clear();
        return allAppointments;
    }
    
    /**
     * add contact to central list
     * @param newContact
     */
    public static void addContact(Contact newContact) {

        allContacts.add(newContact);
    
    }
    
    /**
     * get all contacts
     * @return
     */
    public static ObservableList<Contact> getAllContacts() {
        return allContacts;
    }
    
    /**
     * clear contact list
     * @return
     */
    public static ObservableList<Contact> clearContacts() {
        allContacts.clear();
        return allContacts;
    }
    
    
}
