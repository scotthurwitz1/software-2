/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class CustomerController implements Initializable {
    
    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TextField addressTxt;

    @FXML
    private ComboBox<?> countryCombo;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<?, ?> firstCol;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TableColumn<?, ?> postalCol;

    @FXML
    private TextField postalTxt;

    @FXML
    private TableView<?> recordsTbl;

    @FXML
    private Button saveBtn;

    @FXML
    private ComboBox<?> stateCombo;

    @FXML
    void onActionAddBtn(ActionEvent event) {

    }

    @FXML
    void onActionCountryCombo(ActionEvent event) {

    }

    @FXML
    void onActionDeleteBtn(ActionEvent event) {

    }

    @FXML
    void onActionEditBtn(ActionEvent event) {

    }

    @FXML
    void onActionExitBtn(ActionEvent event) {

    }

    @FXML
    void onActionSaveBtn(ActionEvent event) {

    }

    @FXML
    void onActionStateCombo(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
