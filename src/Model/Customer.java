/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.OffsetDateTime;

/**
 * customer objects class
 * @author scott
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private String postalCode;
    private String phone;
    private OffsetDateTime createDate;
    private String createdBy;
    private OffsetDateTime lastUpdate;
    private String lastUpdatedBy;
    private int divisionId;
    private String divisionName;

    /**
     * constructor
     * @param customerId
     * @param customerName
     * @param address
     * @param postalCode
     * @param phone
     * @param divisionId
     * @param divisionName
     */
    public Customer(int customerId, String customerName, String address, String postalCode, String phone, int divisionId, String divisionName) {
        this.id = customerId;
        this.name = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.divisionId = divisionId;
        this.divisionName = divisionName;

    }

    /**
     * get customer id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * get customer name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * get customer address
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * get customer postal code
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * get customer phone
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * get customer state id
     * @return the divisionName
     */
    public int getDivisionId() {
        return divisionId;
    }
    
    /**
     * get customer state
     * @return the divisionName
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * set customer id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * customer set name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set customer address
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * set customer postal code
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * set customer phone
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * set customer state
     * @param divisionName the divisionName to set
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    
}
