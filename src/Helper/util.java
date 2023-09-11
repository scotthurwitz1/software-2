/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Controller.CustomerController;
import Model.Customer;
import Model.Database;
import static dao.AppointmentQuery.appointmentsQuery;
import static dao.ContactQuery.contactsQuery;
import static dao.CustomerQuery.customersQuery;
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
 * collection of useful methods
 * @author scott
 */
public abstract class util {
    
    private static ObservableList<String> allCountries = FXCollections.observableArrayList(
            "United States", "Canada", "United Kingdom");
    private static ObservableList<String> allStates = FXCollections.observableArrayList();
    private static ObservableList<String> usStates = FXCollections.observableArrayList();
    private static ObservableList<String> canadaStates = FXCollections.observableArrayList();
    private static ObservableList<String> ukStates = FXCollections.observableArrayList();
    
    /**
     *
     */
    public static Map<String, Integer> statesIds = new HashMap<String, Integer>();

    /**
     *
     */
    public static Map<Integer, String> idsStates = new HashMap<Integer, String>();

    /**
     *
     */
    public static Map<String, Integer> countriesIds = new HashMap<String, Integer>();

    /**
     *
     */
    public static Map<String, String> statesCountries = new HashMap<String, String>();
    
    
     /**
     * gets countries list
     * @return the allCountries
     */
  
    public static ObservableList<String> getAllCountries() {
        return allCountries;
    }
    
    /**
     * gets states list
     * @return the allStates
     */
    public static ObservableList<String> getAllStates() {
        return allStates;
    }
    
    /**
     * tasks required on startup of the app
     * @throws SQLException
     */
    public static void initUtil() throws SQLException {
        Database database = new Database();
        
        //queries
        contactsQuery();
        appointmentsQuery();
        customersQuery();
        
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
    
    /**
     * time conversion to utc method
     * @param stamp
     * @return
     */
    public static String toUTC(String stamp)
    {
        Timestamp ex = Timestamp.valueOf(String.valueOf(stamp));
        LocalDateTime local = ex.toLocalDateTime();
        ZonedDateTime zone = local.atZone(ZoneId.of(ZoneId.systemDefault().toString()));
        ZonedDateTime utc = zone.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime local1 = utc.toLocalDateTime();
        String utc1 = local1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return utc1;       
    }

    /**
     * error handling method
     * @param text
     */
    public static void Error(String text)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setContentText(text);
        alert.showAndWait();
    }
    
    /**
     * warning handling method
     * @param text
     */
    public static void Warning(String text)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setContentText(text);
        alert.showAndWait();
    }
    
    /**
     * alert method in french
     * @param text
     */
    public static void alertFR(String text)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message d'Alerte");
        alert.setContentText(text);
        alert.showAndWait();
    }
    //test
    
    /**
     * timezone filter method
     */
    public static void timeZone()
    {
        System.out.println(ZoneId.systemDefault());
        ZoneId.getAvailableZoneIds().stream().filter(z->z.contains("America")).sorted().forEach(System.out::println);
    }
    
    /**
     * method to convert timestamp to local time
     * @param stamp
     * @return
     */
    public static LocalDateTime toLocal(Timestamp stamp)
    {
        LocalDateTime utcLDT = stamp.toLocalDateTime();
        ZoneId utcZoneId = ZoneId.of("UTC");
        ZonedDateTime utcZDT = ZonedDateTime.of(utcLDT, utcZoneId);
        
        ZoneId myZoneID = ZoneId.systemDefault();
        ZonedDateTime myZDT = ZonedDateTime.ofInstant(utcZDT.toInstant(), myZoneID);
        
        LocalDateTime local = myZDT.toLocalDateTime();
        return local;       
    }

    /**
     * gets list of states
     * @return the usStates
     */
    public static ObservableList<String> getUsStates() {
        return usStates;
    }

    /**
     * gets list of provinces
     * @return the canadaStates
     */
    public static ObservableList<String> getCanadaStates() {
        return canadaStates;
    }

    /**
     * gets list of uk first level divisions
     * @return the ukStates
     */
    public static ObservableList<String> getUkStates() {
        return ukStates;
    }


}
