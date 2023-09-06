/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.Switcher;
import Helper.util;
import static Helper.util.Error;
import static Helper.util.idsStates;
import static Helper.util.statesCountries;
import static Helper.util.statesIds;
import static Helper.util.toUTC;
import Model.Appointment;
import Model.Customer;
import Model.Database;
import static Model.Database.getAllAppointments;
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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
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
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class AppointmentController implements Initializable {
    
    Switcher switcher = new Switcher();
    DateTimeFormatter min = DateTimeFormatter.ofPattern ("mm");
    DateTimeFormatter hour = DateTimeFormatter.ofPattern ("HH");
    DateTimeFormatter hourMin = DateTimeFormatter.ofPattern ("HH:mm");
    DateTimeFormatter yearMonthDay = DateTimeFormatter.ofPattern ("yyyy-MM-dd");
    DateTimeFormatter all = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss");
    
    ObservableList<String> hours = FXCollections.observableArrayList("01", 
            "02", "03", "04", "05", "06",
    "07", "08", "09", "10", "11", "12", "13", 
    "14", "15", "16", "17", "18", "19", "20", "21",
    "22", "23", "24");
    
    ObservableList<String> mins = FXCollections.observableArrayList(
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
    private Button cancelBtn;

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
        String startDate1 = startDate.getValue().format(yearMonthDay);
        String combStartTime = startTime.getValue()+":"+startTime1.getValue();
        
        String endDate1 = endDate.getValue().format(yearMonthDay);
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
        String startHour = appt.getStart().toLocalTime().format(hour);
        String startMin = appt.getStart().toLocalTime().format(min);
        String endHour = appt.getEnd().toLocalTime().format(hour);
        String endMin = appt.getEnd().toLocalTime().format(min);
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
        
        idTxt.clear();
        titleTxt.clear();
        descriptionTxt.clear();
        locationTxt.clear();
        typeTxt.clear();
        startDate.setValue(null);
        endDate.setValue(null);
        startTime.setValue(null);
        startTime1.setValue(null);
        endTime.setValue(null);
        endTime1.setValue(null);
        custIdTxt.clear();
        userIdTxt.clear();
        contactCombo.setValue(null);
        addBtn.setDisable(false);

        appointmentsQuery();
        apptsTbl.setItems(Database.getAllAppointments()); 
        

    }
    
    boolean checkTime()
    {   
        //format start/end dates and times
        String apptStartDate = startDate.getValue().format(yearMonthDay);
        String apptStartTime = startTime.getValue()+":"+startTime1.getValue();
        
        String apptEndDate = endDate.getValue().format(yearMonthDay);
        String apptEndTime = endTime.getValue()+":"+endTime1.getValue();
        
        //convert to utc 
        LocalDateTime startUTC = LocalDateTime.parse(toUTC(apptStartDate + " " + apptStartTime + ":00"), all);
        LocalDateTime endUTC = LocalDateTime.parse(toUTC(apptEndDate + " " + apptEndTime + ":00"), all);

        LocalTime ltStart = LocalTime.parse(apptStartTime, hourMin);
        LocalTime ltEnd = LocalTime.parse(apptEndTime, hourMin);
        //create LocalDateTime objects
        LocalDateTime ldtStart = LocalDateTime.of(startDate.getValue(), ltStart);
        LocalDateTime ldtEnd = LocalDateTime.of(endDate.getValue(), ltEnd);
        
        ZonedDateTime zdtStart = ZonedDateTime.of(ldtStart,ZoneId.systemDefault());
        ZonedDateTime zdtEnd = ZonedDateTime.of(ldtEnd,ZoneId.systemDefault());
        //create Eastern time objects
        ZonedDateTime estStart = zdtStart.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime estEnd = zdtEnd.withZoneSameInstant(ZoneId.of("America/New_York"));
        
        int startDay = estStart.getDayOfWeek().getValue();
        int endDay = estEnd.getDayOfWeek().getValue();
        //get day of week
        int mon = DayOfWeek.MONDAY.getValue();
        int fri = DayOfWeek.FRIDAY.getValue();
        
        LocalTime open = LocalTime.of(8,0,0);
        LocalTime close = LocalTime.of(22,0,0);
        //get time of day
        LocalTime estStartTime = estStart.toLocalTime();
        LocalTime estEndTime = estEnd.toLocalTime();
        
        //check appt day
        if (startDay < mon || startDay>fri || endDay < mon || endDay > fri)
        {
            Error("Please select a day within our hours of operation: "
                    + "Mon-Fri");
            return false;
        }
        //check appt time
        else if (estStartTime.isBefore(open) || estStartTime.isAfter(close) 
                || estEndTime.isBefore(open) || estEndTime.isAfter(close))
        {
            Error("Please select a time within our hours of operation: "
                    + "8am to 10pm");
            return false;
        }
        //check appointment positive duration 
        else if (estStartTime.isAfter(estEndTime) || estStartTime.equals(estEndTime))
        {
            Error("Please make sure the appointment start time is "
                    + "before the end time");
            return false;
        }
//        check if appointments are overlapping
        else
        {
//            System.out.println(getAllAppointments());
            for (Appointment appt: getAllAppointments())
            {
                LocalDateTime apptStart = appt.getStart();
                LocalDateTime apptEnd = appt.getEnd();
                
//                System.out.println(appt);
//                System.out.println(apptStart);
//                System.out.println(apptEnd);
//                System.out.println(ldtStart);
//                System.out.println(ldtEnd);
                if (ldtStart.isBefore(apptStart) && ldtEnd.isBefore(apptStart))
                {
//                    System.out.println("true1");
                }
                
                if ((ldtStart.isAfter(apptEnd) && ldtEnd.isAfter(apptEnd)))
                {
//                    System.out.println("true2");
                }
                if (Integer.toString(appt.getId()).equals(idTxt.getText()))
                {
//                    System.out.println(Integer.toString(appt.getId()));
//                    System.out.println(idTxt.getText());
//                    System.out.println("true0");
                }

                // if the appointment id is not equal to another appointments id
                // check:
                // the following is false: 
                // the appointment start and end are before those of another appointment
                // or after those of another appointment
                if (
                        !(Integer.toString(appt.getId()).equals(idTxt.getText())) 
                        && !((ldtStart.isBefore(apptStart) && !ldtEnd.isAfter(apptStart)) || 
                        (!ldtStart.isBefore(apptEnd) && ldtEnd.isAfter(apptEnd))))
                {
                    Error("Please make sure your appointment is not overlapping with another one.");
                    return false;
                }
            }
        }
        
        
        return true;
        
    }

    @FXML
    void onActionAddBtn(ActionEvent event) throws SQLException {
        
        if (checkTime() == false) {
//            System.out.println("hi");
            return;
        }
        
        else {
            
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

    }

    @FXML
    void onActionAllApptsRadio(ActionEvent event) {
        
        apptsTbl.setItems(Database.getAllAppointments());

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
        
        try
        {
            Appointment appt = apptsTbl.getSelectionModel().getSelectedItem();
            id = appt.getId();
            type = appt.getType();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm delete appointment #" + id + "?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK)
            {
                String sql = "DELETE FROM appointments" 
                + " WHERE Appointment_ID = ?";    
                PreparedStatement ps = JDBC.connection.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                refresh();
            }  
        }
        catch(NullPointerException e)
        {  
            Error("No appointment selected.");
        }

    }

    @FXML
    void onActionEndDate(ActionEvent event) {

    }

    @FXML
    void onActionEndTime(ActionEvent event) {

    }

    @FXML
    void onActionModifyBtn(ActionEvent event) {
        try {
            Appointment appt = apptsTbl.getSelectionModel().getSelectedItem();
            setValues(appt);
            saveBtn.setDisable(false);
            cancelBtn.setDisable(false);
        }
        catch(NullPointerException e)
        {
            Error("No appointment selected");
        }

    }

    @FXML
    void onActionMonthRadio(ActionEvent event) {
        
        ObservableList<Appointment> monthly = FXCollections.observableArrayList();
        
        Month month = LocalDate.now().getMonth();
        int year = LocalDate.now().getYear();
        
        getAllAppointments().forEach(appt -> {
            if (appt.getStart().getMonth() == month && appt.getStart().getYear() == year)
                {
                    monthly.add(appt);
                }
        });
        
        apptsTbl.setItems(monthly);

    }
    
    @FXML
    void onActionCancelBtn(ActionEvent event) throws SQLException {
        
        refresh();
        
    }

    @FXML
    void onActionSaveBtn(ActionEvent event) throws SQLException {
        
        pullValues();
        id = Integer.parseInt(idTxt.getText());
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
        
        saveBtn.setDisable(true);
        cancelBtn.setDisable(true);
        
        if (checkTime() == false) {}
        else {refresh();}

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
        
        ObservableList<Appointment> weekly = FXCollections.observableArrayList();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        
        LocalDate date = LocalDate.now();
        int week = date.get(weekFields.weekOfWeekBasedYear());
        int year = LocalDate.now().getYear();
        
        getAllAppointments().forEach(appt -> {
            if (appt.getStart().get(weekFields.weekOfWeekBasedYear()) == week 
                    && appt.getStart().getYear() == year)
                {
                    weekly.add(appt);
                }
        });
        
        apptsTbl.setItems(weekly);

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
        idTxt.setDisable(true);
        idTxt.setText("Auto Generated");
        
        saveBtn.setDisable(true);
        cancelBtn.setDisable(true);
        
        startTime.setItems(hours);
        startTime1.setItems(mins);
        endTime.setItems(hours);
        endTime1.setItems(mins);
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
