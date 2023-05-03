/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Customer;
import Model.Database;
import static dao.CustomerQuery.customersQuery;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ComboBox<?> countryCombo;

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
