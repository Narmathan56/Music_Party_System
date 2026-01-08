/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KETHEES
 */
//import the Arraylist
import java.util.ArrayList;
public class PlayListCollection {
    private ArrayList<PlayList>playLists;
    
  //we creates the constractor and intilize the instance variable  
   public PlayListCollection(){
       playLists=new ArrayList<>();
   }  
   
   public void addPlayList(String name){
       playLists.add(new PlayList(name));
   }
   public void removePlayList(int index){
       if(index>=0 && index< playLists.size()){
           playLists.remove(index);
       }
   }
   
   public void duplicatePlayList(String name, int index){
       
       if(index>=0 && index<playLists.size()){
           PlayList original=playLists.get(index);
           PlayList copy = new PlayList(name);
           for(Song s:original.getTrackList()){
               copy.addSong(s);
           }
           playLists.add(copy);
           
           
       
       
       
       }
   }
    public ArrayList<PlayList>getPlayLists(){
        return playLists;
    
        
    }
    public PlayList getPlayList(int index){
        return playLists.get(index);
    
    }
    
    @Override
    public String toString(){
    
        String result = ""; 
        for (int i = 0; i < playLists.size(); i++) {
           
            result += (i + 1) + ". " + playLists.get(i).toString() + "\n";
        }
        return result;
    }
    
    }
    
    
   
   
   
   
   
   
   
    
    

