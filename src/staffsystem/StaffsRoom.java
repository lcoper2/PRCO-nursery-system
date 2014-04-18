/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class StaffsRoom {
    public int staffsRoomID;
    public int staffID;
    public int roomID;
    
    public StaffsRoom(){
        staffsRoomID = 0;
        staffID = 0;
        roomID = 0;
    }

    public StaffsRoom(int staffsRoomID, int staffID, int roomID) {
        this.staffsRoomID = staffsRoomID;
        this.staffID = staffID;
        this.roomID = roomID;
    }

    public int getStaffsRoomID() {
        return staffsRoomID;
    }

    public void setStaffsRoomID(int staffsRoomID) {
        this.staffsRoomID = staffsRoomID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    
}
