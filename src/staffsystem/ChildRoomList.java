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
public class ChildRoomList {
    
    DBConnection connect;
    private ArrayList<ChildRoom> childRoomList;
    ChildRoom childRoom;
    RoomList roomList;
    ArrayList<String> list;
    Room room;
    
    public ChildRoomList(){
        childRoomList = new ArrayList<>();
        connect = new DBConnection();
    }

    public ChildRoomList(ResultSet result) {
        childRoomList = new ArrayList<>();
        connect = new DBConnection();
        
        try{
            while (result.next()){
                childRoom = new ChildRoom(Integer.parseInt(result.getString(1)),
                        Integer.parseInt(result.getString(2)),
                        Integer.parseInt(result.getString(3)));
                childRoomList.add(childRoom);
            }
        }
        catch (SQLException e){
            
        }
    }
    
    public ArrayList<String> getChildRoomNames(int id) throws SQLException{
        roomList = this.connect.viewAllRooms();
        
        for(ChildRoom cr: childRoomList){
            if(cr.getChildID() == id){
                String stringID = cr.getRoomID() + "";
                room = roomList.getRoomAt(stringID);
                list.add(room.getRoomName());
            }
            
        }
        
        return list; 
        
    }
    
    public String[] getAllChildRooms(){
        String[] childRooms = new String[childRoomList.size()];
            for (int i = 0; i < childRoomList.size(); i++){
                childRooms[i] = childRoomList.get(i).getChildRoomID() + ": " +
                childRoomList.get(i).getChildID() + " " +
                childRoomList.get(i).getRoomID();
                
            }
        return childRooms;
    }
    
    public ChildRoom getChildRoomAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < childRoomList.size(); i++){
            if (childRoomList.get(i).getChildRoomID() == id){
                return childRoomList.get(i);
            }
        }
        return null;
    }
    
    public void addChildRoom(ChildRoom newChildRoom){
        childRoomList.add(newChildRoom);
    }
    
    public ChildRoom removeChildRoom(int index){
        ChildRoom check = null;
        
        if (index >= 0 && index < childRoomList.size()){
            check = childRoomList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return childRoomList.size();
    }
    
    public ArrayList<ChildRoom> getChildRoomList(){
        return childRoomList;
    }
}
