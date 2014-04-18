/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class Child {
    public int childID;
    public String firstName;
    public String surname;
    public String knownAs;
    public String sex;
    public String dateOfBirth;
    public int positionInFamily;
    public String religion;
    public String ethnicOrigin;
    public String languagesSpoken;
    public String medicalConditions;
    public String immunisations;
    public String dietaryNeeds;
    public String notes;
    private String position;
    
    public Child(){
        childID = 0;
        firstName = "";
        surname = "";
        knownAs = "";
        sex = "";
        dateOfBirth = "";
        positionInFamily = 0;
        religion = "";
        ethnicOrigin = "";
        languagesSpoken = "";
        medicalConditions = "";
        immunisations = "";
        dietaryNeeds = "";
        notes = "";
    }
    
    public Child(int childID, String firstName, String surname, String knownAs,
            String sex, String dateOfBirth, int positionInFamily,
            String religion, String ethnicOrigin, String languagesSpoken,
            String medicalConditions, String immunisations, String dietaryNeeds,
            String notes){
        
        this.childID = childID;
        this.firstName = firstName;
        this.surname = surname;
        this.knownAs = knownAs;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.positionInFamily = positionInFamily;
        this.religion = religion;
        this.ethnicOrigin = ethnicOrigin;
        this.languagesSpoken = languagesSpoken;
        this.medicalConditions = medicalConditions;
        this.immunisations = immunisations;
        this.dietaryNeeds = dietaryNeeds;
        this.notes = notes;
    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
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

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPositionInFamily() {
        return positionInFamily;
    }
    
    public String getPositionAsString(){
        position = Integer.toString(getPositionInFamily());
        return position;
    }

    public void setPositionInFamily(int positionInFamily) {
        this.positionInFamily = positionInFamily;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEthnicOrigin() {
        return ethnicOrigin;
    }

    public void setEthnicOrigin(String ethnicOrigin) {
        this.ethnicOrigin = ethnicOrigin;
    }

    public String getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(String languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getImmunisations() {
        return immunisations;
    }

    public void setImmunisations(String immunisations) {
        this.immunisations = immunisations;
    }

    public String getDietaryNeeds() {
        return dietaryNeeds;
    }

    public void setDietaryNeeds(String dietaryNeeds) {
        this.dietaryNeeds = dietaryNeeds;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
