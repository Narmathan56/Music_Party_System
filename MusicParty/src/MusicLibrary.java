/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KETHEES
 */
import java.util.ArrayList;
public class MusicLibrary {
    
    private ArrayList<Song>songs;
    
    MusicLibrary(){
        songs=new ArrayList<>();
    
    }
    public void addSong(Song song){
        songs.add(song);
    
    }
    
    public ArrayList<Song> search(String title) { 
        ArrayList<Song> results = new ArrayList<>(); 
        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(s); 
            }
        }
        return results;
    }
}

