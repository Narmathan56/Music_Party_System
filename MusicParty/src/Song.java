/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KETHEES
 */
// we creates the song class for create object.
// here title,artist, runTime these are called "instance variable".
public class Song {
    private String title;
    private String artist;
    private int runTime;
    
 // we creates the constractor to initilize the instance variable.
    //constractor uses for check the standards and offers the professtion code
    public Song(String title,String artist,int runTime){
        this.artist=artist;
        this.title=title;
        this.runTime=runTime;
                
    }
    
    // this is called"getter methode" for encapsulation
    public String getTitle(){
        return title;
        
    }
    
    public String getArtist(){
        return artist;
    }
    
    public int getRunTime(){
        return runTime;
    }
    
    
 
    @Override
    public String toString(){
        return "title:"+title+", Artist:"+artist+", runTime:"+runTime+"sec";
        
        
    }
    
    
    
}
