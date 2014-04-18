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
public class RelativeList {
    private ArrayList<Relative> relativeList;
    Relative relative = new Relative();
    
    public RelativeList(){
        relativeList = new ArrayList<>();
    }

    public RelativeList(ResultSet result) {
        relativeList = new ArrayList<>();
        
        try{
            while (result.next()){
                relative = new Relative(Integer.parseInt(result.getString(1)),
                        result.getString(2), result.getString(3),
                        result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7),
                        result.getString(8), result.getString(9),
                        result.getString(10));
                relativeList.add(relative);
            }
        }
        catch (SQLException e){
            
        }
    }
    
    public String[] getAllRelatives(){
        String[] relatives = new String[relativeList.size()];
            for (int i = 0; i < relativeList.size(); i++){
                relatives[i] = relativeList.get(i).getRelativeID() + ": " +
                    relativeList.get(i).getFirstName() + " " +
                    relativeList.get(i).getSurname() + " Address: " +
                    relativeList.get(i).getAddressLine1();
            }
        return relatives;
    }
    
    public Relative getRelativeAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < relativeList.size(); i++){
            if (relativeList.get(i).getRelativeID() == id){
                return relativeList.get(i);
            }
        }
        return null;
    }
    
    public void addRelative(Relative newRelative){
        relativeList.add(newRelative);
    }
    
    public Relative removeRelative(int index){
        Relative check = null;
        
        if (index >= 0 && index < relativeList.size()){
            check = relativeList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return relativeList.size();
    }
    
    public ArrayList<Relative> getRelativeList(){
        return relativeList;
    }
}
