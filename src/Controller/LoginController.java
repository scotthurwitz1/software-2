package Controller;

import Helper.util;
import dao.LoginQuery;
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
import static Helper.util.Warning;
import Model.Appointment;
import static Model.Database.getAllAppointments;
import Model.User;
import java.time.LocalDateTime;

public class LoginController implements Initializable {
    public static User current_user = new User(); 
    
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
        boolean appts = false;
        if (LoginQuery.selectLoginCreds( usernameTxt.getText(), passwordTxt.getText()))
        {
            switcher.screen("/View/MainMenu.fxml", event);
            for (Appointment appt: getAllAppointments())
            {
                if (appt.getUserId() == current_user.getUserId())
                {
                     LocalDateTime apptStart = appt.getStart();
                     LocalDateTime now = LocalDateTime.now();
                     LocalDateTime future = now.plusMinutes(15);
                     
                     if (!apptStart.isBefore(now)&& !apptStart.isAfter(future))
                     {
                         Warning("Appointment #" + appt.getId() + " is on " + appt.getStart().toLocalDate()
                         + " at " + appt.getStart().toLocalTime());
                         appts = true;
                     } 
                } 
            }
        }
        if (appts == false) {
            Warning("User " + current_user.getUserName() + " has no appointments right now.");
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
                userLocationLbl.setText("White Plains, NY");
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
