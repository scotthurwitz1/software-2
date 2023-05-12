/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class Database {
    
    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    private static ObservableList<Contact> allContacts = FXCollections.observableArrayList();
    
    public static void addCustomer(Customer newCust) {

    allCustomers.add(newCust);
    
    }
    
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    public static ObservableList<Customer> clearCustomers() {
        allCustomers.clear();
        return allCustomers;
    }
    
    public static void addAppointment(Appointment newApp) {

        allAppointments.add(newApp);
    
    }
    
    public static ObservableList<Appointment> getAllAppointments() {
        return allAppointments;
    }
    
    public static ObservableList<Appointment> clearAppointments() {
        allAppointments.clear();
        return allAppointments;
    }
    
    public static void addContact(Contact newContact) {

        allContacts.add(newContact);
    
    }
    
    public static ObservableList<Contact> getAllContacts() {
        return allContacts;
    }
    
    public static ObservableList<Contact> clearContacts() {
        allContacts.clear();
        return allContacts;
    }
    
    
}
