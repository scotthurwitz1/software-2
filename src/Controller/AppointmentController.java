/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.util;
import Model.Appointment;
import Model.Database;
import static dao.AppointmentQuery.appointmentsQuery;
import static dao.CustomerQuery.customersQuery;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Appointment> apptsTbl;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<?> contactCombo;

    @FXML
    private TableColumn<Appointment, Integer> contactIdCol;

    @FXML
    private TableColumn<Appointment, Integer> custIdCol;

    @FXML
    private TextField custIdTxt;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<Appointment, String> descripCol;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private DatePicker endDate;

    @FXML
    private TableColumn<Appointment, LocalDateTime> endDateTimeCol;

    @FXML
    private ComboBox<?> endTime;

    @FXML
    private TableColumn<Appointment, Integer> idCol;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<Appointment, String> locCol;

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
    private TableColumn<Appointment, LocalDateTime> startDateTimeCol;

    @FXML
    private ComboBox<?> startTime;

    @FXML
    private TableColumn<Appointment, String> titleCol;

    @FXML
    private TextField titleTxt;

    @FXML
    private TableColumn<Appointment, String> typeCol;

    @FXML
    private TextField typeTxt;

    @FXML
    private TableColumn<Appointment, Integer> userIdCol;

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
        // 
        idTxt.setDisable(true);
        idTxt.setText("Auto Generated");
  
        try {
            appointmentsQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        apptsTbl.setItems(Database.getAllAppointments());
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descripCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        startDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        endDateTimeCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        custIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        contactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        userIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
    }    
    
}
