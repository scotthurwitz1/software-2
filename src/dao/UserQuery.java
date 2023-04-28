/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Helper.util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author scott
 */
public abstract class UserQuery {
    
//    public static int insert(String fruitName, int colorId) throws SQLException {
//
//        String sql = "INSERT INTO FRUITS (Fruit_Name, Color_ID) VALUES(?, ?)";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setString(1, fruitName);
//        ps.setInt(2, colorId);
//        int rowsAffected = ps.executeUpdate();
//        return rowsAffected;
//
//    }
//    public static int update(int fruitId, String fruitName) throws SQLException {
//        String sql = "UPDATE FRUITS SET Fruit_Name = ? WHERE Fruit_Id = ?";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setString(1, fruitName);
//        ps.setInt(2, fruitId);
//        int rowsAffected = ps.executeUpdate();
//        return rowsAffected;
//    }
//
//    public static int delete(int fruitId) throws SQLException {
//        String sql = "DELETE FROM USERS WHERE Fruit_ID = ?";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setInt(1, fruitId);
//        int rowsAffected = ps.executeUpdate();
//        return rowsAffected;
//    }

//    public static void select() throws SQLException {
//        String sql = "SELECT * FROM USERS";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            int fruitId = rs.getInt("Fruit_ID");
//            String fruitName = rs.getString("Fruit_Name");
//            System.out.print(fruitId + " | ");
//            System.out.print(fruitName + "\n");
//        }
//    }
//
//    public static void select(int colorId) throws SQLException {
//        String sql = "SELECT * FROM FRUITS WHERE COLOR_ID = ?";
//        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//        ps.setInt(1, colorId);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            int fruitId = rs.getInt("Fruit_ID");
//            String fruitName = rs.getString("Fruit_Name");
//            int colorId1 = rs.getInt("Color_ID");
//            System.out.print(fruitId + " | ");
//            System.out.print(fruitName + " | ");
//            System.out.print(colorId1 + "\n");
//        }
//    }
//    


public static boolean selectLoginCreds(String userId, String password) throws SQLException {
        String sql = "SELECT * FROM USERS WHERE USER_NAME = ? AND PASSWORD = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, userId);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (!rs.isBeforeFirst()) 
            {    
               util.Alert("Incorrect username or password");
               return false;
            } 
        else 
            {
                System.out.println("User found");
                return true;
            }
        }

}

