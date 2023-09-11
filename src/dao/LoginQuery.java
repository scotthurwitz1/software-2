/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Controller.LoginController;
import static Controller.LoginController.current_user;
import Helper.util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * query for logging in to app
 * @author scott
 */
public abstract class LoginQuery {
    
    /**
     * query takes username and password and verifies it
     * @param userId
     * @param password
     * @return
     * @throws SQLException
     */
    public static boolean selectLoginCreds(String userId, String password) throws SQLException {
        
    String sql = "SELECT * FROM USERS WHERE USER_NAME = ? AND PASSWORD = ?";
    PreparedStatement ps = JDBC.connection.prepareStatement(sql);
    ps.setString(1, userId);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();


    if (Locale.getDefault().getLanguage().equals("fr"))
    {
        if (!rs.isBeforeFirst()) 
        {   
            util.alertFR("Identifiant ou mot de passe incorrect");
            return false;
        } 
        else 
        {
            System.out.println("Utilisateur trouvé");
            return true;
        }
    }
    else {
    if (!rs.isBeforeFirst()) 
        {    
           util.Error("Incorrect username or password");
           return false;
        } 
    else 
        {
            rs.next();
            System.out.println("User found");
            current_user.setUserId(rs.getInt(1));
            current_user.setUserName(rs.getString(2));
            return true;
        }
    }
    
}}
    




