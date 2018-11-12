/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;

/**
 * An abstract class which constructs a basis for the 'LevelOne', 'LevelTwo', 'LevelThree' and 'LevelFour' classes which enables the game levels to change.
 * @author Ali Narlioglu
 */
public abstract class GameLevel extends World {
    
    /**
     * Declares an instance of 'Time' class.
     */
    private Time time;
    
    /**
     * Declares an integer variable that the subclasses - LevelOne, LevelTwo, LevelThree and LevelFour can change.
     */
    protected int finishLevel = 3;
    
    /**
     * Declares an instance of 'SoundClip' class that the subclasses - LevelOne, LevelTwo, LevelThree and LevelFour can manipulate and change.
     */
    protected SoundClip gameMusic;

    /**
     * Returns an integer value needed to finish the current level.
     * @return The integer value.
     */
    public abstract int getFinishLevel();
    
    /**
     * Adds instances and objects to the current level.
     * @param game The class used to initialise the changing of levels.
     */
    public void populate(Game game) {
        
    }

    /**
     * Returns the instance of 'SoundClip' class.
     * @return Instance of 'SoundClip' class.
     */
    public abstract SoundClip getGameMusic();
    
    /**
     * Returns a boolean value checking if the current level's finishing requirements are met.
     * @return True or false.
     */
    public abstract boolean isCompleted();
    
    /**
     * Stops the background music of the level.
     */
    public abstract void stopSound();
    
    /**
     * Changes the 'time' instance.
     * @param time 'Time' classes' instance. 
     */
    public void setTime(Time time){
        this.time=time;
    }
}
