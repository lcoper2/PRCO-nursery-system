/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class Relative {
    public int relativeID;
    public String firstName;
    public String surname;
    public String addressLine1;
    public String addressLine2;
    public String postCode;
    public String contactNumber;
    public String mobileNumber;
    public String emailAddress;
    public String password;
    
    public Relative(){
        relativeID = 0;
        firstName = "";
        surname = "";
        addressLine1 = "";
        addressLine2 = "";
        postCode = "";
        contactNumber = "";
        mobileNumber = "";
        emailAddress = "";
        password = "";
    }

    public Relative(int relativeID, String firstName, String surname, 
            String addressLine1, String addressLine2, String postCode, 
            String contactNumber, String mobileNumber, String emailAddress, 
            String password) {
        this.relativeID = relativeID;
        this.firstName = firstName;
        this.surname = surname;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postCode = postCode;
        this.contactNumber = contactNumber;
        this.mobileNumber = mobileNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getRelativeID() {
        return relativeID;
    }

    public void setRelativeID(int relativeID) {
        this.relativeID = relativeID;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
