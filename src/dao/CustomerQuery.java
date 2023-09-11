/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Customer;
import Model.Database;
import static Model.Database.clearCustomers;
import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;

/**
 * queries sql db for customers
 * @author scott
 */
public class CustomerQuery {

    /**
     * gets all customers
     * @throws SQLException
     */
    
    public static void customersQuery() throws SQLException 
    {
        clearCustomers();
        
        String sql = "SELECT customers.Customer_ID, customers.Customer_Name, customers.Address, "
                + "customers.Postal_code, customers.Phone, customers.Division_ID, first_level_divisions.Division "
                + "FROM customers INNER JOIN first_level_divisions ON customers.Division_ID = "
                + "first_level_divisions.Division_ID";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            int id = rs.getInt("Customer_ID");
            String name = rs.getString("Customer_Name");
            String address = rs.getString("Address");
            String postalCode = rs.getString("Postal_Code");
            String phone = rs.getString("Phone");
            int divisionId = rs.getInt("Division_ID");
            String divisionName = rs.getString("Division");
            
            Customer customer = new Customer(id, name, address, postalCode, phone, divisionId, divisionName);
            Database.addCustomer(customer);
        }
        
    }
    
}
