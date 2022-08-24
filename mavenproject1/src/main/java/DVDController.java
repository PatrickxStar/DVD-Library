/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick Xiong
 */
import java.util.*;
import java.io.*;
// java.util is the util library which already contain certian functions, while the asterisk means using it all. 
public class DVDController {
    private DVDLibrary model;
    // The DVDLibrary.java has now been brought into a different class and set as the term moodel. 
    private DVDView view;
    
    public DVDController(DVDLibrary model, DVDView view){
        this.model = model;
        this.view = view;
        
    }
    
    public List<String> getDvdInfo(){
        // Tells us getDvdInfo is returning a String list. Bringing it up to the front . the title, release date, and etc. 
        String info[] = new String[]{model.getTitle(), model.getReleaseDate(), model.getMpaaRating(), model.getDirectorsName(), model.getStudio(), model.getUserRating()};
        //Declaring the array
        List<String> list = Arrays.asList(info);
        // Making an array into a list and declaring the list as a string. 
        
        return list;
    }
    
    public void setDvdInfo(String DvdTitle, String DvdReleaseDate, String DvdMpaaRating, String DvdDirectorsName, String DvdStudio, String DvduserRating){
        // This is our basic setter
        model.setTitle(DvdTitle);
        model.setReleaseDate(DvdReleaseDate);
        model.setMpaaRating(DvdMpaaRating);
        model.setDirectorsName(DvdDirectorsName);
        model.setStudio(DvdStudio);
        model.setUserRating(DvduserRating);
        
    }
    
    public void showDvdView(){
        view.printDvdDetails(model.getTitle(), model.getReleaseDate(), model.getMpaaRating(), model.getDirectorsName(), model.getStudio(), model.getUserRating());
    }
    
    public void saveDvdInfo(List <String> DvdInfo) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("DVDFile.txt"));
        // This prints out the Dvdtitle, DvdReleaseDate, etc. to the front.
        //The PrintWriter sends the text to the DVDFile.txt where it also brings the given texts out as well. 
        out.println(DvdInfo.get(0));
        out.println(DvdInfo.get(1));
        out.println(DvdInfo.get(2));
        out.println(DvdInfo.get(3));
        out.println(DvdInfo.get(4));
        out.println(DvdInfo.get(5));
        out.flush();
        out.close();
    }
    public void loadDVDinfo() throws Exception {
        List<String> info = new ArrayList<String>();
        Scanner sc = new Scanner(
        new BufferedReader(new FileReader("DVDFile.txt")));
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            info.add(currentLine);
        } 
        model.setTitle(info.get(0));
        model.setReleaseDate(info.get(1));
        model.setMpaaRating(info.get(2));
        model.setDirectorsName(info.get(3));
        model.setStudio(info.get(4));
        model.setUserRating(info.get(5));
        
    }
}
