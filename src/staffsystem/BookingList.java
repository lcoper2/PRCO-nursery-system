/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lewis
 */
public class BookingList {
    private ArrayList<Booking> bookingList;
    Booking booking = new Booking();
    
    public BookingList(){
        bookingList = new ArrayList<>();
    }
    
    public BookingList(ResultSet result){
        bookingList = new ArrayList<>();
        
        try{
            while (result.next()){
                booking = new Booking(Integer.parseInt(result.getString(1)),
                        Integer.parseInt(result.getString(2)),
                        Integer.parseInt(result.getString(3)),
                        result.getString(4), result.getString(5),
                        result.getString(6));
                bookingList.add(booking);
            }
        }
        catch (SQLException e){
            
        }
    }
    
    public String[] getAllBookings(){
        String[] bookings = new String[bookingList.size()];

            for (int i = 0; i < bookingList.size(); i++){
                bookings[i] = bookingList.get(i).getBookingIDAsString() + ": Child: " +
                        bookingList.get(i).getChildIDAsString() + " Room: " +
                        bookingList.get(i).getRoomIDAsString() + " Date: " +
                        bookingList.get(i).getDate() + " Session: " +
                        bookingList.get(i).getSession();
            }
        return bookings;
    }
    
    public Booking getBookingAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < bookingList.size(); i++){
            if (bookingList.get(i).getBookingID() == id){
                return bookingList.get(i);
            }
        }
        return null;
    }
    
    public void addBooking(Booking newBooking){
        bookingList.add(newBooking);
    }
    
    public Booking removeBooking(int index){
        Booking check = null;
        
        if (index >= 0 && index < bookingList.size()){
            check = bookingList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return bookingList.size();
    }
    
    public ArrayList<Booking> getBookingList(){
        return bookingList;
    }
}
