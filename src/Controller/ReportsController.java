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
    private TableColumn<?, ?> locCol;

    @FXML
    private TableColumn<?, ?> monthCol;

    @FXML
    private ComboBox<?> nameCombo;

    @FXML
    private TableColumn<?, ?> numCol1;

    @FXML
    private TableColumn<?, ?> numCol2;

    @FXML
    private TableColumn<?, ?> numCol3;

    @FXML
    private TableColumn<?, ?> startCol;

    @FXML
    private TableColumn<?, ?> titleCol;

    @FXML
    private TableColumn<?, ?> typeCol;
    
    @FXML
    private TableView countryTable;
    
    @FXML
    private TableView monthTable;
    
    @FXML
    private TableView schedTable;
    
    @FXML
    private TableView typeTable;
    
    @FXML
    private Button backBtn;
    
        @FXML
    void backBtnAction(ActionEvent event) throws IOException {
        switcher.screen("/View/MainMenu.fxml", event);
    }

    @FXML
    void nameComboAction(ActionEvent event) {

    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
//        for (CountObj obj: ATCountObjs)
//        {
//            System.out.print(obj.getType());
//            System.out.print(obj.getCount());
//        }
        
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
        
        for (CountObj obj:CCountObjs)
        {
            System.out.println(obj.getType());
            System.out.println(obj.getCount());
        }
        
    }    

}
