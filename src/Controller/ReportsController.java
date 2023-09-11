/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.Switcher;
import static Helper.util.statesCountries;
import Model.Appointment;
import Model.Customer;
import Model.Database;
import static Model.Database.getAllAppointments;
import static Model.Database.getAllCustomers;
import Model.ReportObjects;
import Model.ReportObjects.CountObj;
import static dao.ContactQuery.contacts;
import static dao.ContactQuery.idsContacts;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.time.Month;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class ReportsController implements Initializable {
    
    Switcher switcher = new Switcher();

    @FXML
    private TableColumn<?, ?> contCol;

    @FXML
    private TableColumn<?, ?> countryCol;

    @FXML
    private TableColumn<?, ?> descCol;

    @FXML
    private TableColumn<?, ?> endCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> custIDCol;

    @FXML
    private TableColumn<?, ?> monthCol;

    @FXML
    private ComboBox<String> nameCombo;

    @FXML
    private TableColumn<?, ?> numCol11;

    @FXML
    private TableColumn<?, ?> numCol2;

    @FXML
    private TableColumn<?, ?> numCol3;

    @FXML
    private TableColumn<?, ?> startCol;

    @FXML
    private TableColumn<?, ?> titleCol;

    @FXML
    private TableColumn<?, ?> typeCol1;
    
    @FXML
    private TableColumn<?, ?> typeCol;
    
    @FXML
    private TableView countryTable;
    
    @FXML
    private TableView monthTable;
    
    @FXML
    private TableView schedTable;
    
    @FXML
    private TableView typeTable1;
    
    @FXML
    private Button backBtn;
    
    /**
     * switches back to main menu
     * @param event
     * @throws IOException 
     */
    @FXML
    void backBtnAction(ActionEvent event) throws IOException {
        switcher.screen("/View/MainMenu.fxml", event);
    }
    
    /**
     * sets schedule contents by contact name
     * @param event 
     */
    @FXML
    void nameComboAction(ActionEvent event) {
        ObservableList<Appointment> contactAppts = FXCollections.observableArrayList();
        
        for (Appointment appt: getAllAppointments())
        {
            if (idsContacts.get(appt.getContactId()).equals(nameCombo.getValue()))
            {
                contactAppts.add(appt);
            }
        }
        
        schedTable.setItems(contactAppts);
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        custIDCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        schedTable.refresh();
    }
    
    

    /**
     * Initializes the reports controller class.
     * populate tables.
     * Lambda expression 1:
     * The lambda expression a -> a.getType().equals(type) checks if the type of each appointment a matches the current type under consideration. The resulting filtered stream is then counted using the count() method to determine the number of appointments of that specific type.
     * Lambda Expression 2:
     * The lambda expression a -> statesCountries.get(a.getDivisionName()).equals(country) checks if the division name of each customer a corresponds to the given country. After filtering, the count() method calculates the total number of customers from that particular country. 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCombo.setItems(contacts);
        // count appt types
        ObservableList<CountObj> ATCountObjs = FXCollections.observableArrayList();
        Set<String> typeSet = new HashSet<>();
        
        for (Appointment appt: getAllAppointments())
        {
            typeSet.add(appt.getType());
        }
      
        for (String type: typeSet)
        {
            long count = getAllAppointments().stream()
                    .filter(a -> a.getType().equals(type))
                    .count();
            ATCountObjs.add(new CountObj(type, count));
        }
        
        typeTable1.setItems(ATCountObjs);
        typeCol1.setCellValueFactory(new PropertyValueFactory<>("type"));
        numCol11.setCellValueFactory(new PropertyValueFactory<>("count"));
        
        // count appts/month
        ObservableList<CountObj> AMCountObjs = FXCollections.observableArrayList();
        Set<Month> monthSet = new HashSet<>();
        
        for (Appointment appt: getAllAppointments())
        {
            monthSet.add(appt.getStart().getMonth());
        }
      
        for (Month month: monthSet)
        {
            long count = getAllAppointments().stream()
                    .filter(m -> m.getStart().getMonth() == month)
                    .count();
            AMCountObjs.add(new CountObj(month, count));
        }
        
        monthTable.setItems(AMCountObjs);
        monthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        numCol2.setCellValueFactory(new PropertyValueFactory<>("count"));
        
        // count cust/country
        ObservableList<CountObj> CCountObjs = FXCollections.observableArrayList();
        Set<String> countrySet = new HashSet<>();
        
        countrySet.add("United States");
        countrySet.add("United Kingdom");
        countrySet.add("Canada");  

        for (String country: countrySet)
        {
            long count = getAllCustomers().stream()
                    .filter(a -> statesCountries.get(a.getDivisionName()).equals(country))
                    .count();
            CCountObjs.add(new CountObj(country, count));
        }
        
        countryTable.setItems(CCountObjs);
        countryCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        numCol3.setCellValueFactory(new PropertyValueFactory<>("count"));
       
        
    }    
}
