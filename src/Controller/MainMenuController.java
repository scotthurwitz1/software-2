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
 *
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

    @FXML
    void onActionAppBtn(ActionEvent event) {

    }

    @FXML
    void onActionCustBtn(ActionEvent event) throws IOException {
        
        switcher.screen("/View/Customer.fxml", event);

    }

    @FXML
    void onActionReportBtn(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
