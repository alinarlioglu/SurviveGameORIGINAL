/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Timer;
import java.util.TimerTask;
/**
 * Creates a timer which starts once the game is executed. It's used as the primary method of scoring within the game.
 * @author Ali Narlioglu
 */
public class Time extends Timer{

    /**
     * Initialises an integer that stores the seconds passed once the game is executed.
     */
    public int secondsPassed = 0;
    
    /**
     * Creates a 'Timer' class instance.
     */
    Timer time = new Timer();
    
    /**
     * Declares a visible 'Game' class instance.
     */
    Game game;
    
    /**
     * Links the visible and declared 'Game' class instance to initialised instance in another class.
     * @param game 'Game' class instance.
     */
    public Time(Game game) {
        this.game = game;
    }
    
    /**
     * Creates the timer and assigns 'secondsPassed' variable to hold the time passed since the game is executed.
     * The amount of seconds passed since the game is executed is compared to the amount of seconds required to pass the level.
     * Once the requirement of finishing the level is met, then the 'goNextLevel' method is run by the 'Game' class instance.
     */
    TimerTask task = new TimerTask(){
        public void run(){
            secondsPassed++;
            System.out.println("Seconds passed: "+secondsPassed);
            if(secondsPassed==game.getWorld().getFinishLevel()) {
                game.goNextLevel();
            }
        }
    };

    /**
     * Starts the timer.
     */
    public void start() {
        time.scheduleAtFixedRate(task,0,1000);
    }
    
    /**
     * Stops the timer.
     */
    public void stop() {
        time.cancel();
    }

    /**
     * Returns 'secondsPassed' variable - used in 'Score' class to find the highest score achieved by the user.
     * @return The integer value.
     */
    public int getSecondsPassed() {
        return secondsPassed;
    }

    /**
     * Returns the 'game' instance.
     * @return The 'Game' class instance.
     */
    public Game getGame() {
        return game;
    }
    
        
}
