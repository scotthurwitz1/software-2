/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * setup for appointment objects
 * @author scott
 */
public class Appointment {
    private int id;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerId;
    private int userId;
    private int contactId;

    /**
     * constructor
     * @param id
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param userId
     * @param customerId
     * @param contactId
     */
    public Appointment(int id, String title, String description, String location, 
            String type, LocalDateTime start, LocalDateTime end, int userId, int customerId,  
            int contactId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.contactId = contactId;
        this.userId = userId;
    }

    /**
     * gets appt id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * gets appt title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * gets appt description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * gets appt location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * gets appt type
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * gets appt start time
     * @return the start
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * get appt end time
     * @return the end
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * @return the createDate
     */

    /**
     * get appt cust id
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * get appt user id
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * get appt contact id
     * @return the contactId
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * set appt title
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * set appt description
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * set appt location
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * set appt type
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * set appt start
     * @param start the start to set
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * set appt end time
     * @param end the end to set
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * set appt cust id
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * set appt user id
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * set appt contact id
     * @param contactId the contactId to set
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

}