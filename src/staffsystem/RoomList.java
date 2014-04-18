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
public class RoomList {
    private ArrayList<Room> roomList;
    Room Room;
    
    public RoomList(){
       roomList = new ArrayList<>(); 
       Room = new Room();
    }
    
    public RoomList(ResultSet rs){
       roomList = new ArrayList<>();
       
       try {
                while (rs.next()) {
                    Room = new Room(Integer.parseInt(rs.getString(1)),
                            rs.getString(2),rs.getString(3),rs.getString(4)
                            ,rs.getString(5),rs.getString(6));
                    roomList.add(Room);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    public void addRoom(Room newRoom){
        roomList.add(newRoom);
    }
    
    public Room getRoomAt(String index) {
        int thisID = Integer.parseInt(index);

        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomID() == thisID) {
                return roomList.get(i);
            }

        }
        return null;
    }
    
    public Room removeRoomAt(int index){
        Room result = null;
        if (index >= 0 && index < roomList.size()){
            result = roomList.remove(index);
        }
        return result;
    }
    
    public String[] getAllRooms(){
        String[] rooms = new String[roomList.size()];
        for (int i = 0; i < roomList.size(); i++) {
            rooms[i] = roomList.get(i).getRoomID() + ", Room Name: " +
                         roomList.get(i).getRoomName() + ", Age Min: " +
                         roomList.get(i).getAgeMin() + ", Age Max: " +
                         roomList.get(i).getAgeMax();
        }
        return rooms;
    }
   
    public int size(){
        return roomList.size();
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }
}
