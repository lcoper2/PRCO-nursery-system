package staffsystem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lewis
 */
public class Room {
    public int roomID;
    public String roomName;
    public String ageMin;
    public String ageMax;
    public String staffToChildRatio;
    public String maxNumChildren;

    public Room(){
        roomID = 0;
        roomName = "";
        ageMin = "";
        ageMax = "";
        staffToChildRatio = "";
        maxNumChildren = "";
    }
    
    public Room(int roomID, String roomName, String ageMin, String ageMax, 
            String staffToChildRatio, String maxNumChildren) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.staffToChildRatio = staffToChildRatio;
        this.maxNumChildren = maxNumChildren;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(String ageMin) {
        this.ageMin = ageMin;
    }

    public String getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(String ageMax) {
        this.ageMax = ageMax;
    }

    public String getStaffToChildRatio() {
        return staffToChildRatio;
    }

    public void setStaffToChildRatio(String staffToChildRatio) {
        this.staffToChildRatio = staffToChildRatio;
    }

    public String getMaxNumChildren() {
        return maxNumChildren;
    }

    public void setMaxNumChildren(String maxNumChildren) {
        this.maxNumChildren = maxNumChildren;
    }
    
}
