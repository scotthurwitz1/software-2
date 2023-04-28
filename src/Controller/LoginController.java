package Controller;

import Helper.util;
import dao.UserQuery;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Helper.Switcher;

public class LoginController implements Initializable {
    
    Switcher switcher = new Switcher();

    @FXML
    private Label locationLbl;
    
    @FXML
    private Label usernameLbl;
    
    @FXML
    private Label passwordLbl;

    @FXML
    private TextField passwordTxt;

    @FXML
    private Label userLocationLbl;

    @FXML
    private TextField usernameTxt;
    
    @FXML
    private Button loginBtn;
    
    @FXML
    void onActionLoginBtn(ActionEvent event) throws SQLException, IOException {   
        if (UserQuery.selectLoginCreds(usernameTxt.getText(), passwordTxt.getText()))
        {
            switcher.screen("/View/MainMenu.fxml", event);
        }
    }

    @FXML
    void onActionPassword(ActionEvent event) throws SQLException {
 
    }

    @FXML
    void onActionUsername(ActionEvent event) throws SQLException {
  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(Locale.getDefault());
        try
        {
           ResourceBundle rb = ResourceBundle.getBundle("dbclientappv4/Nat", Locale.getDefault());
           if(Locale.getDefault().getLanguage().equals("fr"))
            {
                usernameLbl.setText(rb.getString("Username"));
                passwordLbl.setText(rb.getString("Password"));
                locationLbl.setText(rb.getString("Location"));
                userLocationLbl.setText("Montréal, QC");
            } 
        }
        catch (MissingResourceException e)
        {
            String tz = ZoneId.systemDefault().toString();
            System.out.println(tz);
            if (tz.equals("America/New_York"))
            {
                userLocationLbl.setText("White PLains, NY");
            } 
            else if (tz.equals("America/Phoenix"))
            {
                userLocationLbl.setText("Phoenix, AZ");
            }
            else if (tz.equals("England/London"))
            {
                userLocationLbl.setText("London, England");
            }
        }
        
    }

}
