/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class Staff {
    public int staffID;
    public String firstName;
    public String surname;
    public String dateOfBirth;
    public String addressLine1;
    public String addressLine2;
    public String postCode;
    public String contactNumber;
    public String mobileNumber;
    public String medicalConditions;
    public String dietaryNeeds;
    public String username;
    public String password;
    
    public Staff(){
        staffID = 0;
        firstName = "";
        surname = "";
        dateOfBirth = "";
        addressLine1 = "";
        addressLine2 = "";
        postCode = "";
        contactNumber = "";
        mobileNumber = "";
        medicalConditions = "";
        dietaryNeeds = "";
        username = "";
        password = "";
    }

    public Staff(int staffID, String firstName, String surname, 
            String dateOfBirth, String addressLine1, String addressLine2, 
            String postCode, String contactNumber, String mobileNumber, 
            String medicalConditions, String dietaryNeeds, String username, 
            String password) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postCode = postCode;
        this.contactNumber = contactNumber;
        this.mobileNumber = mobileNumber;
        this.medicalConditions = medicalConditions;
        this.dietaryNeeds = dietaryNeeds;
        this.username = username;
        this.password = password;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getDietaryNeeds() {
        return dietaryNeeds;
    }

    public void setDietaryNeeds(String dietaryNeeds) {
        this.dietaryNeeds = dietaryNeeds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
