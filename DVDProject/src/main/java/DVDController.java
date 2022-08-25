import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Patrick Xiong
 */
public class DVDController {
    //Creating a composition within this instance. 
    private DVDModel model;
    private DVDView view;

    //Constructor methodl; initializes the state of an object.
    public DVDController(DVDModel model, DVDView view) {
        this.model = model;
        this.view = view;
    }

    //Declaring a list of the variables for the user. Brings information from the DVD into a String list. 
    public List<String> getDvdInfo(){
        String info[] = new String[]{model.getTitle(), model.getReleaseDate(), model.getMpaaRating(), model.getDirectorsName(), model.getStudio(), model.getUserRating()};
        List<String> list = Arrays.asList(info);
        return list;
    }

    //Giving value to the model variables 
    public void setDvdInfo(String DvdTitle, String DvdReleaseDate, String DvdMpaaRating, String DvdDirectorsName, String DvdStudio, String DvduserRating){

        model.setTitle(DvdTitle);
        model.setReleaseDate(DvdReleaseDate);
        model.setMpaaRating(DvdMpaaRating);
        model.setDirectorsName(DvdDirectorsName);
        model.setStudio(DvdStudio);
        model.setUserRating(DvduserRating);
    }   

    //Prints out current DVD information
    public void showCurrentDvdInfo() {
        view.printDvdDetails(model.getTitle(), model.getReleaseDate(), model.getMpaaRating(), model.getDirectorsName(), model.getStudio(), model.getUserRating());
    }

    //Taking information from the Array list into the text file and saving it. 
    public void saveDvdInfo(List<String> DvdInfo) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("DVDFile.txt"));
        if(out != null) {
            out.println(DvdInfo.get(0));
            out.println(DvdInfo.get(1));
            out.println(DvdInfo.get(2));
            out.println(DvdInfo.get(3));
            out.println(DvdInfo.get(4));
            out.println(DvdInfo.get(5));
            out.flush();
            out.close();
        }

        System.out.println("Data saved into collection");
    }

    //Located in DVDmain java file. Opening text file and searching for information to set the correct variables. (Making sure they are in order) 
    //Created a nested array list. (list within a list) 
    public static Collection<DVDModel> getDVDCollection(Collection<DVDModel> dvdCollection) throws Exception{
        List<String> info = new ArrayList<String>();
        DVDModel model = new DVDModel();

        Scanner sc = new Scanner(new BufferedReader(new FileReader("DVDFile.txt")));

        while(sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            info.add(currentLine);
        }

        if(info != null) {
            model.setTitle(info.get(0));
            model.setReleaseDate(info.get(1));
            model.setMpaaRating(info.get(2));
            model.setDirectorsName(info.get(3));
            model.setStudio(info.get(4));
            model.setUserRating(info.get(5));
        }

        dvdCollection.add(model);

        return dvdCollection;
    }

    //Loads the array list into the text file. 
    public DVDModel loadDVDinfo(DVDModel model) throws Exception {
        List<String> info = new ArrayList<String>();
        Scanner sc = new Scanner(
        new BufferedReader(new FileReader("DVDFile.txt")));
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            info.add(currentLine);
        } 

        if(info != null) {
            model.setTitle(info.get(0));
            model.setReleaseDate(info.get(1));
            model.setMpaaRating(info.get(2));
            model.setDirectorsName(info.get(3));
            model.setStudio(info.get(4));
            model.setUserRating(info.get(5));
        }

        System.out.println("Model has been loaded");
        return model;
    }

}
