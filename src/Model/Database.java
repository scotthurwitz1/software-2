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
    
    public static void addCustomer(Customer newCust) {

    allCustomers.add(newCust);
    
    }
    
    public static ObservableList<Customer> getAllCustomers() {
        return allCustomers;
    }
    
    
}
