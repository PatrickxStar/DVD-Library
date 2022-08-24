
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick Xiong
 */
public class DVDMainDemo { 
    public static void main(String[] args){
        DVDLibrary model = null;
        try{ 
            model = loadDVDinfo();
        } catch (Exception ie) {
            System.out.println(ie);
            // Catches the errors before the program fails. This will also show us where the error is located. (ie) is the exception it is telling us. 
        }
        DVDView view = new DVDView();
        DVDController controller = new DVDController(model, view);
        /*try{
        controller.saveDvdInfo(controller.getDvdInfo());
        } catch(Exception ie){
            System.out.println(ie);
        }*/

        controller.showDvdView();
        controller.setDvdInfo("Finale", "August 26, 2022", "R", "Patrick Xiong", "Thailand", "Awful");
        controller.showDvdView();
    }
   private static DVDLibrary newDVD(){
       DVDLibrary dvd = new DVDLibrary();
       // dvd is the object we are creating in this instance, then we "set" the variable to a specirfic name. 
       //Once the program is ran, the getters will bring these variable from the setters to the front. 
       dvd.setTitle("Finale");
       dvd.setReleaseDate("August 26, 2022");
       dvd.setMpaaRating("R");
       dvd.setDirectorsName("Patrick Xiong");
       dvd.setStudio("Thailand");
       dvd.setUserRating("Great");
       //The orange texts will soon change to the original variable like title, release date , etc because we want this program to be a default so others can edit it. 
       
       return dvd;
   }
   //Getters do not auatomatically bring the vairbale to the front, until we put 
   public void saveDvdInfo(List <String> DvdInfo) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("DVDFile.txt"));
        //Declares and initializes PrintWriter as out to write a file called DVDFile.txt
        //The ones below is geting the information from above and printing it into the text file. 0 correlates to Finale while 1 correlates to August 26, 2022. And so on and so forth. 
        out.println(DvdInfo.get(0));
        out.println(DvdInfo.get(1));
        out.println(DvdInfo.get(2));
        out.println(DvdInfo.get(3));
        out.println(DvdInfo.get(4));
        out.println(DvdInfo.get(5));
        out.flush();
        out.close();
    }
    public static DVDLibrary loadDVDinfo() throws Exception {
        DVDLibrary dvd = new DVDLibrary();
        List<String> info = new ArrayList<String>();
        Scanner sc = new Scanner(
        new BufferedReader(new FileReader("DVDFile.txt")));
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            info.add(currentLine);
        } 
        dvd.setTitle(info.get(0));
        dvd.setReleaseDate(info.get(1));
        dvd.setMpaaRating(info.get(2));
        dvd.setDirectorsName(info.get(3));
        dvd.setStudio(info.get(4));
        dvd.setUserRating(info.get(5));
        
        return dvd;
        
    }
}
