/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KETHEES
 */
import java.util.Scanner;
import java.util.ArrayList;
//add playlist ***

public class MusicParty {
    
    public static void main(String[]args){
        MusicLibrary library=new MusicLibrary();
        
        library.addSong(new Song("Decades (2007 Remaster)","Joy Division",374));        //1
        library.addSong(new Song("Lets Stay Together","Al Green",199));                 //2
        library.addSong(new Song("Jump For Joy","New York Trio",286));                  //3
        library.addSong(new Song("Victims Of The Revolution","Bad Religion",197));      //4
        library.addSong(new Song("Unstable Condition","John Tejada",348));              //5
        library.addSong(new Song("Ocean Front Property","George Strait ",197));         //6
        library.addSong(new Song("Negai (Album-Mix) ","Perfume",298));                  //7
        library.addSong(new Song("A Little Bit More","Jamie Lidell",186));              //8
        library.addSong(new Song("Good Position ","Yin Yoga Academy",219));             //9
        library.addSong(new Song("Weekend ","Kane Brown",226));                         //10
        library.addSong(new Song("Oh Industry","Bette Midler",244));                    //11
        library.addSong(new Song("Weekend Story","Paragraph270",184));                  //12
        library.addSong(new Song("Love Strings","Mask Of The Wolf",254));               //13
        library.addSong(new Song("Straight Lines ","Silverchair ",257));                //14
        library.addSong(new Song("There’s No Solution","Sum 41",198));                  //15
        library.addSong(new Song("Continent perdu","Khunta & Sixko",281));              //16
        library.addSong(new Song("Rockall (Live)","Molecule",456));                     //17 
        library.addSong(new Song("Position (Live)","Hot Water Music",269));             //18
        library.addSong(new Song("Looking Blindly","Lack Of Interest",44));             //19
        library.addSong(new Song("Gorgeous","Property Prophets",262));                  //20
        
        
        PlayListCollection Collection=new PlayListCollection();
        
        
        Scanner reader = new Scanner(System.in);
        int choice=0;
        
        while (choice != 5) {
            System.out.println("Welcome to the Music Party");
            System.out.println("\n--- Music Party Main Menu ---");
            System.out.println("1. List play-lists");
            System.out.println("2. Add play-list");
            System.out.println("3. Update play-list");
            System.out.println("4. Delete play-list");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            
            
           if(reader.hasNextInt()){ // this ensure is that number. source: https://www.geeksforgeeks.org/java/scanner-hasnextint-method-in-java-with-examples/
               choice=reader.nextInt();//we assigned the values to choice
               reader.nextLine();
               
               switch(choice){
                   case 1:
                     // this is code for list the collection  
                     System.out.println(" This is list of collection");
                     System.out.println(Collection.getPlayLists());
                     break;
                   case 2:
                       System.out.println("Enter the name of the playList:");
                       String newName=reader.nextLine();
                       System.out.println("1. Empty playList \n2. Copy Exisisting PlayList");
                       System.out.println("Enter Choice:");
                       int selection=reader.nextInt();
                       reader.nextLine(); // Clear buffer
                       
                       if (selection == 1) {
                          Collection.addPlayList(newName);
                          System.out.println("PlayList adding.........................");
                          System.out.println("PlayList Added successfully!");
            }      
                       else if (selection == 2) {
                          System.out.println(Collection.toString());
                          System.out.print("Enter number of playlist to copy: ");
                          int userChoice=reader.nextInt();
                          int copyIndex = userChoice - 1; // User enters 1, we use 0 for select right index because we use ArrayList here
                          reader.nextLine();
                          if (copyIndex >= 0 && copyIndex < Collection.getPlayLists().size()) {
                             Collection.duplicatePlayList(newName, copyIndex);
                             System.out.println("Playlist duplicated successfully.");
             } 
                          else {
                             System.out.println("Error: Playlist number " + userChoice + " does not exist.");
    }
            }
                       
                        break;
                        
                           
                       
                   case 3:
                       
                       // Display numbered list of play-lists
                       System.out.println("\n--- Select a Play-list to Update ---");
                       System.out.print(Collection.toString());
                       System.out.print("Enter number of play-list: ");
    
                       int playlistIndex = reader.nextInt() - 1; // Adjust for 0-based index
                       reader.nextLine(); // Clear buffer

    // Validation check [cite: 74]
                       if (playlistIndex >= 0 && playlistIndex < Collection.getPlayLists().size()) {
                          PlayList selectedPL = Collection.getPlayList(playlistIndex);
                          updateSubMenu(selectedPL, library, reader); // Call the sub-menu method
    } 
                       else {
                           System.out.println("Invalid play-list selection.");
    }
                       
                       // sub menu.............................................
                       
                       
                       
                   
                       
                       
                       break;
                    
                   case 4:
                       
                       System.out.println(Collection.toString());
                       System.out.print("Enter playlist number to delete (0 to return): ");
                       int delIndex = reader.nextInt();
                       reader.nextLine();
                       if (delIndex > 0) {
                          Collection.removePlayList(delIndex - 1);
                          System.out.println("PlayList is deleting.................");
                          System.out.println("Playlist is Deleted Successfully!");
                       }
                       
                       System.out.println("exiting...");
                       break;
                       
                   case 5:
                       System.out.println("Exiting...........");
                       break;
                       
                       
                   default:
                       // inform to user type the number between the range,if they choose wrong number....
                       System.out.println("Please Select the choice between of range(1-5");
                       break;
               
               }
               
               
           }
           else{
               // check the is it numeric or not. orelse inform to customer input the number
               System.out.println("Error: please Select Number");
               reader.next();
           
           }
              
        }
        
        
        
    }
    
                    // this is the updateSubMenu methode
                    public  static void updateSubMenu(PlayList selectedPlayList, MusicLibrary library, Scanner reader){
                        //Display Choices
                          int subChoice=0;
                          while (subChoice != 5) {
                             System.out.println("\n--- Updating: " + selectedPlayList.getName()+ " ---");
                             System.out.println("1. Rename play-list");
                             System.out.println("2. Add a song");
                             System.out.println("3. Remove a song");
                             System.out.println("4. Reorder play-list");
                             System.out.println("5. Return to main menu");
                             System.out.print("Enter option: ");
                       
                            //hasNextInt for Ensure is that Number.......
                             if (reader.hasNextInt()){
                                subChoice=reader.nextInt();
                                reader.nextLine();
                                switch (subChoice){
                                    
                                    
                                    case 1:
                                    
                                      System.out.println("Enter New Name:");
                                      selectedPlayList.rename(reader.nextLine());
                                      break;
                                    case 2:
                                        handleAddSong(selectedPlayList,library,reader);
                                        break;
                                        
                                        
                                    case 3:
                                        System.out.println("This is  TrackList");
                                        System.out.println(selectedPlayList.getTrackList());
                                        System.out.println("please Enter the Number of Song:");
                                        selectedPlayList.removeSong(reader.nextInt()-1);
                                        reader.nextLine();//Clear the selection/buffer
                                        break;
                                        
                                    case 4:   
                                        System.out.println(selectedPlayList.getTrackList());
                                        System.out.println("Enter the Song Number to move:");
                                        int from=reader.nextInt()-1;
                                        System.out.println(selectedPlayList.getTrackList());
                                        System.out.println("which place you like to move");
                                        int to = reader.nextInt()-1;
                                        reader.nextLine();
                                        selectedPlayList.moveSong(from,to);
                                        break;
                                        
                                        
                                        
                                        
                                        
                                    
                                    
                                    
               
               
               
               }
                       
                       
                       
               }
                          }
               
               
               
                    
}
        
         // This methode for searching  and add song           
        public static  void handleAddSong(PlayList selectedPlayList, MusicLibrary library,Scanner reader){
            while(true){
                System.out.println("Enter Search Title:(Empty to return mainmenu)");
                String title=reader.nextLine();
                if(title.isEmpty())
                    break;
                ArrayList <Song> results=library.search(title); 
                
                if(results.isEmpty()){
                    System.out.println("No songs Found...");
                 
                
                    
                
                }
                else{
                    for (int i = 0; i < results.size(); i++) {
                    System.out.println((i + 1) + ". " + results.get(i).toString());
                }
                System.out.print("Enter number to add (0 to return): ");
                int songChoice = reader.nextInt();
                reader.nextLine();
                if (songChoice > 0 && songChoice <= results.size()) {
                    selectedPlayList.addSong(results.get(songChoice - 1));
                    System.out.println("Song added succesfully!");
                }
                
                
                }
                    
                
                
                }
                
            
            
            
            }
        
            
            
            
        
        
        }   



