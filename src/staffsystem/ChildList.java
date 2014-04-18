/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package staffsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lewis
 */
public class ChildList {
    
    private ArrayList<Child> childList;
    Child child = new Child();
    
    public ChildList(){
        childList = new ArrayList<>();
    }

    public ChildList(ResultSet result) {
        childList = new ArrayList<>();
        
        try{
            while (result.next()){
                child = new Child(Integer.parseInt(result.getString(1)),
                        result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5),
                        result.getString(6),
                        Integer.parseInt(result.getString(7)),
                        result.getString(8), result.getString(9),
                        result.getString(10), result.getString(11),
                        result.getString(12), result.getString(13),
                        result.getString(14));
                childList.add(child);
            }
        }
        catch (SQLException e){
                System.out.println(e);
        }
    }
    
    public String[] getAllChildren(){
        String[] children = new String[childList.size()];
            for (int i = 0; i < childList.size(); i++){
                children[i] = childList.get(i).getChildID() + ": " +
                    childList.get(i).getFirstName() + " " +
                    childList.get(i).getSurname() + " DOB: " +
                    childList.get(i).getDateOfBirth();
            }
        return children;
    }
    
    public Child getChildAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < childList.size(); i++){
            if (childList.get(i).getChildID() == id){
                return childList.get(i);
            }
        }
        return null;
    }
    
    public void addChild(Child newChild){
        childList.add(newChild);
    }
    
    public Child removeChild(int index){
        Child check = null;
        
        if (index >= 0 && index < childList.size()){
            check = childList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return childList.size();
    }
    
    public ArrayList<Child> getChildList(){
        return childList;
    }
}
