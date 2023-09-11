/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.OffsetDateTime;

/**
 * class to set up country objects
 * @author scott
 */
public class Country {
    private int countryId;
    private String country;
    private OffsetDateTime createDate;
    private String createdBy;
    private OffsetDateTime lastUpdate;
    private String lastUpdatedBy;

    /**
     * constructor
     * @param countryId
     * @param country
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     */
    public Country(int countryId, String country, OffsetDateTime createDate, String createdBy, OffsetDateTime lastUpdate, String lastUpdatedBy) {
        this.countryId = countryId;
        this.country = country;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * get country id
     * @return the countryId
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * get country name
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * get country create date
     * @return the createDate
     */
    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    /**
     * get country creator
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * get country last update
     * @return the lastUpdate
     */
    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * get country's last updater
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * set country id
     * @param countryId the countryId to set
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * set country name
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * set country's start date
     * @param createDate the createDate to set
     */
    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * set country adder 
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * set country update time
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * set country updater
     * @param lastUpdatedBy the lastUpdatedBy to set
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

}
