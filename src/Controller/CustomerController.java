/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Helper.util;
import static Helper.util.countriesIds;
import static Helper.util.statesIds;
import Model.Customer;
import Model.Database;
import static dao.CustomerQuery.customersQuery;
import dao.JDBC;
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
    void onActionSaveBtn(ActionEvent event) throws SQLException {
        
        String sql = "INSERT INTO customers (Customer_Name, Address, "
                + "Postal_code, Phone, Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";    
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        
        String name = nameTxt.getText();
        String address = addressTxt.getText();
        String postal = postalTxt.getText();
        String phone = phoneTxt.getText();
        Timestamp createDate = Timestamp.valueOf(LocalDateTime.now());
        String createdBy = "admin";
        Timestamp lastUpdate = Timestamp.valueOf(LocalDateTime.now());
        String updatedBy = "admin";
        int divId = statesIds.get(stateCombo.getValue());
        
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
        
        nameTxt.clear();
        addressTxt.clear();
        postalTxt.clear();
        phoneTxt.clear();
        
        customersQuery();
        recordsTbl.setItems(Database.getAllCustomers()); 

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
        stateCombo.setItems(util.getAllStates());
        
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
