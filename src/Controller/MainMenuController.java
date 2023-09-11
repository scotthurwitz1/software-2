/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.Switcher;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 * controls main menu
 * @author scott
 */
public class MainMenuController implements Initializable {
    
    Switcher switcher = new Switcher();
    
    @FXML
    private Button appBtn;

    @FXML
    private Button custBtn;

    @FXML
    private Button reportBtn;
    
    /**
     * switch to appointment view
     * @param event
     * @throws IOException 
     */
    @FXML
    void onActionAppBtn(ActionEvent event) throws IOException {
        switcher.screen("/View/Appointment.fxml", event);
    }
    
    /**
     * switch to customer view
     * @param event
     * @throws IOException 
     */
    @FXML
    void onActionCustBtn(ActionEvent event) throws IOException {
        
        switcher.screen("/View/Customer.fxml", event);

    }
    
    /**
     * switch to report view
     * @param event
     * @throws IOException 
     */
    @FXML
    void onActionReportBtn(ActionEvent event) throws IOException {
       switcher.screen("/View/Reports.fxml", event);
    }

    /**
     * Initializes the main menu controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
