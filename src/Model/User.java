/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.OffsetDateTime;

/**
 * app user object class
 * @author scott
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private OffsetDateTime createDate;
    private String createdBy;
    private OffsetDateTime lastUpdate;
    private String lastUpdatedBy;

    /**
     * constructor
     * @param userId
     * @param userName
     * @param password
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     */
    public User(int userId, String userName, String password, OffsetDateTime createDate, String createdBy, OffsetDateTime lastUpdate, String lastUpdatedBy) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * constructor
     */
    public User() {
        this.userId = 0;
        this.userName = "";
        this.password = "";
        this.createDate = null;
        this.createdBy = "";
        this.lastUpdate = null;
        this.lastUpdatedBy = "";
    }

    /**
     * get user id
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * get user name
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get user pw
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * get user create date
     * @return the createDate
     */
    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    /**
     * get user creator
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * get last update date
     * @return the lastUpdate
     */
    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * get last updater
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * set user id
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * set username
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * set user pw
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * set user createdate
     * @param createDate the createDate to set
     */
    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * set user creator
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * set user last update
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * set user last updater
     * @param lastUpdatedBy the lastUpdatedBy to set
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    
    
    
    
}
