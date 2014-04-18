/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class Relationship {
    public int relationshipID;
    public int childID;
    public int relativeID;
    public String relationToChild;
    public String legalContact;

    public Relationship(){
        relationshipID = 0;
        childID = 0;
        relativeID = 0;
        relationToChild = "";
        legalContact = "";
    }
    
    public Relationship(int relationshipID, int childID, int relativeID, 
            String relationToChild, String legalContact) {
        this.relationshipID = relationshipID;
        this.childID = childID;
        this.relativeID = relativeID;
        this.relationToChild = relationToChild;
        this.legalContact = legalContact;
    }

    public int getRelationshipID() {
        return relationshipID;
    }

    public void setRelationshipID(int relationshipID) {
        this.relationshipID = relationshipID;
    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public int getRelativeID() {
        return relativeID;
    }

    public void setRelativeID(int relativeID) {
        this.relativeID = relativeID;
    }

    public String getRelationToChild() {
        return relationToChild;
    }

    public void setRelationToChild(String relationToChild) {
        this.relationToChild = relationToChild;
    }

    public String getLegalContact() {
        return legalContact;
    }

    public void setLegalContact(String legalContact) {
        this.legalContact = legalContact;
    }
    
}
