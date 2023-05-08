/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbclientappv4;

import static Helper.util.statesQuery;
import Model.Database;
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
    public static void main(String[] args) throws SQLException {
        
        JDBC.openConnection();
        
        statesQuery();
        
        launch(args);
//        ObservableList<ObservableList> trial = dbToArray("customers");
//        System.out.println(trial);
        JDBC.closeConnection();
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("My Java FX Menu");
        stage.show();
    }
    
}
