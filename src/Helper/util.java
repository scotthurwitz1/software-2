/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Model.Customer;
import dao.JDBC;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author scott
 */
public abstract class util {
    
    private static ObservableList<String> allCountries = FXCollections.observableArrayList(
            "United States", "Canada", "United Kingdom");
    
    private static ObservableList<String> allStates = FXCollections.observableArrayList();
    
        /**
     * @return the allCountries
     */
    public static ObservableList<String> getAllCountries() {
        return allCountries;
    }
    
    /**
     * @return the allStates
     */
    public static ObservableList<String> getAllStates() {
        return allStates;
    }
    
    public static void statesQuery() throws SQLException {
        String sql = "SELECT * FROM first_level_divisions";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
                String state = rs.getString("Division");
                allStates.add(state);
        }
    }
    
    
    public static void Alert(String text)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setContentText(text);
        alert.showAndWait();
    }
    
    public static void alertFR(String text)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Message d'Alerte");
        alert.setContentText(text);
        alert.showAndWait();
    }
    
    public static void timeZone()
    {
        System.out.println(ZoneId.systemDefault());
        ZoneId.getAvailableZoneIds().stream().filter(z->z.contains("America")).sorted().forEach(System.out::println);
    }
    
//    public static void ZDT()
//    {
//        LocalDate myLD = LocalDate.of(2020, 10, 11); // or use "date picker"?
//        LocalTime myLT = LocalTime.of(22, 0);
//        
//        LocalDateTime myLDT = LocalDateTime.of(myLD, myLT);
//        ZoneId myZoneId = ZoneId.systemDefault();
//        ZonedDateTime myZDT = ZonedDateTime.of(myLDT, myZoneId);
//        
////        System.out.println(myZDT.toLocalDate());
////        System.out.println(myZDT.toLocalTime());
////        System.out.println(myZDT.toLocalDate().toString() + " " + myZDT.toLocalTime().toString());
//
//        System.out.println("User time: " + myZDT);
//        
//        // time to utc 
//        ZoneId utcZoneId = ZoneId.of("UTC");
//        ZonedDateTime utcZDT = ZonedDateTime.ofInstant(myZDT.toInstant(), utcZoneId);
//        System.out.println("User time to UTC: " + utcZDT);
//        
//        // utc to time
//        myZDT = ZonedDateTime.ofInstant(utcZDT.toInstant(), myZoneId);
//        System.out.println("UTC to User Time: " + myZDT);
//
//    }


   
    
    
    
    
}
