/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import javafx.scene.control.Alert;

/**
 *
 * @author scott
 */
public abstract class util {
    
    public static void Alert(String text)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setContentText(text);
        alert.showAndWait();
    }
    
    
    
}
