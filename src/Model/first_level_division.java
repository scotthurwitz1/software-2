/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.OffsetDateTime;

/**
 * class for state details
 * @author scott
 */
public class first_level_division {
    private int divisionId;
    private String Division;
    private OffsetDateTime createDate;
    private String createdBy;
    private OffsetDateTime lastUpdate;
    private String lastUpdatedBy;
    private String countryId;

    /**
     * constructor
     * @param divisionId
     * @param Division
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     * @param countryId
     */
    public first_level_division(int divisionId, String Division, OffsetDateTime createDate, String createdBy, OffsetDateTime lastUpdate, String lastUpdatedBy, String countryId) {
        this.divisionId = divisionId;
        this.Division = Division;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.countryId = countryId;
    }

    /**
     * get div id
     * @return the divisionId
     */
    public int getDivisionId() {
        return divisionId;
    }

    /**
     * get div name
     * @return the Division
     */
    public String getDivision() {
        return Division;
    }

    /**
     * get div create date
     * @return the createDate
     */
    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    /**
     * get div creator
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * get div last update
     * @return the lastUpdate
     */
    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * get div last updater
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * get div country
     * @return the countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * set div id
     * @param divisionId the divisionId to set
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * set div name
     * @param Division the Division to set
     */
    public void setDivision(String Division) {
        this.Division = Division;
    }

    /**
     * set div created
     * @param createDate the createDate to set
     */
    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * set div creator
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * set div updated
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * set div updater
     * @param lastUpdatedBy the lastUpdatedBy to set
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * set div country
     * @param countryId the countryId to set
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }


}
