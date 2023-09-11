/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * class for contact objects
 * @author scott
 */
public class Contact {
    private int contactId;
    private String contactName;
    private String email;

    /**
     * constructor
     * @param contactId
     * @param contactName
     * @param email
     */
    public Contact(int contactId, String contactName, String email) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.email = email;
    }

    /**
     * get contact id
     * @return the contactId
     */
    public int getContactId() {
        return contactId;
    }

    /**
     * get contact name
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * get contact email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set contact id
     * @param contactId the contactId to set
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    /**
     * set contact name
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * set contact email
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
