/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

/**
 *
 * @author Lewis
 */
public class Booking {
    public int bookingID;
    public int childID;
    public int roomID;
    public String date;
    public String session;
    public String notes;
    private String stringID;
    
    public Booking(){
        this.bookingID = 0;
        this.childID = 0;
        this.roomID = 0;
        this.date = "";
        this.session = "";
        this.notes = "";
    }
    
    public Booking(int bookingID, int childID, int roomID, String date,
            String session, String notes){
        this.bookingID = bookingID;
        this.childID = childID;
        this.roomID = roomID;
        this.date = date;
        this.session = session;
        this.notes = notes;
    }

    public int getBookingID() {
        return bookingID;
    }
    
    public String getBookingIDAsString(){
        stringID = Integer.toString(getBookingID());
        return stringID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getChildID() {
        return childID;
    }
    
    public String getChildIDAsString(){
        stringID = Integer.toString(getChildID());
        return stringID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public int getRoomID() {
        return roomID;
    }
    
    public String getRoomIDAsString(){
        stringID = Integer.toString(getRoomID());
        return stringID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
