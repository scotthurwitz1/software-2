/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Controller.CustomerController;
import Model.Customer;
import static dao.ContactQuery.contactsQuery;
import dao.JDBC;
import java.io.IOException;
import java.time.LocalDate;
import java.sql.Timestamp;
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
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author scott
 */
public abstract class util {
    
    private static ObservableList<String> allCountries = FXCollections.observableArrayList(
            "United States", "Canada", "United Kingdom");
    private static ObservableList<String> allStates = FXCollections.observableArrayList();
    private static ObservableList<String> usStates = FXCollections.observableArrayList();
    private static ObservableList<String> canadaStates = FXCollections.observableArrayList();
    private static ObservableList<String> ukStates = FXCollections.observableArrayList();
    
    
    public static Map<String, Integer> statesIds = new HashMap<String, Integer>();
    public static Map<Integer, String> idsStates = new HashMap<Integer, String>();
    public static Map<String, Integer> countriesIds = new HashMap<String, Integer>();
    public static Map<String, String> statesCountries = new HashMap<String, String>();
    
    
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
    
    public static void initUtil() throws SQLException {
        
        
        
        //contacts query
        contactsQuery();
        
        //country Ids
        countriesIds.put("United States", 1);
        countriesIds.put("United Kingdom", 2);
        countriesIds.put("Canada", 3);
        
        // locations query
        String country;
        String sql = "SELECT * FROM first_level_divisions";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            // list of states
                String state = rs.getString("Division");
                allStates.add(state);  
            // map of states, ids
                int id = rs.getInt("Division_ID");
                statesIds.put(state, id);        
            // map of ids, states
                idsStates.put(id, state); 
            //map of states, countries
                if (id <= 54)
                {
                    country = "United States";
                    statesCountries.put(state, country);
                    getUsStates().add(state);
                }    
                else if (id >= 60 && id <= 72)
                {
                    country = "Canada";
                    statesCountries.put(state, country);
                    getCanadaStates().add(state);
                }
                else
                {
                    country = "United Kingdom";
                    statesCountries.put(state, country);
                    getUkStates().add(state);
                }
        }
    }
    
    public static String toUTC(String stamp)
    {
        Timestamp current = Timestamp.valueOf(String.valueOf(stamp));
        LocalDateTime local = current.toLocalDateTime();
        ZonedDateTime zone = local.atZone(ZoneId.of(ZoneId.systemDefault().toString()));
        ZonedDateTime utc = zone.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime local1 = utc.toLocalDateTime();
        String utc1 = local1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        return utc1;       
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

    /**
     * @return the usStates
     */
    public static ObservableList<String> getUsStates() {
        return usStates;
    }

    /**
     * @return the canadaStates
     */
    public static ObservableList<String> getCanadaStates() {
        return canadaStates;
    }

    /**
     * @return the ukStates
     */
    public static ObservableList<String> getUkStates() {
        return ukStates;
    }


   
    
    
    
    
}
