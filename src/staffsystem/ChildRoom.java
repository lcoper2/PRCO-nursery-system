/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class ChildRoom {
    public int childRoomID;
    public int childID;
    public int roomID;
    
    public ChildRoom(){
        childRoomID = 0;
        childID = 0;
        roomID = 0;
    }
    
    public ChildRoom(int childRoomID, int childID, int roomID){
        this.childRoomID = childRoomID;
        this.childID = childID;
        this.roomID = roomID;
    }

    public int getChildRoomID() {
        return childRoomID;
    }

    public void setChildRoomID(int childRoomID) {
        this.childRoomID = childRoomID;
    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
