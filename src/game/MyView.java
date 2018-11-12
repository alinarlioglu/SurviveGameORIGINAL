/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 * Displays the user's score, lives left, background images and text on the game window.
 * @author Ali Narlioglu
 */
public class MyView extends UserView {
    
    /**
     * Declares a visible instance of 'Time' class.
     */
    Time time;
    
    /**
     * Declares a visible instance of the 'Character' class.
     */
    Character character;
    
    /**
     * Declares a non-visible variable to hold the background image of each level.
     */
    private Image background;
    
    /**
     * Declares a non-visible 'Score' class instance.
     */
    private Score highscore;
    
    /**
     * Declares a visible 'Game' class instance.
     */
    Game game;
    
    /**
     * Constructs a declared and linked 'Time' and 'Game' instances to the initialised 'Time' and 'Game' instances in the other classes.
     * Also, initialises the 'Score' class instance as well the background image variable.
     * @param world The world the game will be initialised in.
     * @param width Width of the view.
     * @param height Height of the view.
     * @param time 'Time' class instance
     * @param game 'Game' class instance.
     */
    public MyView(GameLevel world, int width, int height, Time time, Game game) {
        super(world, width, height);
        this.time=time;
        this.game=game;
        background = new ImageIcon("data/creepy.jpg").getImage();
        
        try {
            //Creating a score object to measure the player's high score.
            highscore = new Score(time);
        } catch (IOException ex) {
           System.out.println("There's an error");
        }
    }

    /**
     * Returns the 'Character' class instance.
     * @return 'Character' class instance.
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Changes the 'Character' class instance.
     * @param character The variable to hold the new instance.
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * Returns the 'Score' class instance.
     * @return 'Score' class instance.
     */
    public Score getHighscore() {
        return highscore;
    }
    
    /**
     * Changes the background image of each level of the game.
     * @param g Instance of 'Graphics2D' class which controls the appearance of the game.
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        if(game.getLevel()==1){
            g.drawImage(background, 0, 0, this);
        }
        else if(game.getLevel()==2){
            background = new ImageIcon("data/darkCartoon.jpeg").getImage();
            g.drawImage(background, 0, 0, this);
        }
        else if(game.getLevel()==3){
            background = new ImageIcon("data/darkCartoon2.jpeg").getImage();
            g.drawImage(background, 0, 0, this);
        }
        else if(game.getLevel()==4){
            background = new ImageIcon("data/darkCartoon3.jpeg").getImage();
            g.drawImage(background, 0, 0, this);
        }
    }
    
    /**
     * Displays 'Character' instance's lives and score. When lives reach zero, the highest score achieved by the user is displayed as well. Also, text such as "Game Over!" is displayed on the game window as well when lives reach zero.
     * @param g Instance of 'Graphics2D' class which controls the appearance of the game.
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        //Displaying user's lives and current score
        g.setColor(Color.white);
        g.drawString("Lives: "+character.getLives(), 20, 40);
        g.setColor(Color.white);
        //Initializes total variable to seconds passed. Total variable is used to record the user's current score.
        highscore.secondsPassed(); 
        g.drawString("Score: " + time.getSecondsPassed(), 20, 60);
        if(character.getLives()==0){
            
            try {
                //Stopping the current time and recording the score, and returning the highest achieved score by the user.
                time.stop();
                highscore.writeToFile();
                highscore.getScores();
                //Stopping the music
                game.getWorld().stopSound();
                g.drawString("High score: "+highscore.readFromFile(), 20, 100);
                g.drawString("Game Over!", 20, 80);
                g.drawString("Top three high scores: "+highscore.readFromFile()+", "+highscore.secondHighScore()+", "+highscore.thirdHighScore(), 165, 250);
            } catch (IOException ex) {
                System.out.println("Why isn't this working?");
            }
        }
    }
    
    /**
     * Returns the 'Time' class instance.
     * @return 'Time' class instance.
     */
    public Time getTime() {
        return time;
    }
    
    /**
     * Changes the 'time' instance to a new instance.
     * @param time 'Time' class instance.
     */
    public void setTime(Time time){
        this.time=time;
    }

    
    
}
