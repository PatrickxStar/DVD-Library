/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Patrick Xiong
 * The point of this folder is to declare fields/variables and make them into getters and setters. 
 * Although the fields have not been given any value, this is creating an outline for the program. 
 * With no value, the getters are not able to bring anything from the setters yet until later on. 
 */
public class DVDLibrary { 
    //Declaring Variables
    private String title; 
    private String releaseDate; 
    private String mpaaRating; 
    private String directorsName;
    private String studio;
    private String userRating; 
    
    //The above is declaring fields to obtain getters and setters. 
    public String getTitle(){
        return title; 
    }
    
    // Setters stay in the background while getters bring the fields to the front. 
    public void setTitle(String title){
        this.title = title; 
    }
    // Void means nothing is being returned. Setters set new variable value to a new value. 
    public String getReleaseDate(){
        return releaseDate;
    }
    //Each method is a funtion for the program. A function contains those texts included in the curly brackets. 
    //Until a new curly bracket is created which will in turn create a new function. 
    public void setReleaseDate(String releaseDate){ 
        this.releaseDate = releaseDate;
    }
    //Four pillars of Java - Abstraction, polymorphism, Encapsulation, Inheritence. 
    //Inheritence - Creates a parent class and child class. Example ( Parents class: Dog ; Child class: German Sherpherd .
    //Parent class also known as super class or base class; whjile child class is also known as subclass, extened class, or derived class. 
    public String getMpaaRating(){
        return mpaaRating;
    }
    
    public void setMpaaRating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    public String getDirectorsName(){
        return directorsName;
    }
    
    public void setDirectorsName(String directorsName){
        this.directorsName = directorsName;
    }
    
    public String getStudio(){
        return studio;
    }
    
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public String getUserRating(){
        return userRating;
    }
    
    public void setUserRating(String userRating){
        this.userRating = userRating;
    }
}
