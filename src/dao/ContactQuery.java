/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Appointment;
import Model.Contact;
import Model.Database;
import static Model.Database.clearCustomers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * queries sql db for contacts
 * @author scott
 */
public class ContactQuery {
    
    /**
     * map contact names to ids
     */
    public static Map<String, Integer> contactsIds = new HashMap<String, Integer>();

    /**
     * map contact ids to names
     */
    public static Map<Integer, String> idsContacts = new HashMap<Integer, String>();

    /**
     * list of contacts
     */
    public static ObservableList<String> contacts = FXCollections.observableArrayList();
    
    /**
     * get contacts from sql db
     * @throws SQLException
     */
    public static void contactsQuery() throws SQLException 
    {
//        clearCustomers();
        
        String sql = "SELECT * FROM contacts";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            int id = rs.getInt("Contact_ID");
            String name = rs.getString("Contact_Name");
            String email = rs.getString("email");
            
            Contact contact = new Contact(id, name, email);
            
            Database.addContact(contact);
            
            contactsIds.put(name, id);
            idsContacts.put(id, name);
            contacts.add(name);
        }
        
    }
    
}
