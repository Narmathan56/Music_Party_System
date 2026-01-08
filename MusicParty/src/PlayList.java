/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KETHEES
 */
import java.util.ArrayList;
public class PlayList {
    private String name;
    private  ArrayList <Song> tracks;
    
//we didn't put the Arrylist into the scope. cause playlist is like container. when we create that. it should always has emptly list of song.
// if we put the arraylist  into that, playlist sharing the same song between another playlist.    
    public PlayList(String name){
        this.name=name;
        this.tracks= new ArrayList<>();
        
    }
    // we encapsulation with "getter and setter" methode.
    public String getName(){
        return name;
        
    }
    
    
    //adding song
    // here we use methode overloading concept. same methode but different parameters.
    public  void addSong(Song song){
        tracks.add(song);
    }
    // adding song in specific postion in list
    //this add song use to insert the song into define position
    public void addSong(Song song, int position){
        if(position>=0 && position<=tracks.size()){
            tracks.add(position ,song);
        }
        else{
            System.out.println("Selection is incorrect");
        
        }
    }
    
    // remove the song in specific postion in Song list
    public void removeSong(int position){
        if(position>=0 && position< tracks.size()){
            tracks.remove(position);
        }
    }        
    
    // rename playlist
    public void rename(String name){
        if(name!=null && !name.trim().isEmpty()){
            this.name=name;
        }
        else{
            System.out.println("name is invalid!");
        }
    }
    //reOrder the song in specific playlist.
    //as you can see we pass two parameters such as fromPosition,toPosition and we use the conditoion
    public void moveSong(int fromPosition, int toPosition){
        if(fromPosition>=0 && fromPosition<tracks.size()&& toPosition>=0 &&toPosition<tracks.size()){
            Song s = tracks.remove(fromPosition);
            tracks.add(toPosition, s);
        }
        
    }
    // gerRunTime methode. here we takes total runtime with access the getRuntime methode
    // This is example of composition and delegation.
    public int getRunTime() {
        int total = 0;
        for (Song s : tracks) {
            total += s.getRunTime();
        }
        return total;
    }
    //getTrackList
    public ArrayList<Song>getTrackList(){
        return tracks;
        
    }
    // Java has default toString methode. if we are going to use the toString methode we must do the override. orelse. when we print the object, we will get the hashcode instead of actual output
    @Override
    public String toString(){
        return name+" Total Runtime: "+ getRunTime()+ "Seconds";
    }
    
    
            
    
}
