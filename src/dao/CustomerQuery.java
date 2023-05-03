/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Customer;
import Model.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;

/**
 *
 * @author scott
 */
public class CustomerQuery {
    
    //    public static int insert(String fruitName, int colorId) throws SQLException {
//
//        String sql = "INSERT INTO FRUITS (Fruit_Name, Color_ID) VALUES(?, ?)";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setString(1, fruitName);
//        ps.setInt(2, colorId);
//        int rowsAffected = ps.executeUpdate();
//        return rowsAffected;
//
//    }
//    public static int update(int fruitId, String fruitName) throws SQLException {
//        String sql = "UPDATE FRUITS SET Fruit_Name = ? WHERE Fruit_Id = ?";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setString(1, fruitName);
//        ps.setInt(2, fruitId);
//        int rowsAffected = ps.executeUpdate();
//        return rowsAffected;
//    }
//
//    public static int delete(int fruitId) throws SQLException {
//        String sql = "DELETE FROM USERS WHERE Fruit_ID = ?";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setInt(1, fruitId);
//        int rowsAffected = ps.executeUpdate();
//        return rowsAffected;
//    }

//    public static void select() throws SQLException {
//        String sql = "SELECT * FROM USERS";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            int fruitId = rs.getInt("Fruit_ID");
//            String fruitName = rs.getString("Fruit_Name");
//            System.out.print(fruitId + " | ");
//            System.out.print(fruitName + "\n");
//        }
//    }
//
//    public static void select(int colorId) throws SQLException {
//        String sql = "SELECT * FROM FRUITS WHERE COLOR_ID = ?";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setInt(1, colorId);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            int fruitId = rs.getInt("Fruit_ID");
//            String fruitName = rs.getString("Fruit_Name");
//            int colorId1 = rs.getInt("Color_ID");
//            System.out.print(fruitId + " | ");
//            System.out.print(fruitName + " | ");
//            System.out.print(colorId1 + "\n");
//        }
//    }
//    

//        public static void select(int colorId) throws SQLException {
//        String sql = "SELECT * FROM CUSTOMERS";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        
//        while(rs.next()){
//            
//            
//            
//        }
//    }
    
    public static void customersQuery() throws SQLException 
    {
        
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
