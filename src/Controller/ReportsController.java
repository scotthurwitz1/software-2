/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.Switcher;
import Model.Appointment;
import static Model.Database.getAllAppointments;
import Model.ReportObjects;
import Model.ReportObjects.ApptTypeCount;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

import java.net.URL;
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
        // TODO
        ObservableList<ApptTypeCount> ApptTypeCounts = FXCollections.observableArrayList();
        Set<String> apptTypes = new HashSet<>();
        
        for (Appointment appt: getAllAppointments())
        {
            apptTypes.add(appt.getType());
        }
        
        System.out.println(apptTypes);
        
        for (String type: apptTypes)
        {
            ApptTypeCounts.add(new ApptTypeCount(type));
        }
      
    }    
    

}
