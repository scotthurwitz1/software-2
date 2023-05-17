/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbclientappv4;


import static Helper.util.initUtil;
import static Helper.util.statesIds;
import Model.Appointment;
import Model.Database;
import static Model.Database.getAllAppointments;
import dao.JDBC;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author scott
 */
public class DBClientAppV4 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        
        JDBC.openConnection();
        
        initUtil();

        
        launch(args);

        JDBC.closeConnection();
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Appointment.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Java FX Menu");
        stage.show();
    }
    
}
