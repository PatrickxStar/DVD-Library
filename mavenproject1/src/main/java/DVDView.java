/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Patrick Xiong
 *This method is to print the details of the DVD. 
 * 
 */
public class DVDView {
    public void printDvdDetails(String title, String releaseDate, String mpaaRating, String directorsName, String studio, String userRating){
        System.out.println("Title: " + title);
        // the orange texts will print out exatcly what is stated "Title." While the black text while print out what i set the title vaible as. 
        //For example: Title: Finale
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Mpaa Rating: " + mpaaRating);
        System.out.println("Directors Name: " + directorsName);
        System.out.println("Studio: " + studio);
        System.out.println("User Rating: " + userRating);
    }
    
}
