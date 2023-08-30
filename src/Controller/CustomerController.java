/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.Switcher;
import Helper.util;
import static Helper.util.countriesIds;
import static Helper.util.getCanadaStates;
import static Helper.util.getUkStates;
import static Helper.util.getUsStates;
import static Helper.util.statesIds;
import static Helper.util.idsStates;
import static Helper.util.statesCountries;
import Model.Customer;
import Model.Database;
import static dao.CustomerQuery.customersQuery;
import dao.JDBC;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Timestamp;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author scott
 */
public class CustomerController implements Initializable {
    
    Switcher switcher = new Switcher();
    
    int id = 0;
    String name = "";
    String address = "";
    String postal = "";
    String phone = "";
    Timestamp createDate = Timestamp.valueOf(LocalDateTime.now());
    String createdBy = "admin";
    Timestamp lastUpdate = Timestamp.valueOf(LocalDateTime.now());
    String updatedBy = "admin";
    int divId = 0;
    
    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TextField addressTxt;

    @FXML
    private ComboBox<String> countryCombo;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TableColumn<Customer, String> firstCol;

    @FXML
    private TableColumn<Customer, Integer> idCol;

    @FXML
    private TextField idTxt;

    @FXML
    private TableColumn<Customer, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<Customer, String> phoneCol;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TableColumn<Customer, String> postalCol;

    @FXML
    private TextField postalTxt;

    @FXML
    private TableView<Customer> recordsTbl;

    @FXML
    private Button saveBtn;

    @FXML
    private ComboBox<String> stateCombo;
    
    // lift customer details from text fields
    void pullValues()
    {
        name = nameTxt.getText();
        address = addressTxt.getText();
        postal = postalTxt.getText();
        phone = phoneTxt.getText();
        createDate = Timestamp.valueOf(LocalDateTime.now());
        createdBy = "admin";
        lastUpdate = Timestamp.valueOf(LocalDateTime.now());
        updatedBy = "admin";
        divId = statesIds.get(stateCombo.getValue());
    }
    
    // set text field values from selected customer
    void setValues(Customer cust)
    {
        String name = cust.getName();
        String address = cust.getAddress();
        String postal = cust.getPostalCode();
        String phone = cust.getPhone();
        String state = idsStates.get(cust.getDivisionId());
        String country = statesCountries.get(state);

        nameTxt.setText(name);
        addressTxt.setText(address);
        postalTxt.setText(postal);
        phoneTxt.setText(phone);
        stateCombo.setValue(state);
        countryCombo.setValue(country);
    }
    
    // clear fields and refresh table
    void refresh() throws SQLException
    {
        nameTxt.clear();
        addressTxt.clear();
        postalTxt.clear();
        phoneTxt.clear();
        stateCombo.setValue(null);
        countryCombo.setValue(null);
        customersQuery();
        recordsTbl.setItems(Database.getAllCustomers()); 
    }

    @FXML
    void onActionAddBtn(ActionEvent event) throws SQLException {

        pullValues();
        
        String sql = "INSERT INTO customers (Customer_Name, Address, "
                + "Postal_code, Phone, Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";    
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setString(3, postal);
        ps.setString(4, phone);
        ps.setTimestamp(5, createDate);
        ps.setString(6, createdBy);
        ps.setTimestamp(7, lastUpdate);
        ps.setString(8, updatedBy);
        ps.setInt(9, divId);
        ps.execute();
        
        refresh();

    }

    @FXML
    void onActionCountryCombo(ActionEvent event) {
        
        if (countryCombo.getValue()!= null)
            if(countryCombo.getValue().equals("United States"))
                stateCombo.setItems(getUsStates());
            else if (countryCombo.getValue().equals("United Kingdom"))
                stateCombo.setItems(getUkStates());
            else if (countryCombo.getValue().equals("Canada"))
                stateCombo.setItems(getCanadaStates());
        
    }

    @FXML
    void onActionDeleteBtn(ActionEvent event) throws SQLException {
        
        Customer cust = recordsTbl.getSelectionModel().getSelectedItem();
        id = cust.getId();
        
        
        String sql = "DELETE FROM customers" 
                + " WHERE Customer_ID = ?";    
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.execute();
        
        refresh();
        
        

    }

    @FXML
    void onActionEditBtn(ActionEvent event) {
        
        Customer cust = recordsTbl.getSelectionModel().getSelectedItem();
        setValues(cust);
        id = cust.getId();
        

    }

    @FXML
    void onActionExitBtn(ActionEvent event) throws IOException {
        
        switcher.screen("/View/MainMenu.fxml", event);

    }

    @FXML
    void onActionSaveBtn(ActionEvent event) throws SQLException {
        
        pullValues();
        
        String sql = "UPDATE customers SET Customer_Name = ?, Address = ?, "
                + "Postal_code = ?, Phone = ?, Create_Date = ?, Created_By= ?, "
                + "Last_Update = ?, Last_Updated_By = ?, Division_ID = ? "
                + " WHERE Customer_ID = ?";    
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setString(3, postal);
        ps.setString(4, phone);
        ps.setTimestamp(5, createDate);
        ps.setString(6, createdBy);
        ps.setTimestamp(7, lastUpdate);
        ps.setString(8, updatedBy);
        ps.setInt(9, divId);
        
        ps.setInt(10, id);
        
        ps.execute();
        
        refresh();
        

    }

    @FXML
    void onActionStateCombo(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idTxt.setDisable(true);
        idTxt.setText("Auto Generated");
        
        countryCombo.setItems(util.getAllCountries());
               
        try {
            customersQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(Database.getAllCustomers());
        
        recordsTbl.setItems(Database.getAllCustomers());
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        postalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        firstCol.setCellValueFactory(new PropertyValueFactory<>("divisionName"));
        
        
        
        
    }    
    
}
