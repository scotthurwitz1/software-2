/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Appointment;
import Model.Customer;
import Model.Database;
import static Model.Database.clearAppointments;
import static Model.Database.clearCustomers;
import static Model.Database.getAllAppointments;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author scott
 */
public class AppointmentQuery {
    
    public static void appointmentsQuery() throws SQLException 
    {
        clearAppointments();
        
        String sql = "SELECT * FROM appointments";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            int id = rs.getInt("Appointment_ID");
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location = rs.getString("Location");
            String type = rs.getString("Type");
            LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
            LocalDateTime end = rs.getTimestamp("end").toLocalDateTime();
            int customerId = rs.getInt("Customer_ID");
            int contactId = rs.getInt("User_ID");
            int userId = rs.getInt("Contact_ID");
            
            Appointment appointment = new Appointment(id, title, description, location
                    , type, start, end, customerId, contactId, userId);
            Database.addAppointment(appointment);
        }
        
    }
    
}
