import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Patrick Xiong
 */
public class DVDMain {
   //Runs the program
    public static void main(String[] args) {
        DVDModel model = new DVDModel();

        DVDView view = new DVDView();

        DVDController controller = new DVDController(model, view);

        List<DVDModel> dvdCollection = new ArrayList<DVDModel>();

        boolean menu = true;

        String menuInput = "";
        Scanner input = new Scanner(System.in);

        getDVDCollection(dvdCollection);
        while(menu) {
            menu();
            menuInput = input.nextLine();
            switch(menuInput) {
                case "1":
                    System.out.println("-----Add DVD-----");
                    DVDModel newModel = new DVDModel();
                    String addInput;
                    System.out.println("Enter title");
                    addInput = input.nextLine();
                    newModel.setTitle(addInput);

                    System.out.println("Enter date");
                    addInput = input.nextLine();
                    newModel.setReleaseDate(addInput);

                    System.out.println("Enter MPAA rating");
                    addInput = input.nextLine();
                    newModel.setMpaaRating(addInput);

                    System.out.println("Enter director's name");
                    addInput = input.nextLine();
                    newModel.setDirectorsName(addInput);

                    System.out.println("Enter studio's name");
                    addInput = input.nextLine();
                    newModel.setStudio(addInput);

                    System.out.println("Enter user rating");
                    addInput = input.nextLine();
                    newModel.setUserRating(addInput);

                    dvdCollection.add(newModel);
                    System.out.println("New DVD added to collection");
                    System.out.println();
                    createFile(dvdCollection);
                    break;
                case "2": 
                    String removeDVDInput;
                    System.out.println("-----Remove DVD-----");

                    for(int i = 0; i < dvdCollection.size(); i++) {
                        System.out.println(dvdCollection.get(i).getTitle());
                    }

                    if(dvdCollection.size() == 0) {
                        System.out.println("No collection exists");
                    }else {

                        System.out.println("Enter the title of the DVD you want to remove");
                        removeDVDInput = input.nextLine();

                        for(int i = 0; i < dvdCollection.size(); i++) {
                            if(removeDVDInput.equalsIgnoreCase(dvdCollection.get(i).getTitle())) {
                                dvdCollection.remove(i);
                                System.out.println("DVD was removed");
                                System.out.println("-----New Collection DVD List-----");
                                for(int j = 0; j < dvdCollection.size(); j++) {
                                        System.out.println(dvdCollection.get(j).getTitle());
                                }
                            }else {
                                System.out.println(removeDVDInput + " does not exist in the collection");
                            }
                        }
                    }

                    System.out.println("Press enter to continue...");
                    input.nextLine();
                    createFile(dvdCollection);
                    break;
                case "3":
                    boolean exist = false;
                    boolean newChange = false;
                    DVDModel editModel = null;;
                    String editDVDInput;
                    System.out.println("-----Edit DVD Details");
                    for(int i = 0; i < dvdCollection.size(); i++) {
                        System.out.println(dvdCollection.get(i).getTitle());
                    }

                    if(dvdCollection.size() == 0) {
                        System.out.println("No collection exists");
                    }else {

                        System.out.println("Enter the title of the DVD you want to edit");
                        editDVDInput = input.nextLine();

                        for(int i = 0; i < dvdCollection.size(); i++) {
                            if(editDVDInput.equalsIgnoreCase(dvdCollection.get(i).getTitle())) {
                                exist = true;
                            editModel = dvdCollection.get(i);
                            }
                        }

                        if(exist) {
                            System.out.println("-----Edit DVD Details-----");
                            System.out.println("1) Title");
                            System.out.println("2) Release Date");
                            System.out.println("3) MPAA Rating");
                            System.out.println("4) Director's Name");
                            System.out.println("5) Studio");
                            System.out.println("6) User Rating");
                            System.out.println("Input 1-6:");
                            editDVDInput = input.nextLine();
                            switch(editDVDInput) {
                            case "1":
                                System.out.println("Enter the new title");
                                editDVDInput = input.nextLine();
                                editModel.setTitle(editDVDInput);
                                newChange = true;
                                break;
                            case "2":
                                System.out.println("Enter the new release date");
                                editDVDInput = input.nextLine();
                                editModel.setReleaseDate(editDVDInput);
                                newChange = true;
                                break;
                            case "3":
                                System.out.println("Enter the new MPAA rating");
                                editDVDInput = input.nextLine();
                                editModel.setMpaaRating(editDVDInput);
                                newChange = true;
                                break;
                            case "4":
                                System.out.println("Enter the new director's name");
                                editDVDInput = input.nextLine();
                                editModel.setDirectorsName(editDVDInput);
                                newChange = true;
                                break;
                            case "5":
                                System.out.println("Enter the new studio");
                                editDVDInput = input.nextLine();
                                editModel.setStudio(editDVDInput);
                                newChange = true;
                                break;
                            case "6":
                                System.out.println("Enter the new user rating");
                                editDVDInput = input.nextLine();
                                editModel.setUserRating(editDVDInput);
                                newChange = true;
                                break;
                            default: 
                                System.out.println("That is not a correct input. Please enter a number from 1 - 6");
                            }

                        }else {
                            System.out.println("That title does not exist");
                        }
                    }

                    if(newChange) {
                        System.out.println("DVD details updated!");
                        System.out.println("-----Updated DVD Details-----");
                        view.printDvdDetails(editModel.getTitle(), editModel.getReleaseDate(), editModel.getMpaaRating(), editModel.getDirectorsName(), editModel.getStudio(), editModel.getUserRating());
                        createFile(dvdCollection);
                    }
                    System.out.println("Press enter to go back to menu...");
                    input.nextLine();

                    break;
                case "4": 
                    System.out.println("-----DVD Collection-----");
                    if(dvdCollection.size() == 0) {
                        System.out.println("No collection exists");
                    }else {
                        for(int i = 0; i < dvdCollection.size(); i++) {
                            System.out.println(dvdCollection.get(i).getTitle());
                        }
                        System.out.println();
                    }
                    System.out.println("Press enter to go back to menu...");
                    input.nextLine();

                    break;
                case "5": 
                    String dvdTitleInput;
                    System.out.println("-----Choose DVD Title-----");

                    if(dvdCollection.size() == 0) {
                        System.out.println("No collection exists");
                    }else {
                        for(int i = 0; i < dvdCollection.size(); i++) {
                            System.out.println(dvdCollection.get(i).getTitle());
                        }

                        System.out.println("Type in the DVD title to see details");
                        dvdTitleInput = input.nextLine();

                        for(int i = 0; i < dvdCollection.size(); i++) {
                            if(dvdTitleInput.equalsIgnoreCase(dvdCollection.get(i).getTitle())) {
                                System.out.println("-----DVD Details-----");
                                System.out.println(dvdCollection.get(i).getTitle());
                                System.out.println(dvdCollection.get(i).getReleaseDate());
                                System.out.println(dvdCollection.get(i).getMpaaRating());
                                System.out.println(dvdCollection.get(i).getDirectorsName());
                                System.out.println(dvdCollection.get(i).getStudio());
                                System.out.println(dvdCollection.get(i).getUserRating());
                            }else {
                                System.out.println(dvdTitleInput + " does not exist in the collection");
                            }
                        }
                    }

                    System.out.println("Press enter to go back to menu...");
                    input.nextLine();

                    break;
                case "6": 
                    String searchTitleInput;
                    System.out.println("-----Search for DVD Titles-----");

                    if(dvdCollection.size() == 0) {
                        System.out.println("No collection exists");
                    }else {
                        System.out.println("Type in the DVD title to see if it exists");
                        searchTitleInput = input.nextLine();

                        boolean exists = false;
                        for(int i = 0; i < dvdCollection.size(); i++) {
                            if(searchTitleInput.equalsIgnoreCase(dvdCollection.get(i).getTitle())) {
                                exists = true;
                            }
                        }

                        if(exists) {
                            System.out.println("DVD exists in collection!");
                        }else {
                            System.out.println(searchTitleInput + " does not exist in collection!");
                        }
                    }

                    System.out.println("Press enter to go back to menu...");
                    input.nextLine();


                    break;
                case "7":
                    menu = false;;
                    break;
                default: System.out.println("That is not a correct input. Please enter a number from 1 - 7");
            }
        }
    }
	
    //Prints out DVD main menu
    public static void menu() {
        System.out.println("-----Menu-----");
        System.out.println("1) Add DVD");
        System.out.println("2) Remove DVD");
        System.out.println("3) Edit DVD Detail");
        System.out.println("4) Show DVD Collection");
        System.out.println("5) Display DVD Detail");
        System.out.println("6) Search for DVD");
        System.out.println("7) Exit");
        System.out.println("Input 1-7:");
        System.out.println("");
    }

    //Opens textfile while searching for data. Once the data is found it is put into a list. 
    //Setting variables to its correct value. & putting it into a list. Checking if there is also any data in the text file
    public static List<DVDModel> getDVDCollection(List<DVDModel> dvdCollection){
        List<String> info = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("DVDFile.txt")));

            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                if(!currentLine.isEmpty()) {
                    info.add(currentLine);

                    if(info.size() == 6) {
                        DVDModel model = new DVDModel();
                        if(info != null) {
                        model.setTitle(info.get(0));
                        model.setReleaseDate(info.get(1));
                        model.setMpaaRating(info.get(2));
                        model.setDirectorsName(info.get(3));
                        model.setStudio(info.get(4));
                        model.setUserRating(info.get(5));

                        info.clear();
                    }

                        dvdCollection.add(model);
                    }
                }
            }
        }catch(Exception e) {
            System.out.println("No collection was found");
        }

        return dvdCollection;
    }

    //Loads information from text file to array list 
    public static DVDModel loadDVDInfo(DVDModel model) {
        List<String> info = new ArrayList<String>();
        try {
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
        }catch(Exception e) {
            System.out.println("Error when loading DVD info");
            System.out.println(e);
        }

        System.out.println("Model has been loaded");
        return model;
}

    //Loads information from array list to the text file. 
    public static void createFile(List<DVDModel> dvdCollection){
        try {
            PrintWriter out = new PrintWriter(new FileWriter("DVDFile.txt"));
            if(out != null) {
                for(int i = 0; i < dvdCollection.size(); i++) {
                    out.println(dvdCollection.get(i).getTitle());
                    out.println(dvdCollection.get(i).getReleaseDate());
                    out.println(dvdCollection.get(i).getMpaaRating());
                    out.println(dvdCollection.get(i).getDirectorsName());
                    out.println(dvdCollection.get(i).getStudio());
                    out.println(dvdCollection.get(i).getUserRating());
                    out.println();
                }
                out.flush();
                out.close();
            }
        }catch(Exception e) {
            System.out.println("Trouble with saving file");
        }

        System.out.println("Data saved into collection");
    }

}
