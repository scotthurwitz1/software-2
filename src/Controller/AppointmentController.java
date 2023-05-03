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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class AppointmentController implements Initializable {
    
        @FXML
    private Button addBtn;

    @FXML
    private RadioButton allApptsRadio;

    @FXML
    private TableView<?> apptsTbl;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<?> contactCombo;

    @FXML
    private TableColumn<?, ?> contactIdCol;

    @FXML
    private TableColumn<?, ?> custIdCol;

    @FXML
    private TextField custIdTxt;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<?, ?> descripCol;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private DatePicker endDate;

    @FXML
    private TableColumn<?, ?> endDateTimeCol;

    @FXML
    private ComboBox<?> endTime;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<?, ?> locCol;

    @FXML
    private TextField locationTxt;

    @FXML
    private Button modifyBtn;

    @FXML
    private RadioButton monthRadio;

    @FXML
    private Button saveBtn;

    @FXML
    private DatePicker startDate;

    @FXML
    private TableColumn<?, ?> startDateTimeCol;

    @FXML
    private ComboBox<?> startTime;

    @FXML
    private TableColumn<?, ?> titleCol;

    @FXML
    private TextField titleTxt;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private TextField typeTxt;

    @FXML
    private TableColumn<?, ?> userIdCol;

    @FXML
    private TextField userIdTxt;

    @FXML
    private RadioButton weekRadio;

    @FXML
    void onActionAddBtn(ActionEvent event) {

    }

    @FXML
    void onActionAllApptsRadio(ActionEvent event) {

    }

    @FXML
    void onActionBackBtn(ActionEvent event) {

    }

    @FXML
    void onActionContactCombo(ActionEvent event) {

    }

    @FXML
    void onActionDeleteBtn(ActionEvent event) {

    }

    @FXML
    void onActionEndDate(ActionEvent event) {

    }

    @FXML
    void onActionEndTime(ActionEvent event) {

    }

    @FXML
    void onActionModifyBtn(ActionEvent event) {

    }

    @FXML
    void onActionMonthRadio(ActionEvent event) {

    }

    @FXML
    void onActionSaveBtn(ActionEvent event) {

    }

    @FXML
    void onActionStartDate(ActionEvent event) {

    }

    @FXML
    void onActionStartTime(ActionEvent event) {

    }

    @FXML
    void onActionUserIdTxt(ActionEvent event) {

    }

    @FXML
    void onActionWeekRadio(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
