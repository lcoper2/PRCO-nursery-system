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
public class RelationshipList {
    
    private ArrayList<Relationship> relationshipList;
    Relationship relationship = new Relationship();
    
    public RelationshipList(){
        relationshipList = new ArrayList<>();
    }

    public RelationshipList(ResultSet result) {
        relationshipList = new ArrayList<>();
        
        try{
            while (result.next()){
                relationship = new Relationship(Integer.parseInt(result.getString(1)),
                        Integer.parseInt(result.getString(2)),
                        Integer.parseInt(result.getString(3)),
                        result.getString(4), result.getString(5));
                relationshipList.add(relationship);
            }
        }
        catch (SQLException e){
            
        }
    }
    
    public String[] getAllRelationships(){
        String[] relationship = new String[relationshipList.size()];
            for (int i = 0; i < relationshipList.size(); i++){
                relationship[i] = relationshipList.get(i).getRelationshipID() + ": " +
                    relationshipList.get(i).getChildID() + " Relation: " +
                    relationshipList.get(i).getRelationToChild() + " Legal "
                        + "Contact: " + relationshipList.get(i).getLegalContact();
            }
        return relationship;
    }
    
    public Relationship getRelationshipAt(String index){
        int id = Integer.parseInt(index);
        
        for (int i = 0; i < relationshipList.size(); i++){
            if (relationshipList.get(i).getRelationshipID() == id){
                return relationshipList.get(i);
            }
        }
        return null;
    }
    
    public void addRelationship(Relationship newRelationship){
        relationshipList.add(newRelationship);
    }
    
    public Relationship removeRelationship(int index){
        Relationship check = null;
        
        if (index >= 0 && index < relationshipList.size()){
            check = relationshipList.remove(index);
        }
        return check;
    }
    
    public int size(){
        return relationshipList.size();
    }
    
    public ArrayList<Relationship> getRelationshipList(){
        return relationshipList;
    }
}
