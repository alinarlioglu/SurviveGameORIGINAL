/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Restarts the current level if the user presses the specified key.
 * @author Ali Narlioglu
 */
public class Restart extends KeyAdapter{

    /**
     * Declares a visible 'GameLevel' class instance.
     */
    GameLevel world;
    
    /**
     * Declares a visible 'Character' class instance.
     */
    Character character;
    
    /**
     * Declares a visible 'Time' class instance.
     */
    Time time;
    
    /**
     * Declares a visible 'Game' class instance.
     */
    Game game;
    
    /**
     * Declares a visible 'MyView' class instance.
     */
    MyView view;
    
    /**
     * Declares a visible 'Score' class instance.
     */
    Score highscore;

    /**
     * Constructs a declared and linked instances of GameLevel, Character, Time, Game, MyView and Score classes to the initialised instances in the other classes.
     * @param world The world to construct the 'Restart' in.
     * @param character 'Character' class instance - the playable user-controlled character.
     * @param time 'Time' class instance
     * @param game 'Game' class instance - the managing of levels.
     * @param view 'MyView' class instance - handles the interface.
     * @param highscore 'Score' class instance - manages the player's score.
     */
    public Restart(GameLevel world, Character character, Time time, Game game, MyView view, Score highscore) {
        this.world = world;
        this.character=character;
        this.time=time;
        this.game=game;
        this.view=view;
        this.highscore=highscore;
    }
    
    /**
     * Restarts the current level by re-initialising certain instances.
     * @param e The KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && character.getLives()==0){
            //Stop current time
            time.stop();
            //Create a new time
            time = new Time(game);
            //Pass the new time to the view
            view.setTime(time);
            //Pass the new time to the highscore
            highscore.setTime(time);
            //Pass the new time to GameLevel
            game.getWorld().setTime(time);
            //Run the game!
            world.start(); 
            //Reset character lives
            character.fixedLives();
            //Start the new time!
            time.start();
        }
            
    }

    /**
     * Returns the 'Time' class instance.
     * @return 'Time' class instance.
     */
    public Time getTime() {
        return time;
    }
}
