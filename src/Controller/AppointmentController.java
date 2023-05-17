/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.Switcher;
import Helper.util;
import static Helper.util.Alert;
import static Helper.util.idsStates;
import static Helper.util.statesCountries;
import static Helper.util.statesIds;
import static Helper.util.toUTC;
import Model.Appointment;
import Model.Customer;
import Model.Database;
import static dao.AppointmentQuery.appointmentsQuery;
import static dao.ContactQuery.contacts;
import static dao.ContactQuery.contactsIds;
import static dao.ContactQuery.idsContacts;
import static dao.CustomerQuery.customersQuery;
import dao.JDBC;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    Switcher switcher = new Switcher();
    
    ObservableList<String> businessHours = FXCollections.observableArrayList(
    "08", "09", "10", "11", "12", "13", 
    "14", "15", "16", "17", "18", "19", "20", "21");
    
    ObservableList<String> businessMins = FXCollections.observableArrayList(
    "00", "15", "30", "45");
    
    int id = 0;
    String title;
    String descr;
    String loc;
    String type;
    String start;
    String end;
    int custId = 0;
    int userId = 0;
    int contactId = 0;
    Timestamp createDate;
    String createdBy;
    Timestamp lastUpdate;
    String updatedBy;

    @FXML
    private Button addBtn;

    @FXML
    private RadioButton allApptsRadio;

    @FXML
    private TableView<Appointment> apptsTbl;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> contactCombo;

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
    private ComboBox<String> endTime;
    
    @FXML
    private ComboBox<String> endTime1;

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
    private ComboBox<String> startTime;
    
    @FXML
    private ComboBox<String> startTime1;

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
    
    void pullValues()
    {
        String startDate1 = startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String combStartTime = startTime.getValue()+":"+startTime1.getValue();
        
        String endDate1 = endDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String combEndTime = endTime.getValue()+":"+endTime1.getValue();
        
        String startUTC = toUTC(startDate1 + " " + combStartTime + ":00");
        String endUTC = toUTC(endDate1 + " " + combEndTime + ":00");
        
        title = titleTxt.getText();
        descr = descriptionTxt.getText();
        loc = locationTxt.getText();
        type = typeTxt.getText();
        start = startUTC;
        end = endUTC;
        createDate = Timestamp.valueOf(LocalDateTime.now());
        createdBy = "admin";
        lastUpdate = Timestamp.valueOf(LocalDateTime.now());
        updatedBy = "admin";
        custId = Integer.parseInt(custIdTxt.getText());
        userId = Integer.parseInt(userIdTxt.getText());
        contactId = contactsIds.get(contactCombo.getValue());

    }
    
    // set text field values from selected customer
    void setValues(Appointment appt)
    {
        String id = Integer.toString(appt.getId());
        String title = appt.getTitle();
        String description = appt.getDescription();
        String location = appt.getLocation();
        String type = appt.getType();
        String custId = Integer.toString(appt.getCustomerId());
        LocalDate startDate1 = appt.getStart().toLocalDate();
        LocalDate endDate1 = appt.getEnd().toLocalDate();
        String startHour = String.valueOf(appt.getStart().toLocalTime().getHour());
        String startMin = String.valueOf(appt.getStart().toLocalTime().getMinute());
        String endHour = String.valueOf(appt.getEnd().toLocalTime().getHour());
        String endMin = String.valueOf(appt.getEnd().toLocalTime().getMinute());
        String contact = idsContacts.get(appt.getContactId());
        String userId = String.valueOf(appt.getUserId());

        idTxt.setText(id);
        titleTxt.setText(title);
        descriptionTxt.setText(description);
        locationTxt.setText(location);
        typeTxt.setText(type);
        custIdTxt.setText(custId);
        startDate.setValue(startDate1);
        endDate.setValue(endDate1);
        startTime.setValue(startHour);
        startTime1.setValue(startMin);
        endTime.setValue(endHour);
        endTime1.setValue(endMin);
        contactCombo.setValue(contact);
        userIdTxt.setText(userId);
    }
    
     // clear fields and refresh table
    void refresh() throws SQLException
    {
        
        titleTxt.clear();
        descriptionTxt.clear();
        locationTxt.clear();
        typeTxt.clear();
        startDate.setValue(null);
        endDate.setValue(null);
        custIdTxt.clear();
        userIdTxt.clear();
        contactCombo.setValue(null);
        
        appointmentsQuery();
        apptsTbl.setItems(Database.getAllAppointments()); 
    }

    @FXML
    void onActionAddBtn(ActionEvent event) throws SQLException {
        
        pullValues();
        
        String sql = "INSERT INTO appointments (Title, "
                + "Description, Location, Type, Start, End, "
                + "Create_Date, Created_By, Last_Update, Last_Updated_By,"
                + " Customer_ID, User_ID, Contact_ID) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";    
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, title);
        ps.setString(2, descr);
        ps.setString(3, loc);
        ps.setString(4, type);
        ps.setString(5, start);
        ps.setString(6, end);
        ps.setTimestamp(7, createDate);
        ps.setString(8, createdBy);
        ps.setTimestamp(9, lastUpdate);
        ps.setString(10, updatedBy);
        ps.setInt(11, custId);
        ps.setInt(12, userId);
        ps.setInt(13, contactId);
        
        ps.execute();
        
        refresh();

    }

    @FXML
    void onActionAllApptsRadio(ActionEvent event) {

    }

    @FXML
    void onActionBackBtn(ActionEvent event) throws IOException {
        
        switcher.screen("/View/MainMenu.fxml", event);

    }

    @FXML
    void onActionContactCombo(ActionEvent event) {

    }

    @FXML
    void onActionDeleteBtn(ActionEvent event) throws SQLException {
        
        Appointment appt = apptsTbl.getSelectionModel().getSelectedItem();
        id = appt.getId();
        type = appt.getType();
        
        String sql = "DELETE FROM appointments" 
                + " WHERE Appointment_ID = ?";    
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.execute();
        
        refresh();
        
        Alert("The " + type + ", appointment ID: " + Integer.valueOf(id) + " has been "
                + "successfully cancelled");

    }

    @FXML
    void onActionEndDate(ActionEvent event) {

    }

    @FXML
    void onActionEndTime(ActionEvent event) {

    }

    @FXML
    void onActionModifyBtn(ActionEvent event) {
        
        Appointment appt = apptsTbl.getSelectionModel().getSelectedItem();
        setValues(appt);
        id = appt.getId();

    }

    @FXML
    void onActionMonthRadio(ActionEvent event) {

    }

    @FXML
    void onActionSaveBtn(ActionEvent event) throws SQLException {
        
        pullValues();
        
        String sql = "UPDATE appointments SET Title = ?, " 
                + "Description = ?, Location = ?, Type = ?, Start = ?, End = ?, "
                + "Create_Date = ?, Created_By = ?, Last_Update = ?, Last_Updated_By = ?,"
                + " Customer_ID = ? , User_ID = ?, Contact_ID = ?"
                + " WHERE Appointment_ID = ?"; 
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, title);
        ps.setString(2, descr);
        ps.setString(3, loc);
        ps.setString(4, type);
        ps.setString(5, start);
        ps.setString(6, end);
        ps.setTimestamp(7, createDate);
        ps.setString(8, createdBy);
        ps.setTimestamp(9, lastUpdate);
        ps.setString(10, updatedBy);
        ps.setInt(11, custId);
        ps.setInt(12, userId);
        ps.setInt(13, contactId);
        
        ps.setInt(14, id);
        
        ps.execute();
        
        refresh();
        

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
        
        startTime.setItems(businessHours);
        startTime1.setItems(businessMins);
        endTime.setItems(businessHours);
        endTime1.setItems(businessMins);
        contactCombo.setItems(contacts);
  
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
