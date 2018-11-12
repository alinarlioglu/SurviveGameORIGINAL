/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Stores user scores and finds the highest score achieved by the user. It creates a file, stores data in the file, reads the file and compares the integers within the file to find the highest score.
 * @author Ali Narlioglu
 */
public class Score implements Serializable{

    /**
     * Reads the data within the file.
     */
    private BufferedReader reader;
    
    /**
     * Stores data within the file.
     */
    private BufferedWriter writer; 
    
    /**
     * Creates a file.
     */
    private File scoreFile;
    
    /**
     * A list of integers read from the file.
     */
    private List<Integer> scores;
    
    /**
     * An integer variable. Initialised to time, thus user's score is kept here.
     */
    private int total;
    
    /**
     * An integer variable. Used to store the read integers from the file and is added to the list of integers (which is 'scores').
     */
    private int highscore;
    
    /**
     * Declares a visible 'Time' class instance.
     */
    Time time;

    /**
     * Creates a file if the file doesn't exist. Initialises the list of integers called 'scores'.
     * @param time 'Time' class instance.
     * @throws IOException The compiler will throw an IOException, however the 'Score' class constructor informs the compiler that nothing will be done about the IOException. Therefore, the compiler will continue to execute code as it is.
     */
    public Score(Time time) throws IOException{
        this.time=time;
        scores = new ArrayList<Integer>();
        scoreFile = new File("myScores.txt");
        if(!scoreFile.exists()){
                scoreFile.createNewFile(); //Creates a file if the doesn't exist
        }
    }       

    /**
     * Changes the 'scores' list to a new list of integers.
     * @param scores The list to overwrite.
     */
    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
    
    /**
     * Changes the 'time' instance to a new instance.
     * @param time 'Time' class instance.
     */
    public void setTime(Time time) {
        this.time = time;
    }
    
    /**
     * Removes any blank spaces within the file - useful whilst trying to read the specific integers stored in the file.
     * @param string The space to remove
     * @return The string to read back.
     */
    public static boolean isEmpty(final String string)  
            {  
               return string == null  || string.trim().isEmpty();  
            }

    /**
     * Initialises the integer variable total to seconds passed since the game is executed.
     */
    public void secondsPassed(){
        total=time.getSecondsPassed();
    }

    /**
     * Returns the total variable.
     * @return The integer value.
     */
    public int getTotal() {
        return total;
    }
    
    /**
     * Writes the user's score to the file, and reads the integers stored within the file. 
     * @throws IOException The compiler will throw an IOException when executing this method, however this method informs the compiler that nothing will be done about the IOException. Therefore, the compiler will continue to execute code as it is.
     */
    public void writeToFile() throws IOException{
        try {
            //Writes strings, integers, decimals et cetera - into the file
            writer = new BufferedWriter(new FileWriter("mynameScores.txt", true));
            //Adds the total value into the file once lives reaches 0.
            writer.write(new Integer(total).toString()); 
            //Makes it easier to read the file and less errors when trying to convert the numbers from the file into an arraylist
            writer.newLine(); 
            //Reads the integers within the file
            reader = new BufferedReader(new FileReader("mynameScores.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Read each line of the file and convert the integer within the specific line from a string to an integer, then it proceeds to add the integer to the 'scores' list.
     * @return 'scores' - list of integers.
     * @throws IOException The compiler will throw an IOException when executing this method, however this method informs the compiler that nothing will be done about the IOException. Therefore, the compiler will continue to execute code as it is.
     */
    public List<Integer> getScores() throws IOException { try { 
        String s;
        while((s = reader.readLine()) != null){
            if(!isEmpty(s)){
                highscore = Integer.parseInt(s.trim());
                //All the integers within the arraylist is the previous high scores
                scores.add(highscore);
            }
        }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    return scores;
    }
    
    /**
     * The user's current score is compared to the highest score found in the 'scores' list, then the relevant higher score is returned which is picked up by the 'MyView' class and displays it on the screen.
     * If the user's score is greater than the highest score found in 'scores' list, then it's stored to the file as well as being returned. Also, the user's score is added to the 'scores' list as well if it's higher than the greatest score found within the file.
     * @return Highest score achieved by user.
     * @throws IOException The compiler will throw an IOException when executing this method, however this method informs the compiler that nothing will be done about the IOException. Therefore, the compiler will continue to execute code as it is.
     */
    public int readFromFile() throws IOException{
        try {
            //Uses collections to compare the total integer with the maximum integer within the arraylist 
            if(total>Collections.max(scores)){
                scores.add(total);
                //Closes the writer
                writer.close(); 
                //If total is higher than the maximum integer within the arraylist, then it prints total
                System.out.println("Congratulations, you've beaten the high score! New high score: " + total);
                //Returns total, so it can be used to display the high score inside the game using MyView
                return total;
            }
            else {
                System.out.println("Almost beat the high score.....");
                //Returns the maximum integer within the arraylist, and it's used within MyView to display the current high score
                return Collections.max(scores);
            }
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return readFromFile();
    }
    
    /**
     * Finds the second highest score in the 'scores' list.
     * @return Second highest user score.
     */
    public int secondHighScore(){
        Collections.sort(scores);
        System.out.println(scores.toString());
        return scores.get(scores.size()-2);
    }
    
    /**
     * Finds the third highest score in the 'scores' list.
     * @return Third highest user score.
     */
    public int thirdHighScore(){
        Collections.sort(scores);
        return scores.get(scores.size()-3);
    }
    
    /**
     * Displays the 'scores' list in a understandable format.
     * @return 'scores' list.
     */
    public String displayScores(){
        return scores.toString();
    }
}

   
