/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

/**
 *
 * @author Markus
 */
public abstract class Player {
    private String name;
    private int markörID;
    
  
    String getName(){
    return name;
    }
   
    void setName(String name){
      this.name = name;
    
    }
    
    /**
    * getMove returnerar draget som spelaren vill göra 
    * 
    */
     String getMove(){
    return name;
    }
}
