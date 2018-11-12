/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import city.cs.engine.WorldView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Enables the user to control the 'Character' class instance by moving the mouse around the game window.
 * @author Ali Narlioglu
 */
public class mouseMovement extends MouseMotionAdapter {

    /**
     * Declares an instance of 'WorldView' class.
     */
    private WorldView view;
    
    /**
     * Declares an instance of 'GameLevel' class.
     */
    private GameLevel world;
    
    /***
     * Declares an instance of 'Character' class.
     */
    private Character character;
    
    /**
     * Declares an instance of 'Ball' class.
     */
    private Ball ball;
    
    /**
     * Declares an instance of 'PowerUp' class.
     */
    private PowerUp powerUp;
    
    /**
     * Declares a visible instance of 'MyView' class.
     */
    MyView view2;
    
    /**
     * Declares an instance of 'Collision' class.
     */
    private Collision collision;
   
    /**
     * Creates a constructor that links and declares the instances of 'view', 'world', 'view2' to their initialised instances in other classes.
     * Also, initialises the 'character' instance as well as the 'collision' instance, then it proceeds to add the 'collision' instance to the 'character' instance via 'addCollisionListener' method.
     * @param view Instance of 'WorldView'.
     * @param world Instance of 'GameLevel'.
     * @param view2 Instance of 'MyView'.
     */
    public mouseMovement(WorldView view, GameLevel world, MyView view2) {
        this.view = view;
        this.world = world;
        this.view2=view2;
        character = new Character(world);
        collision = new Collision(character,powerUp,view2.getTime(), view2.getHighscore()); 
        character.addCollisionListener(collision);
    }

    /**
     * Returns the 'collision' instance.
     * @return Instance of 'Collision' class.
     */
    public Collision getCollision() {
        return collision;
    }
    
    /**
     * Returns the 'character' instance. 
     * @return Instance of 'Character' class.
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Allows the 'character' instance to move in position of where the mouse is placed at within the game window.
     * @param e The MouseEvent which detects the movement.
     */
    //Allows the player's character to move in line with the mouse
    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        character.setPosition(view.viewToWorld(e.getPoint()));
    }   
}
