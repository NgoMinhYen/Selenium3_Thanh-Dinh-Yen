package dataobjects;

import java.util.Date;


public class Recruitment {
    private String firstName;
    private String middleName = "";
    private String lastName;

    private String fullName;

    private String  vacancy;
    private String  email;
    private String  contactNumber;
    private String  keywords;
    private Date    dateOfApplication;
    private String  notes;
    private Boolean consentToKeepData;

    public Recruitment() {
    }

    public Recruitment(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fullName = firstName + " " + middleName + " " + lastName;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getConsentToKeepData() {
        return consentToKeepData;
    }

    public void setConsentToKeepData(Boolean consentToKeepData) {
        this.consentToKeepData = consentToKeepData;
    }
}
