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
public class StaffsRoomList {
    
    private ArrayList<StaffsRoom> staffRoomList;
    StaffsRoom staffRoom = new StaffsRoom();
    
    public StaffsRoomList(){
        staffRoomList = new ArrayList<>();
    }

    public StaffsRoomList(ResultSet result) {
        staffRoomList = new ArrayList<>();
        
        try{
            while (result.next()){
                staffRoom = new StaffsRoom(Integer.parseInt(result.getString(1)),
                        Integer.parseInt(result.getString(2)),
                        Integer.parseInt(result.getString(3)));
                staffRoomList.add(staffRoom);
            }
        }
        catch (SQLException e){
            
        }
    }
    
    public String[] getAllStaffRoom(){
        String[] staffRoom = new String[staffRoomList.size()];
            for (int i = 0; i < staffRoomList.size(); i++){
                staffRoom[i] = staffRoomList.get(i).getStaffsRoomID() + ": " +
                    staffRoomList.get(i).getStaffID() + " " +
                    staffRoomList.get(i).getRoomID();
            }
        return staffRoom;
    }
    
    public StaffsRoom getStaffRoomAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < staffRoomList.size(); i++){
            if (staffRoomList.get(i).getStaffsRoomID() == id){
                return staffRoomList.get(i);
            }
        }
        return null;
    }
    
    public void addStaffRoom(StaffsRoom newStaffRoom){
        staffRoomList.add(newStaffRoom);
    }
    
    public StaffsRoom removeStaffRoom(int index){
        StaffsRoom check = null;
        
        if (index >= 0 && index < staffRoomList.size()){
            check = staffRoomList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return staffRoomList.size();
    }
    
    public ArrayList<StaffsRoom> getStaffRoomList(){
        return staffRoomList;
    }
}
