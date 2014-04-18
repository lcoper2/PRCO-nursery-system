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
public class StaffList {
 
    private ArrayList<Staff> staffList;
    Staff staff = new Staff();
    
    public StaffList(){
        staffList = new ArrayList<>();
    }

    public StaffList(ResultSet result) {
        staffList = new ArrayList<>();
        
        try{
            while (result.next()){
                staff = new Staff(Integer.parseInt(result.getString(1)),
                        result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8), result.getString(9),
                        result.getString(10), result.getString(11),
                        result.getString(12), result.getString(13));
                staffList.add(staff);
            }
        }
        catch (SQLException e){
            
        }
    }
    
    public String[] getAllStaff(){
        String[] allStaffList = new String[staffList.size()];
            for (int i = 0; i < staffList.size(); i++){
                allStaffList[i] = staffList.get(i).getStaffID() + ": " +
                    staffList.get(i).getFirstName() + " " +
                    staffList.get(i).getSurname();
            }
        return allStaffList;
    }
    
    public Staff getStaffAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < staffList.size(); i++){
            if (staffList.get(i).getStaffID() == id){
                return staffList.get(i);
            }
        }
        return null;
    }
    
    public void addStaff(Staff newStaff){
        staffList.add(newStaff);
    }
    
    public Staff removeStaff(int index){
        Staff check = null;
        
        if (index >= 0 && index < staffList.size()){
            check = staffList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return staffList.size();
    }
    
    public ArrayList<Staff> getStaffList(){
        return staffList;
    }
}
